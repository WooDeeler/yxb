package com.kongke.infrastructure.persistent.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kongke.domain.chat.model.dto.ChatReq;
import com.kongke.domain.chat.model.entity.GroupChatsEntity;
import com.kongke.domain.chat.model.vo.GroupChatsVO;
import com.kongke.domain.chat.model.vo.GroupListVO;
import com.kongke.domain.chat.model.vo.GroupMsgVO;
import com.kongke.domain.chat.repository.ChatRepo;
import com.kongke.domain.chat.utils.Convert;
import com.kongke.infrastructure.persistent.dao.GroupChatsDao;
import com.kongke.infrastructure.persistent.dao.GroupListDao;
import com.kongke.infrastructure.persistent.dao.GroupMsgDao;
import com.kongke.infrastructure.persistent.po.GroupChatsPO;
import com.kongke.infrastructure.persistent.po.GroupListPO;
import com.kongke.infrastructure.persistent.po.GroupMsgPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class IChatRepo implements ChatRepo {

    @Autowired
    private GroupChatsDao groupChatsDao;

    @Autowired
    private GroupListDao groupListDao;

    @Autowired
    private GroupMsgDao groupMsgDao;


    @Override
    public boolean createGroupChat(GroupChatsVO vo) {
        return groupChatsDao.save(Convert.convert(vo, GroupChatsPO.class));
    }

    @Override
    public GroupChatsEntity getGroupChatById(Integer gid) {
        return Convert.convert(groupChatsDao.getById(gid), GroupChatsEntity.class);
    }

    @Override
    public boolean updateGroupChat(GroupChatsVO vo) {
        return groupChatsDao.updateById(Convert.convert(vo, GroupChatsPO.class));
    }

    @Override
    public boolean deleteGroupChat(Integer gid) {
        return groupChatsDao.removeById(gid);
    }

    @Override
    public boolean joinGroup(ChatReq req) {
        GroupChatsPO po = groupChatsDao.getById(req.getGid());
        String list = po.getMemberList();
        if (list == null) {
            list = req.getUid().toString();
        } else {
            list += "," + req.getUid().toString();
        }
        po.setMemberList(list);
        GroupListPO groupList = new GroupListPO();
        groupList.setGroupId(req.getGid());
        groupList.setUserId(req.getUid());
        groupList.setGroupName(po.getName());
        groupList.setLatestTime(new Date(System.currentTimeMillis()));
        groupList.setLatestMessage("新消息");
        groupListDao.save(groupList);
        return groupChatsDao.updateById(po);
    }

    @Override
    public boolean leaveGroup(ChatReq req) {
        GroupChatsPO po = groupChatsDao.getById(req.getGid());
        String list = po.getMemberList();
        if (list == null) {
            return false;
        } else {
            String[] split = list.split(",");
            StringBuilder sb = new StringBuilder();
            for (String s : split) {
                if (!s.equals(req.getUid().toString())) {
                    sb.append(s).append(",");
                }
            }
            list = sb.substring(0, sb.length() - 1);
        }
        po.setMemberList(list);
        groupListDao.remove(new LambdaQueryWrapper<GroupListPO>()
                .eq(GroupListPO::getGroupId, req.getGid())
                .eq(GroupListPO::getUserId, req.getUid()));
        return groupChatsDao.updateById(po);
    }

    @Override
    public List<GroupListVO> getGroupListByUserId(Integer uid) {
        List<GroupListPO> list = groupListDao.list(new LambdaQueryWrapper<GroupListPO>()
                .orderByDesc(GroupListPO::getLatestTime)
                .eq(GroupListPO::getUserId, uid));
        ArrayList<GroupListVO> vos = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (GroupListPO po : list) {
                vos.add(Convert.convert(po, GroupListVO.class));
            }
        }
        return vos;
    }

    @Override
    public boolean sendGroupMessage(GroupMsgVO vo) {
        if (vo.getGroupId() != null && vo.getUid() != null && vo.getContent() != null) {
            return groupMsgDao.save(Convert.convert(vo, GroupMsgPO.class));
        }
        return false;
    }

    @Override
    public List<GroupMsgVO> getGroupMessages(Integer gid) {
        List<GroupMsgPO> list = groupMsgDao.list(new LambdaQueryWrapper<GroupMsgPO>()
                .orderByAsc(GroupMsgPO::getSendTime)
                .eq(GroupMsgPO::getGroupId, gid));
        if (list != null && !list.isEmpty()) {
            ArrayList<GroupMsgVO> vos = new ArrayList<>();
            for (GroupMsgPO po : list) {
                vos.add(Convert.convert(po, GroupMsgVO.class));
            }
            return vos;
        }
        return Collections.emptyList();
    }
}

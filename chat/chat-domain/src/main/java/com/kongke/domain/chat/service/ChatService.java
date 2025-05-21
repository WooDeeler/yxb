package com.kongke.domain.chat.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.kongke.domain.chat.model.dto.ChatReq;
import com.kongke.domain.chat.model.entity.GroupChatsEntity;
import com.kongke.domain.chat.model.entity.GroupListEntity;
import com.kongke.domain.chat.model.vo.GroupChatsVO;
import com.kongke.domain.chat.model.vo.GroupListVO;
import com.kongke.domain.chat.model.vo.GroupMsgVO;
import com.kongke.domain.chat.repository.ChatRepo;
import com.kongke.domain.chat.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepo chatRepo;

    public boolean createGroupChat(GroupChatsVO vo) {
        vo.setMemberList(String.valueOf(vo.getOwnerId()));
        return chatRepo.createGroupChat(vo);
    }

    public GroupChatsVO getGroupChatById(Integer gid) {
        GroupChatsEntity entity = chatRepo.getGroupChatById(gid);
        return Convert.convert(entity, GroupChatsVO.class);
    }

    public boolean updateGroupChat(GroupChatsVO groupChatsVO) {
        if (groupChatsVO == null || groupChatsVO.getId() == null || groupChatsVO.getId() <= 0) {
            return false;
        }
        return chatRepo.updateGroupChat(groupChatsVO);
    }

    public boolean deleteGroupChat(Integer gid) {
        if (gid == null || gid <= 0) {
            return false;
        }
        return chatRepo.deleteGroupChat(gid);
    }

    /**
     * 群组操作
     * 就是更新PO的userList字段
     */
    public boolean joinGroup(ChatReq req) {
        if (req == null || req.getGid() <= 0 || req.getUid() <= 0)
            return false;
        return chatRepo.joinGroup(req);
    }
    public boolean leaveGroup(ChatReq req) {
        if (req == null || req.getGid() <= 0 || req.getUid() <= 0)
            return false;
        return chatRepo.leaveGroup(req);
    }


    public List<GroupListVO> getGroupListByUserId(Integer uid) {
        if (uid == null || uid <= 0) {
            return new ArrayList<>();
        }
        return chatRepo.getGroupListByUserId(uid);
    }


    public boolean sendGroupMessage(GroupMsgVO vo) {
        if(vo == null || vo.getGroupId() == null || vo.getUid() == null)
            return false;
        return chatRepo.sendGroupMessage(vo);
    }

    public List<GroupMsgVO> getGroupMessages(Integer gid) {
        if (gid == null || gid <= 0) {
            return new ArrayList<>();
        }
        return chatRepo.getGroupMessages(gid);

    }

    public List<GroupChatsVO> queryGroup(ChatReq req) {
        if (req == null || StrUtil.isBlank(req.getName()))
            return new ArrayList<>();
        return chatRepo.queryGroup(req);
    }
}

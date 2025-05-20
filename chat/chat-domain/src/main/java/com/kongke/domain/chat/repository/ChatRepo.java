package com.kongke.domain.chat.repository;

import com.kongke.domain.chat.model.dto.ChatReq;
import com.kongke.domain.chat.model.entity.GroupChatsEntity;
import com.kongke.domain.chat.model.vo.GroupChatsVO;
import com.kongke.domain.chat.model.vo.GroupListVO;
import com.kongke.domain.chat.model.vo.GroupMsgVO;

import java.util.List;

public interface ChatRepo {
    boolean createGroupChat(GroupChatsVO groupChatsVO);

    GroupChatsEntity getGroupChatById(Integer gid);

    boolean updateGroupChat(GroupChatsVO groupChatsVO);


    boolean deleteGroupChat(Integer gid);


    boolean joinGroup(ChatReq req);

    boolean leaveGroup(ChatReq req);

    List<GroupListVO> getGroupListByUserId(Integer uid);

    boolean sendGroupMessage(GroupMsgVO vo);

    List<GroupMsgVO> getGroupMessages(Integer gid);

    List<GroupChatsVO> queryGroup(ChatReq req);
}

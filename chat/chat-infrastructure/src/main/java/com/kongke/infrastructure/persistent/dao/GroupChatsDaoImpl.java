package com.kongke.infrastructure.persistent.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.persistent.po.GroupChatsPO;
import com.kongke.infrastructure.persistent.mapper.GroupChatsMapper;
import org.springframework.stereotype.Service;

/**
* @author mico
* @description 针对表【group_chats】的数据库操作Service实现
* @createDate 2025-05-18 17:49:41
*/
@Service
public class GroupChatsDaoImpl extends ServiceImpl<GroupChatsMapper, GroupChatsPO>
    implements GroupChatsDao {

}





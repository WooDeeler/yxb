package com.kongke.infrastructure.persistent.mapper;

import com.kongke.infrastructure.persistent.po.GroupChatsPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mico
* @description 针对表【group_chats】的数据库操作Mapper
* @createDate 2025-05-18 17:49:41
* @Entity com.kongke.infrastructure.dao.po.GroupChatsPO
*/
@Mapper
public interface GroupChatsMapper extends BaseMapper<GroupChatsPO> {

}





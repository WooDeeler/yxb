package com.kongke.infrastructure.persistent.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.persistent.po.GroupMsgPO;
import com.kongke.infrastructure.persistent.mapper.GroupMsgMapper;
import org.springframework.stereotype.Service;

/**
* @author mico
* @description 针对表【group_msg】的数据库操作Service实现
* @createDate 2025-05-18 17:55:09
*/
@Service
public class GroupMsgDaoImpl extends ServiceImpl<GroupMsgMapper, GroupMsgPO>
    implements GroupMsgDao {

}





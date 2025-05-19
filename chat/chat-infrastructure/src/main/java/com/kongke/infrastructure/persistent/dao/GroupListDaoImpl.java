package com.kongke.infrastructure.persistent.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.persistent.po.GroupListPO;
import com.kongke.infrastructure.persistent.mapper.GroupListMapper;
import org.springframework.stereotype.Service;

/**
* @author mico
* @description 针对表【group_list】的数据库操作Service实现
* @createDate 2025-05-18 17:53:25
*/
@Service
public class GroupListDaoImpl extends ServiceImpl<GroupListMapper, GroupListPO>
    implements GroupListDao {

}





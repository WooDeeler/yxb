package com.kongke.infrastructure.persistent.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.persistent.dao.UserDao;
import com.kongke.infrastructure.persistent.dao.mapper.UserMapper;
import com.kongke.infrastructure.persistent.po.UserPO;
import org.springframework.stereotype.Service;

/**
* @author mico
* @description 针对表【users】的数据库操作Service实现
* @createDate 2025-05-03 18:54:27
*/
@Service
public class UserDaoImpl extends ServiceImpl<UserMapper, UserPO>
    implements UserDao {

}





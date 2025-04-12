package com.kongke.infrastructure.persistent.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongke.infrastructure.persistent.dao.UserDao;
import com.kongke.infrastructure.persistent.po.UserPO;
import com.kongke.infrastructure.persistent.dao.mapper.UserMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
* @author kongke
* @description 针对表【user】的数据库操作Service实现
* @createDate 2025-04-06 01:59:29
*/
@Service
@Repository
public class UserDaoImpl extends ServiceImpl<UserMapper, UserPO>
    implements UserDao {

}





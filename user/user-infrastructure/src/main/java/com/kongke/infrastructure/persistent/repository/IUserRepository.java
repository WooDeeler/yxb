package com.kongke.infrastructure.persistent.repository;

import com.kongke.domain.userlogin.model.entity.UserEntity;
import com.kongke.domain.userlogin.repository.UserRepository;
import com.kongke.infrastructure.persistent.dao.UserDao;
import com.kongke.infrastructure.persistent.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserRepository implements UserRepository {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUserById(Long id) {
        UserPO po = userDao.getById(id);
        UserEntity entity = new UserEntity();
        entity.setUsername(po.getUsername());
        return entity;
    }
}

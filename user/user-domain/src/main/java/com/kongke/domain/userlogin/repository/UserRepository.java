package com.kongke.domain.userlogin.repository;

import com.kongke.domain.userlogin.model.entity.UserEntity;

/**
* @author kongke
* @createDate 2025-04-06 01:59:29
*/
public interface UserRepository {
    UserEntity getUserById(Long id);
}

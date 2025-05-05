package com.kongke.domain.userlogin.repository;

import com.kongke.domain.userlogin.model.entity.UserEntity;
import com.kongke.domain.userlogin.model.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

/**
* @author kongke
* @createDate 2025-04-06 01:59:29
*/
public interface UserRepository {
    UserVO getUserById(Integer id);

    List<UserVO> getUsersByPage(int page, int size);

    UserEntity findByUsername(String username);

    Boolean upsertProfile(UserVO vo);

    List<UserEntity> batchQueryByIds(List<Integer> ids);
}

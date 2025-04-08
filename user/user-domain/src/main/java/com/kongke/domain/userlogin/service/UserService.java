package com.kongke.domain.userlogin.service;

import com.kongke.domain.userlogin.model.entity.UserEntity;
import com.kongke.domain.userlogin.model.vo.UserVO;
import com.kongke.domain.userlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 业务逻辑层
 *
 * @author kongke
 * @date 2025/04/07
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserVO getUserById(Long id) {
        UserEntity entity = userRepository.getUserById(id);
        UserVO vo = new UserVO();
        vo.setUsername(entity.getUsername());
        return vo;
    }
}

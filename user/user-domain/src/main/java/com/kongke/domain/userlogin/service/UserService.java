package com.kongke.domain.userlogin.service;

import cn.hutool.core.bean.BeanUtil;
import com.kongke.domain.userlogin.model.entity.UserEntity;
import com.kongke.domain.userlogin.model.vo.UserVO;
import com.kongke.domain.userlogin.repository.UserRepository;
import com.kongke.domain.userlogin.utils.SecurityUtils;

import java.util.List;

import lombok.extern.flogger.Flogger;
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
        return userRepository.getUserById(id);
    }

    public List<UserVO> getUsersByPage(int page, int size) {
        // Implement pagination logic here
        return userRepository.getUsersByPage(page, size);
    }


    public UserVO login(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            return new UserVO();
        }
        if (password == null || password.trim().isEmpty()) {
            return new UserVO();
        }

        UserEntity entity = userRepository.findByUsername(username);
        if (entity == null) {
            return new UserVO();
        }

        String encryptedPassword = SecurityUtils.md5Hex(password);
        if (!encryptedPassword.equals(entity.getPassword())) {
            return new UserVO();
        }

        UserVO vo = new UserVO();
        BeanUtil.copyProperties(entity,vo);
        return vo;
    }
}

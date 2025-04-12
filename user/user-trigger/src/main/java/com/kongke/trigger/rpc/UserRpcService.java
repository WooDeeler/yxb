package com.kongke.trigger.rpc;

import com.kongke.api.IUserService;
import com.kongke.api.dto.UserDTO;
import com.kongke.domain.userlogin.model.vo.UserVO;
import com.kongke.domain.userlogin.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * rpc实现
 *
 * @author kongke
 * @date 2025/04/07
 */
@DubboService
public class UserRpcService implements IUserService {

    @Autowired
    private UserService userService;

    @Override
    public UserDTO getUserById(Long id) {
        UserVO vo = userService.getUserById(id);
        UserDTO dto = new UserDTO();
        dto.setUsername(vo.getUsername());
        return dto;
    }
}

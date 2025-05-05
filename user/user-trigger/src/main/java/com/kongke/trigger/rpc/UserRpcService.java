package com.kongke.trigger.rpc;

import cn.hutool.core.bean.BeanUtil;
import com.kongke.api.IUserService;
import com.kongke.api.dto.UserDTO;
import com.kongke.domain.userlogin.model.vo.UserVO;
import com.kongke.domain.userlogin.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * rpc实现
 *
 * @author kongke
 * @date 2025/04/07
 */
@Service
@DubboService
public class UserRpcService implements IUserService {

    @Autowired
    private UserService userService;

    @Override
    public UserDTO getUserById(Integer id) {
        UserVO vo = userService.getUserById(id);
        UserDTO dto = new UserDTO();
        BeanUtil.copyProperties(vo, dto);
        return dto;
    }

    @Override
    public Map<Integer, UserDTO> batchQueryByIds(List<Integer> ids) {
        List<UserVO> vos = userService.batchQueryByIds(ids);
        if (vos.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap<Integer, UserDTO> map = new HashMap<>();
        for (UserVO vo : vos) {
            UserDTO dto = new UserDTO();
            BeanUtil.copyProperties(vo, dto);
            map.put(vo.getId(), dto);
        }
        return map;
    }
}

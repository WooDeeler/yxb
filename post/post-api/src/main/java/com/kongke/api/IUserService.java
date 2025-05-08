package com.kongke.api;

import com.kongke.api.dto.UnivDTO;
import com.kongke.api.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * userApi接口
 *
 * @author kongke
 * @date 2025/04/07
 */
public interface IUserService {
    UserDTO getUserById(Integer id);
    Map<Integer, UserDTO> batchQueryByIds(List<Integer> ids);
}

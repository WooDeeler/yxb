package com.kongke.api;

import com.kongke.api.dto.UserDTO;

/**
 * api接口
 *
 * @author kongke
 * @date 2025/04/07
 */
public interface IUserService {
    UserDTO getUserById(Long id);
}

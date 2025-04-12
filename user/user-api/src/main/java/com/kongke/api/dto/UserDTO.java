package com.kongke.api.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * User DTO
 *
 * @author kongke
 * @date 2025/04/07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * User ID
     */
    private Long id;

    /**
     * Username
     */
    private String username;

    /**
     * Email
     */
    private String email;

    /**
     * Phone number
     */
    private String phone;

    /**
     * User status (0: disabled, 1: enabled)
     */
    private Integer status;

    /**
     * Create time
     */
    private LocalDateTime createTime;

    /**
     * Update time
     */
    private LocalDateTime updateTime;


}

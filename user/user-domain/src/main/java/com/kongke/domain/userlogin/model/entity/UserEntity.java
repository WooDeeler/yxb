package com.kongke.domain.userlogin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * User ID
     */
    private Long id;

    /**
     * Username
     */
    private String username;

    private String password;

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

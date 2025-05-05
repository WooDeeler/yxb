package com.kongke.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
     * 用户唯一标识，自增主键
     */
    private Integer id;

    /**
     * 用户昵称，用于在系统中显示的名称
     */
    private String username;



    /**
     * 用户注册时使用的手机号码
     */
    private String phone;

    /**
     * 用户注册时间，默认为当前时间
     */
    private Date registerTime;

    /**
     * 用户头像的存储路径或 URL
     */
    private String avatar;

    /**
     * 用户的目标院校名称
     */
    private String targetUniversity;

    /**
     * 用户所在年级，如大一、研二等
     */
    private String grade;

    /**
     * 用户所学专业名称
     */
    private String major;

    /**
     * 用户所在城市
     */
    private String city;


}

package com.kongke.trigger.http;

import com.kongke.domain.common.model.Result;
import com.kongke.domain.userlogin.model.dto.LoginRequest;
import com.kongke.domain.userlogin.model.vo.UserVO;
import com.kongke.domain.userlogin.service.UserService;

import java.util.List;

import com.kongke.domain.userlogin.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 *
 * @author kongke
 * @date 2025/05/04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/test")
    public String test() {
        return "test";
    }

    /**
     * 获取用户信息
     *
     * @param uid uid
     * @return {@link Result }<{@link UserVO }>
     */
    @GetMapping("/getUser")
    public Result<UserVO> getUser(@RequestParam("uid") Integer uid) {
        return Result.success(userService.getUserById(uid));
    }

    /**
     * 分页获取用户
     *
     * @param page 页
     * @param size 大小
     * @return {@link Result }<{@link List }<{@link UserVO }>>
     */
    @GetMapping("/page")
    public Result<List<UserVO>> getUsersByPage(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return Result.success(userService.getUsersByPage(page, size));
    }

    /**
     * 更新用户信息
     *
     * @param vo VO
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/upsert")
    public Result<Boolean> upsertUserProfile(@RequestBody UserVO vo){
        return Result.success(userService.upsertProfile(vo));
    }

    /**
     * 登录
     *
     * @param request 请求
     * @return {@link Result }<{@link UserVO }>
     */
    @PostMapping("/login")
    public Result<UserVO> login(@RequestBody LoginRequest request) {
        UserVO vo = userService.login(request.getUsername(), request.getPassword());
        return Result.success(vo);
    }
}

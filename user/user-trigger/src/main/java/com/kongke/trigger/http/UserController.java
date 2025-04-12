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

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/getUser")
    public Result<UserVO> getUser(@RequestParam("uid") Long uid) {
        return Result.success(userService.getUserById(uid));
    }

    @GetMapping("/page")
    public Result<List<UserVO>> getUsersByPage(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return Result.success(userService.getUsersByPage(page, size));
    }

    @PostMapping("/login")
    public Result<UserVO> login(@RequestBody LoginRequest request) {
        UserVO vo = userService.login(request.getUsername(), request.getPassword());
        // 生成JWT Token
        String token = SecurityUtils.generateToken(vo.getUsername());
        vo.setToken(token);
        return Result.success(vo);
    }
}

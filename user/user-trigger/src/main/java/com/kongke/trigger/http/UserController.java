package com.kongke.trigger.http;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.kongke.api.dto.UserDTO;
import com.kongke.domain.common.model.Result;
import com.kongke.domain.userlogin.model.dto.LoginRequest;
import com.kongke.domain.userlogin.model.dto.UserReq;
import com.kongke.domain.userlogin.model.vo.UserVO;
import com.kongke.domain.userlogin.service.UserService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 按 ID 批量查询用户信息
     *
     * @param req 要求
     * @return {@link Result }<{@link Map }<{@link Integer }, {@link UserVO }>>
     */
    @PostMapping("/batchUsers")
    public Result<Map<Integer, UserVO>> batchQueryByIds(@RequestBody UserReq req) {
        List<UserVO> vos = userService.batchQueryByIds(req.getIds());
        if (vos.isEmpty()) {
            return Result.error(2, "err");
        }
        HashMap<Integer, UserVO> map = new HashMap<>();
        for (UserVO vo : vos) {
            map.put(vo.getId(), vo);
        }
        return Result.success(map);
    }

    /**
     * 更新用户信息
     *
     * @param vo VO
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/upsert")
    public Result<Boolean> upsertUserProfile(@RequestBody UserVO vo){
        if (vo == null || vo.getId() == null)
            return Result.error(400, "参数错误");
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
        System.out.println(vo);
        return StrUtil.isBlank(vo.getUsername()) ? Result.error(510, "登陆失败") : Result.success(vo);
    }
}

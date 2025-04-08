package com.kongke.trigger.http;

import com.kongke.domain.userlogin.model.vo.UserVO;
import com.kongke.domain.userlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserTestController {

    @Autowired
    private UserService userService;


    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/getUser")
    public UserVO getUser(@RequestParam("uid") Long uid) {
        return userService.getUserById(uid);
    }
}

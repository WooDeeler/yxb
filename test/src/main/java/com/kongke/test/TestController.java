package com.kongke.test;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {

    @PostMapping("/post")
    public List<Result> test(@RequestBody Result res) {
        List<Result> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(res);
        }
        return list;
    }

    @GetMapping("/get")
    public String test() {
        return "hello";
    }

}

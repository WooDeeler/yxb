package com.kongke.test;

import lombok.Data;

@Data
public class Result {

    private String msg;

    private Integer code;


    public Result(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

}

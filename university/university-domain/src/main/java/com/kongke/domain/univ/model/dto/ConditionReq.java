package com.kongke.domain.univ.model.dto;

import lombok.Data;

@Data
public class ConditionReq {
    /**
     * 类型
     */
    private String type;
    /**
     * 城市
     */
    private String city;
    /**
     * 名字
     */
    private String name;
}

package com.kongke.domain.univ.model.dto;

import lombok.Data;

@Data
public class ConditionReq {

    private int page = 1;

    private int size = 10;

    /**
     * 类型
     */
    private String type;
    /**
     * 城市
     */
    private String city;
    /**
     * 院校名称
     */
    private String univName;

    /**
     * 院校ID
     */
    private Integer univId;

    /**
     * 年份
     */
    private String years;

    /**
     * 专业名称
     */
    private String majorName;


    /**
     * 文件类型
     */
    private Integer fileType;

    /**
     * 材料类型
     */
    private Integer materialType;


}

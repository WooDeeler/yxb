package com.kongke.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnivDTO {
    /**
     * 院校信息唯一标识，自增主键
     */
    private Integer id;

    /**
     * 院校的名称
     */
    private String name;

    /**
     * 分类tag
     */
    private String majorInfo;

    /**
     * 院校的类型，如综合性大学、专科院校等
     */
    private String type;

    /**
     * 院校的简介，包含学校历史、特色等信息
     */
    private String introduction;

    /**
     * 院校所在城市
     */
    private String city;

    /**
     * 院校校徽的存储路径或 URL
     */
    private String badge;

    /**
     * 院校的相关标签，用于分类和搜索
     */
    private String tags;
}

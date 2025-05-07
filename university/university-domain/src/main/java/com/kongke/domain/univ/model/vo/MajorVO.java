package com.kongke.domain.univ.model.vo;

import lombok.Data;

/**
 * 
 * @TableName major
 */
@Data
public class MajorVO {
    /**
     * 记录唯一标识，自增主键
     */
    private Integer id;

    /**
     * 所属院校的 ID，关联 university_info 表的 id 字段
     */
    private Integer universityId;

    /**
     * 院校名称
     */
    private String universityName;

    /**
     * 专业的名称
     */
    private String majorName;

    /**
     * 专业的年份，如 2020、2021 等
     */
    private String years;

    /**
     * 专业的类型
     */
    private Integer type;

    /**
     * 分数线
     */
    private Integer score;

    /**
     * 国家线
     */
    private Integer countryScore;
}
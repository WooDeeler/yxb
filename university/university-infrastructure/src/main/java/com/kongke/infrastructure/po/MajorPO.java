package com.kongke.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName major
 */
@TableName(value ="major")
@Data
public class MajorPO {
    /**
     * 记录唯一标识，自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 所属院校的 ID，关联 university_info 表的 id 字段
     */
    private Integer universityId;

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
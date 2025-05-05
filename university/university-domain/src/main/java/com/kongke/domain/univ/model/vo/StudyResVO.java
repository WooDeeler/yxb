package com.kongke.domain.univ.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * 
 * @TableName study_res
 */
@Data
public class StudyResVO {
    /**
     * 学习资料唯一标识，自增主键
     */
    private Integer id;

    /**
     * 学习资料的文件名
     */
    private String name;

    /**
     * 学习资料的文件类型，如 PDF、DOC 等
     */
    private Integer fileType;

    /**
     * 学习资料的类型，如课件、真题等
     */
    private Integer materialType;

    /**
     * 学习资料的文件大小，单位根据实际情况而定
     */
    private Integer memorySize;

    /**
     * 学习资料创建时间，默认为当前时间
     */
    private Date createTime;

    /**
     * 学习资料修改时间，每次更新时自动更新为当前时间
     */
    private Date updateTime;
}
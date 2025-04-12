package com.kongke.domain.discussPost.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Data
public class DiscussPostVO implements Serializable {
    private static final long serialVersionUID = 1;
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String content;

    /**
     * 0-普通; 1-置顶;
     */
    private Integer type;

    /**
     * 0-正常; 1-精华; 2-拉黑;
     */
    private Integer status;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Integer commentCount;

    /**
     * 
     */
    private Double score;
}
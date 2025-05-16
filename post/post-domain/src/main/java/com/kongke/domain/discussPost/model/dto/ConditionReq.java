package com.kongke.domain.discussPost.model.dto;

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
     * 帖子/新闻，标题
     */
    private String title;

    /**
     * 标签
     */
    private String tag;


}

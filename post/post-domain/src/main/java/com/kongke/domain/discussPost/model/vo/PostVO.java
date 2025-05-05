package com.kongke.domain.discussPost.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Data
public class PostVO implements Serializable {
    private static final long serialVersionUID = 1;
    private Integer id;

    /**
     * 帖子的标题，用于吸引用户关注
     */
    private String title;

    /**
     * 帖子的正文内容，包含详细信息
     */
    private String content;

    /**
     * 帖子作者的用户 ID，关联 users 表的 id 字段
     */
    private Integer authorId;
    private String userName;
    private String avatar;
    private String userUniversity;
    private boolean isLiked;

    /**
     * 帖子发布时间，默认为当前时间
     */
    private Date createTime;

    /**
     * 帖子更新时间，每次更新时自动更新为当前时间
     */
    private Date updateTime;

    /**
     * 帖子的点赞数量，初始值为 0
     */
    private Integer likes;

    /**
     * 帖子的标签，用于分类和搜索
     */
    private String tags;

    /**
     * 帖子中包含的图片列表，存储图片的路径或 URL
     */
    private String imageList;

    /**
     * 帖子的评论列表，可存储评论的相关信息
     */
    private String comments;

    /**
     * 帖子的发布地点
     */
    private String location;

}
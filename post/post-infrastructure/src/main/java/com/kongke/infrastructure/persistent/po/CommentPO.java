package com.kongke.infrastructure.persistent.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName comments
 */
@TableName(value ="comments")
@Data
public class CommentPO {
    /**
     * 评论唯一标识，自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 评论所属帖子的 ID，关联 posts 表的 id 字段
     */
    private Integer postId;

    /**
     * 评论者的用户 ID，关联 users 表的 id 字段
     */
    private Integer uid;

    /**
     * 评论的具体内容
     */
    private String content;

    /**
     * 评论发布时间，默认为当前时间
     */
    private Date createTime;

    /**
     * 父评论的 ID，用于实现多级评论，关联 comments 表的 id 字段
     */
    private Integer pid;

    /**
     * 父评论名称
     */
    private String superName;

}
package com.kongke.infrastructure.persistent.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName news
 */
@TableName(value ="news")
@Data
public class NewsPO {
    /**
     * 新闻资讯唯一标识，自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 新闻资讯的主题，用于概括内容
     */
    private String theme;

    /**
     * 新闻资讯的标题，吸引用户阅读
     */
    private String title;

    /**
     * 
     */
    private String images;

    /**
     * 新闻资讯的正文内容，包含详细信息
     */
    private String content;

    /**
     * 新闻资讯的标签，用于分类和搜索
     */
    private String tags;

    /**
     * 新闻资讯关联的院校
     */
    private String relatedUniversity;

    /**
     * 新闻资讯的发布来源，如网站、媒体等
     */
    private String publishSource;

    /**
     * 新闻资讯发布时间，默认为当前时间
     */
    private Date publishTime;

}
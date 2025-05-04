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
     * 新闻资讯关联的院校id
     */
    private Integer relatedUniversity;

    /**
     * 新闻资讯的发布来源，如网站、媒体等
     */
    private String publishSource;

    /**
     * 新闻资讯发布时间，默认为当前时间
     */
    private Date publishTime;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        NewsPO other = (NewsPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(other.getTheme()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getImages() == null ? other.getImages() == null : this.getImages().equals(other.getImages()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getRelatedUniversity() == null ? other.getRelatedUniversity() == null : this.getRelatedUniversity().equals(other.getRelatedUniversity()))
            && (this.getPublishSource() == null ? other.getPublishSource() == null : this.getPublishSource().equals(other.getPublishSource()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTheme() == null) ? 0 : getTheme().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getImages() == null) ? 0 : getImages().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getRelatedUniversity() == null) ? 0 : getRelatedUniversity().hashCode());
        result = prime * result + ((getPublishSource() == null) ? 0 : getPublishSource().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", theme=").append(theme);
        sb.append(", title=").append(title);
        sb.append(", images=").append(images);
        sb.append(", content=").append(content);
        sb.append(", tags=").append(tags);
        sb.append(", relatedUniversity=").append(relatedUniversity);
        sb.append(", publishSource=").append(publishSource);
        sb.append(", publishTime=").append(publishTime);
        sb.append("]");
        return sb.toString();
    }
}
package com.kongke.domain.chat.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * 
 */
@Data
public class GroupChatsVO {
    /**
     * 群聊唯一标识，自增主键
     */
    private Integer id;

    /**
     * 群聊的名称
     */
    private String name;

    /**
     * 群聊群主的用户 ID，关联 users 表的 id 字段
     */
    private Integer ownerId;

    /**
     * 群聊创建时间，默认为当前时间
     */
    private Date createTime;

    /**
     * 群聊的类型，如学习群、交流群等
     */
    private String type;

    /**
     * 群聊的状态，如正常、禁用等
     */
    private Integer status;

    /**
     * 群聊的相关标签，用于分类和搜索
     */
    private String tags;

    /**
     * 群聊的成员列表，存储成员的用户 ID 等信息
     */
    private String memberList;
}
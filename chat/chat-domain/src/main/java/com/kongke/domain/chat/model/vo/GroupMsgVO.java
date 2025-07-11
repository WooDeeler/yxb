package com.kongke.domain.chat.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * 
 */
@Data
public class GroupMsgVO {
    /**
     * 聊天记录唯一标识，自增主键
     */
    private Integer id;

    /**
     * 聊天记录所属群聊的 ID，关联 group_chats 表的 id 字段
     */
    private Integer groupId;

    /**
     * 消息发送者的用户 ID，关联 users 表的 id 字段
     */
    private Integer uid;

    /**
     * 消息的具体内容
     */
    private String content;

    private String userName;
    private String avatar;

    /**
     * 消息发送时间，默认为当前时间
     */
    private Date sendTime;
}
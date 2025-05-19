package com.kongke.infrastructure.persistent.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName group_msg
 */
@TableName(value ="group_msg")
@Data
public class GroupMsgPO {
    /**
     * 聊天记录唯一标识，自增主键
     */
    @TableId(type = IdType.AUTO)
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

    /**
     * 消息发送时间，默认为当前时间
     */
    private Date sendTime;
}
package com.kongke.infrastructure.persistent.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName group_list
 */
@TableName(value ="group_list")
@Data
public class GroupListPO {
    /**
     * 群聊列表记录唯一标识，自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户的 ID，关联 users 表的 id 字段
     */
    private Integer userId;

    /**
     * 群聊的 ID，关联 group_chats 表的 id 字段
     */
    private Integer groupId;

    /**
     * 群聊的名称
     */
    private String groupName;

    /**
     * 群聊的最新消息内容
     */
    private String latestMessage;

    /**
     * 群聊最新消息的发送时间
     */
    private Date latestTime;
}
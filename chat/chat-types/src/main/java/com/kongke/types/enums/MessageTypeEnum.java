package com.kongke.types.enums;

/**
 * 消息类型枚举
 *
 *
 */
public enum MessageTypeEnum {
	TEXT("普通文本消息"),
	HEARTBEAT("心跳数据"),
	REGISTER("注册数据");
	
	MessageTypeEnum(String desc) {
	}
}

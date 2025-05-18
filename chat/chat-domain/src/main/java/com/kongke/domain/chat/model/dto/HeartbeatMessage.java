package com.kongke.domain.chat.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
public class HeartbeatMessage implements Serializable {
	
	private static final long serialVersionUID = 1290124171105321491L;
	
	
	/**
	 * 发送心跳消息的用户Id
	 */
	private String userId;

}

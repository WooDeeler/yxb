package com.kongke.domain.chat.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
public class RegisterMessage implements Serializable {
	
	private static final long serialVersionUID = -4953615574208683170L;
	/**
	 * 注册到服务端的用户Id
	 */
	private String userId;
}

package com.kongke.domain.chat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserChatDTO implements Serializable {
	
	private static final long serialVersionUID = 3147392908880170895L;
	
	/**
	 * 用户Id
	 */
	private String userId;
	
	/**
	 * 用户名
	 */
	private String username;
	
}

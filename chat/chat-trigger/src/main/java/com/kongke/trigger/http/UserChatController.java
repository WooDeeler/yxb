package com.kongke.trigger.http;

import com.kongke.domain.chat.handler.NettyConfig;
import com.kongke.domain.chat.model.dto.UserChatDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 启年
 * @date 2023-05-13 12:45
 */
@RestController
@RequestMapping("/user")
public class UserChatController {
	
	/**
	 * 返回在线的UserId
	 */
	@GetMapping("/online/list")
	public Map<String, Object> onlineList() {
		Map<String, Object> response = new HashMap<>();
		
		List<UserChatDTO> list = new ArrayList<>();
		NettyConfig.getOnlineUserChannelMap().forEach((key, value) -> {
			UserChatDTO user = new UserChatDTO(key, key);
			list.add(user);
		});
		response.put("code", 200);
		response.put("msg", "success");
		response.put("data", list);
		return response;
	}
	
}

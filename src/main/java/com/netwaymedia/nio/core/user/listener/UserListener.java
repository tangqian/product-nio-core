package com.netwaymedia.nio.core.user.listener;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.netwaymedia.nio.core.user.entity.User;
import com.netwaymedia.nio.core.user.service.UserService;

@Component
public class UserListener {

	@Resource
	private UserService userService;
	
	public void test(){
		User user = userService.get(1);
		System.out.println(user);
	}
}

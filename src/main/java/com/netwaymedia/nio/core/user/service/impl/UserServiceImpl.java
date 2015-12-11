package com.netwaymedia.nio.core.user.service.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.netwaymedia.nio.core.user.entity.User;
import com.netwaymedia.nio.core.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private SqlSessionTemplate template;
	
	public User get(Integer id) {
		return template.selectOne("UserMapper.get", id);

	}
}

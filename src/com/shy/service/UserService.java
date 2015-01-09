package com.shy.service;

import java.util.HashMap;
import java.util.Map;
import com.shy.model.UserModel;

public class UserService
{
	// 实际应该存数据库
	private Map<String, UserModel> userDB = new HashMap<String, UserModel>();

	public void create(UserModel user)
	{
		if(userDB.containsKey(user.getUsername()))
		{
			throw new RuntimeException(String.format("%s用户已经存在", user.getUsername()));
		}
	}
}

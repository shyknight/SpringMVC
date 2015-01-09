package com.shy.web.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.CancellableFormController;

import com.shy.model.UserModel;

public class CanCancelRegisterSimpleFormController extends CancellableFormController
{
	public CanCancelRegisterSimpleFormController()
	{
		setCommandClass(UserModel.class);
		setCommandName("user");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception
	{
		UserModel user = new UserModel();
		user.setUsername("请输入用户名");
		return user;
	}

	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception
	{
		Map map = new HashMap();
		map.put("cityList", Arrays.asList("江苏", "北京", "上海"));
		return map;
	}

	@Override
	protected void doSubmitAction(Object command) throws Exception
	{
		UserModel user = (UserModel) command;

		System.out.println(user);
	}
	
	@Override
	protected ModelAndView onCancel(Object command) throws Exception
	{
		UserModel user = (UserModel) command;
		System.out.println(user);
		return super.onCancel(command);
	}
}

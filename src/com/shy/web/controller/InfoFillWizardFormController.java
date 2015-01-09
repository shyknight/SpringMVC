package com.shy.web.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.shy.model.UserModel;

public class InfoFillWizardFormController extends AbstractWizardFormController
{

	public InfoFillWizardFormController()
	{
		setCommandClass(UserModel.class);
		setCommandName("user");
	}

	@Override
	protected Map referenceData(HttpServletRequest request, int page)
			throws Exception
	{
		Map map = new HashMap();

		if (page == 1) // 如果是填写学校信息页 需要学校类型信息
		{
			map.put("schoolTypeList", Arrays.asList("高中", "中专", "大学"));
		}

		if (page == 2)// 如果是填写工作信息页 需要工作城市信息
		{
			map.put("cityList", Arrays.asList("南京", "北京", "上海"));
		}

		return map;
	}

	@Override
	protected void validatePage(Object command, Errors errors, int page)
	{
		// 提供每一页数据的验证处理方法
	}

	@Override
	protected ModelAndView processFinish(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception
	{
		System.out.println(command);
		return new ModelAndView("wizard/success");
	}

	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception
	{
		System.out.println(command);
		return new ModelAndView("redirect:/cancel");
	}

}

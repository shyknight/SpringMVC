package com.shy.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorld2Controller extends AbstractController
{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("message", "Hello World2!");
		
		mv.setViewName("hello");
		
		return mv;
	}

}

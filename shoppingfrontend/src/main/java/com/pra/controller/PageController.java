package com.pra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController 
{
	@RequestMapping("/")
	public String showHomePage()
	{
		return "index";
	}
	
//	@RequestMapping("/login")
//	public String showLoginPage()
//	{
//		return "Login";
//	}
//	
//	@RequestMapping("/register")
//	public String showRegisterPage()
//	{
//		return "Register";
//	}
//	
//	@RequestMapping("/contactus")
//	public String showContactUsPage()
//	{
//		return "ContactUs";
//	}
//	
//	@RequestMapping("/aboutus")
//	public String showAboutUsPage()
//	{
//		return "AboutUs";
//	}

}

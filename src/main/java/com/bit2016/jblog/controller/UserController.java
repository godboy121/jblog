package com.bit2016.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.service.UserService;
import com.bit2016.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform(){
		return "user/join";
	}
	
	@RequestMapping("/loginform")
	public String loginform(){
		return "user/login";
	}
	

	
	@RequestMapping("/join")
	public String join(@ModelAttribute @Valid UserVo vo){
		userService.join(vo);
		return "user/joinsuccess";
	}
	


}

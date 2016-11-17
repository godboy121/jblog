package com.bit2016.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2016.jblog.security.AuthUser;
import com.bit2016.jblog.vo.UserVo;

@Controller
public class MainController {
	@RequestMapping("")
	public String index(@AuthUser UserVo authUser){
		
		return "main/index";
	}
	

	
	

}

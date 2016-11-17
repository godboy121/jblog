package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2016.jblog.security.AuthUser;
import com.bit2016.jblog.service.BlogService;
import com.bit2016.jblog.service.UserService;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.UserVo;

@Controller
@RequestMapping("")
public class BlogController {
	
	@Autowired 
	private BlogService blogService;
	
	@Autowired 
	private UserService userService;
	


	
	
	@RequestMapping("/{id}")
	public String main(
			@PathVariable("id") String id,
			@AuthUser UserVo authUser,
			Model model){
	
		BlogVo vo1=blogService.showtitle(authUser.getNo());
		model.addAttribute("blogVo", vo1);
		
		return "blog/blog-main";
	}
	
	@RequestMapping("/{id}/admin/basic")
	public String manage(@PathVariable("id") String id,Model model,
				@AuthUser UserVo authUser)
	{
		
//		if(authUser.getId()!=id)
//		{
//			System.out.println(authUser.getId());
//			System.out.println(id);`
//			return "redirect:/"+id;
//		}
		
		BlogVo vo1=blogService.showtitle(authUser.getNo());	//blog-admin-basic.jsp파일에 vo의 타이틀을 보여주기위함
		UserVo vo2=userService.getById(authUser.getId());
		
		
		model.addAttribute("blogVo", vo1);
		model.addAttribute("userVo", vo2);
		
		
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping("/{id}/modifyView")
	public String modiftView(@RequestParam(value="title",required=true,defaultValue="1") String blogtitle,//수정된 타이틀을 update하기위해 requestParam으로 받아온다
							 @RequestParam(value="logo-file",required=true,defaultValue="1") String image,
				@PathVariable("id") String id,
				@AuthUser UserVo authUser,
				@ModelAttribute BlogVo vo){
		if(authUser==null){
			System.out.println("error");
		}
		System.out.println(image);
		vo.setUsers_no(authUser.getNo());
		vo.setTitle(blogtitle);
		
		blogService.modify(vo);
		System.out.println(vo.getTitle());
		
		
		
		
		return "redirect:/"+id;
	}
	
	
	

}

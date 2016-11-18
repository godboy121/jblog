package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		
		BlogVo vo1=blogService.showtitle(authUser.getNo());	//blog-admin-basic.jsp�뙆�씪�뿉 vo�쓽 ���씠���쓣 蹂댁뿬二쇨린�쐞�븿
		UserVo vo2=userService.getById(authUser.getId());
		
		
		model.addAttribute("blogVo", vo1);
		model.addAttribute("userVo", vo2);
		
		
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping("/{id}/modifyView")
	public String modiftView(@RequestParam(value="title",required=true,defaultValue="1") String blogtitle,//�닔�젙�맂 ���씠���쓣 update�븯湲곗쐞�빐 requestParam�쑝濡� 諛쏆븘�삩�떎
							 @RequestParam(value="logo-file") MultipartFile file,//파일업로드를 하기위해 MultipartFile을 불러온다
				@PathVariable("id") String id,
				@AuthUser UserVo authUser,//authuser는 거의 필수인듯
				@ModelAttribute BlogVo vo){//modify할때 일단 수정 창에서 title과 logo-file 이름을 가져오기 위해 requestParam을 썻다
		if(authUser==null){
			
			System.out.println("error");
		}
		vo.setUsers_no(authUser.getNo());//user의 no와 blog의 userno을 비교하기 위해 user_no를 blog의 user_no set 해준다
		vo.setTitle(blogtitle);//바뀐 타이틀을 새로 setTitle한다
//		vo.setLogo(file);
		
		blogService.modify(vo,file);//그냥 넣고 싶은거 넣어라
	
		
		
		
		
		return "redirect:/"+id;
	}
	
	
	

}

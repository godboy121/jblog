package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.vo.BlogVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	public BlogVo showtitle(int no){
		
		BlogVo blogVo=blogDao.showtitle(no);
		return blogVo;
	}
	
	public void modify(BlogVo vo){

		blogDao.modify(vo);
	}
	
	



	
	

}

package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	
	public void join(UserVo vo){
		userDao.insert(vo);
		blogDao.create(userDao.get(vo));
	
	}
	
	public UserVo login(String id, String password){
		UserVo userVo=userDao.login(id, password);
		
	
		return userVo;
	}
	
	public UserVo getById(String id){
		
		UserVo userVo=userDao.getById(id);
		return userVo;
	}
	
	


}

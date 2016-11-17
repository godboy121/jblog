package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void create(int no){
		sqlSession.insert("blog.create", no);
		
	}
	
	public BlogVo main(int no){
		
		return sqlSession.selectOne("blog.main", no);
	}
	
	public BlogVo showtitle(int no){//blog title을 받아오기 위한 함수 
		
		return sqlSession.selectOne("blog.view", no);
	}
	
	public void modify(BlogVo vo){
		sqlSession.update("blog.update",vo);
	}
	
	
	
	

}

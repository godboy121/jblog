package com.bit2016.jblog.service;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;

@Service
public class BlogService {
	private static final String SAVE_PATH = "/upload";
	
	@Autowired
	private BlogDao blogDao;
	
	public BlogVo showtitle(int no){
		
		BlogVo blogVo=blogDao.showtitle(no);
		return blogVo;
	}
	
	public void modify(BlogVo vo,MultipartFile file){
		
		try{
			if(file.isEmpty()==true){//�ϴ� file�� ������� üũ
				System.out.println("error");
			}
			//������ c:/upload�� �����ϱ����� �̸��� ��ȯ�� 
			String originalName = file.getOriginalFilename();

			String extName = originalName.substring(originalName.lastIndexOf('.') + 1, originalName.length());
			String saveName = generateSaveName(extName);
			writeFile(file, saveName);

			vo.setLogo(saveName);
			
		} catch (Exception e) {
			throw new RuntimeException("upload file");
		}
	
		blogDao.modify(vo);
	}
	
	public String generateSaveName(String extName) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();

		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += ("." + extName);

		return fileName;
	}
	
	private void writeFile(MultipartFile multipartFile, String saveName) throws Exception {

		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveName);//�̹��������� �ش� ��ҿ� ����

		fos.write(fileData);//�̹��������� �ش� ��ҿ� ����
	}
	
	public void addcategory(CategoryVo vo){
		blogDao.addcategory(vo);
	}
	
	public List<CategoryVo> list(BlogVo vo){
		
		return blogDao.getList(vo);
	}
	
	



	
	

}

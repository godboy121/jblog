package com.bit2016.jblog.service;

import java.io.FileOutputStream;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.vo.BlogVo;

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
			if(file.isEmpty()==true){//일단 file이 비었는지 체크
				System.out.println("error");
			}
			//파일을 c:/upload에 저장하기위해 이름을 변환중 
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
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveName);//이미지파일을 해당 장소에 저장

		fos.write(fileData);//이미지파일을 해당 장소에 저장
	}
	
	



	
	

}

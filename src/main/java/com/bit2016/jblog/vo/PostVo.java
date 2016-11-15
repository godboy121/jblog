package com.bit2016.jblog.vo;

public class PostVo {
	private int post_no;
	private String title;
	private String content;
	private String reg_date;
	private int category_no;
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	@Override
	public String toString() {
		return "PostVo [post_no=" + post_no + ", title=" + title + ", content=" + content + ", reg_date=" + reg_date
				+ ", category_no=" + category_no + "]";
	}
	
	

}

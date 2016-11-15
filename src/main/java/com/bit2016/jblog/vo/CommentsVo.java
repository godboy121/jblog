package com.bit2016.jblog.vo;

public class CommentsVo {
	private int comments_no;
	private String content;
	private String reg_date;
	private int post_no;
	public int getComments_no() {
		return comments_no;
	}
	public void setComments_no(int comments_no) {
		this.comments_no = comments_no;
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
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	@Override
	public String toString() {
		return "CommentsVo [comments_no=" + comments_no + ", content=" + content + ", reg_date=" + reg_date
				+ ", post_no=" + post_no + "]";
	}
	
	

}

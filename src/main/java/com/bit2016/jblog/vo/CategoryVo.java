package com.bit2016.jblog.vo;

public class CategoryVo {
	private int category_no;
	private String name;
	private String description;
	private String reg_date;
	private int users_no;
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getUsers_no() {
		return users_no;
	}
	public void setUsers_no(int users_no) {
		this.users_no = users_no;
	}
	@Override
	public String toString() {
		return "CategoryVo [category_no=" + category_no + ", name=" + name + ", description=" + description
				+ ", reg_date=" + reg_date + ", users_no=" + users_no + "]";
	}
	
	

}

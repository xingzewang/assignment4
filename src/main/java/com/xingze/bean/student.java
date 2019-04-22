package com.xingze.bean;

public class student{
	private String id;
	private String name;
	private String sex;
	private String telphone;
	private String  password;
	
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
   
	public  student() {}
	
	public student(String id, String name, String sex, String telphone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.telphone = telphone;
		this.password = password;
	}
}

package com.spg.apidoc.po;

public class LoginBody {
	private String user_name;
	private String hxid;
	private String hxpassword;
	private String token;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getHxid() {
		return hxid;
	}
	public void setHxid(String hxid) {
		this.hxid = hxid;
	}
	public String getHxpassword() {
		return hxpassword;
	}
	public void setHxpassword(String hxpassword) {
		this.hxpassword = hxpassword;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}

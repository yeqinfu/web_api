package com.ppandroid.hx;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spg.apidoc.common.configer.HXConfig;
import com.spg.apidoc.controller.BaseController;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Utils_hx {
	private static final Log LOGGER = LogFactory.getLog(BaseController.class);
	static OkHttpClient client = new OkHttpClient();
	public static final MediaType TYPE = MediaType.parse("application/json; charset=utf-8");
	// 获取环信token
	public static String queryToken() {
		String url = HXConfig.hx_baseurl + "/" + HXConfig.org_name + "/" + HXConfig.app_name + "/token";
		System.out.println("获取hx token="+url);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("grant_type", "client_credentials");
		jsonObject.put("client_id", HXConfig.clientId);
		jsonObject.put("client_secret", HXConfig.clientSecret);
		RequestBody body = RequestBody.create(TYPE, jsonObject.toJSONString());
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = null;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 只获取token
	 * @return
	 */
	public static String getHXToken(){
		if (!HXConfig.HXToken.isEmpty()) { 
			return HXConfig.HXToken;
		}
		String json=queryToken();
		System.out.println("获取环形token response--->"+json);
		HXTokenVo body=com.alibaba.fastjson.JSON.parseObject(json,HXTokenVo.class);
		HXConfig.HXToken=body.getAccess_token();
		return HXConfig.HXToken;
	}
	
	/*
	 * 环信用户注册
	 */
	public static String registerHXUser(String userName,String password,String nickName){
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("username", userName);
		jsonObject.put("password", password);
		jsonObject.put("nickname", nickName);
	/*	JSONObject params=new JSONObject();
		params.put("Authorization", "Bearer "+getHXToken());
		params.put("users", jsonObject.toJSONString());*/
		RequestBody body = RequestBody.create(TYPE, jsonObject.toJSONString());
		String url= HXConfig.hx_baseurl + "/" + HXConfig.org_name + "/" + HXConfig.app_name + "/users";
		System.out.println("注册环形用户url"+url);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = null;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}


	public static boolean registerUser(String userName,String password,String nickName){
		String string=registerHXUser(userName, password,nickName);
		System.out.println("注册response:"+string);
		HXUserVo body=JSON.parseObject(string,HXUserVo.class);
		//注册成功
		if (body!=null) {
			return true;
		}else{
			return false;
		}
	}
	
	public static void setHXUserNickName(String userId,String nickName){
		String url= HXConfig.hx_baseurl + "/" + HXConfig.org_name + "/" + HXConfig.app_name + "/users/"+userId;
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("nickname", nickName);
		RequestBody body = RequestBody.create(TYPE, jsonObject.toJSONString());
		Request request = new Request.Builder().addHeader("Authorization", "Bearer "+Utils_hx.getHXToken()).url(url).put(body).build();
		Response response = null;
		try {
			response = client.newCall(request).execute();
			System.out.println("昵称设置"+response.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

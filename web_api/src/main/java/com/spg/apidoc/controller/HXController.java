package com.spg.apidoc.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppandroid.hx.Utils_hx;
import com.spg.apidoc.service.HXUserService;
import com.spg.apidoc.vo.BaseResultVo;
import com.spg.apidoc.vo.HXUser;
import com.utils.TextUtils;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("hxCtrl")
public class HXController extends BaseController {

	private static final Log LOGGER = LogFactory.getLog(UserCtroller.class);
	@Resource
	@Autowired
	HXUserService hxService;
	@ResponseBody
	@RequestMapping(value = "registerUser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ApiOperation(value = "添加用户", httpMethod = "POST", response = BaseResultVo.class, notes = "给当前系统注册一个新的用户")
	public String registerUser(
			@ApiParam(required = true, value = "用户名字") @RequestParam(value = "userName") String userName,
			@ApiParam(required = true, value = "用户密码") @RequestParam(value = "userPassword") String userPassword,
			HttpServletRequest request) {
		//LOGGER.debug(String.format("at function, %s", userName));
		if (TextUtils.isEmpty(userName,userPassword)) {
			return super.failedResult(-1, "用户或者密码不能为空");
		}
		String hxId=UUID.randomUUID().toString();
		String hxPassWord=UUID.randomUUID().toString();
		if (Utils_hx.registerUser(hxId, hxPassWord)) {
			HXUser hxUser=new HXUser();
			hxUser.setId(UUID.randomUUID().toString());
			hxUser.setHxid(hxId);
			hxUser.setHxpassword(hxPassWord);
			hxUser.setPassword(userPassword);
			hxUser.setUser_name(userName);
			int result=hxService.addUser(hxUser);
			return okResult(result);
			
		}else{
			return super.failedResult(-1, "环信注册失败");
		}
	}
}

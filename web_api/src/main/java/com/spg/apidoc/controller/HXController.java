package com.spg.apidoc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.spg.apidoc.po.UserInfo;
import com.spg.apidoc.vo.BaseResultVo;
import com.utils.TextUtils;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("hxCtrl")
public class HXController extends BaseController {

	private static final Log LOGGER = LogFactory.getLog(UserCtroller.class);

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

		// UserInfo user = JSON.parseObject(userName, UserInfo.class);
		return okResult(1);
	}
}

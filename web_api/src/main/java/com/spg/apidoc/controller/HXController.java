package com.spg.apidoc.controller;

import java.util.List;
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

import com.alibaba.fastjson.JSON;
import com.ppandroid.hx.Utils_hx;
import com.spg.apidoc.po.LoginBody;
import com.spg.apidoc.service.HXUserService;
import com.spg.apidoc.vo.BaseResultVo;
import com.spg.apidoc.vo.HXUser;
import com.utils.TextUtils;
import com.utils.TokenGenerateUtil;
import com.utils.TokenManager;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("hxCtrl")
public class HXController extends BaseController {

	private static final Log LOGGER = LogFactory.getLog(UserCtroller.class);
	@Autowired
	HXUserService hxService;

	@ResponseBody
	@RequestMapping(value = "registerUser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ApiOperation(value = "添加用户", httpMethod = "POST", response = BaseResultVo.class, notes = "给当前系统注册一个新的用户")
	public String registerUser(
			@ApiParam(required = true, value = "用户名字") @RequestParam(value = "userName") String userName,
			@ApiParam(required = true, value = "用户密码") @RequestParam(value = "userPassword") String userPassword,
			HttpServletRequest request) {
		// LOGGER.debug(String.format("at function, %s", userName));
		if (TextUtils.isEmpty(userName, userPassword)) {
			return super.failedResult(-1001, "用户或者密码不能为空");
		}
		List<HXUser> list = hxService.checkUserName(userName);
		// 用户名字重复
		if (list == null || list.size() > 0) {
			return super.failedResult(-1002, "用户名字已经存在！");
		}
		String hxId =UUID.randomUUID().toString().replaceAll("-", "");
		String hxPassWord = UUID.randomUUID().toString();
		if (Utils_hx.registerUser(hxId, hxPassWord,userName)) {
			HXUser hxUser = new HXUser();
			hxUser.setId(UUID.randomUUID().toString());
			hxUser.setHxid(hxId);
			hxUser.setHxpassword(hxPassWord);
			hxUser.setPassword(userPassword);
			hxUser.setUser_name(userName);
			int result = hxService.addUser(hxUser);
			return okResult(result);

		} else {
			return super.failedResult(-1003, "环信注册失败");
		}
	}

	@ResponseBody
	@RequestMapping(value = "loginSystem", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ApiOperation(value = "用户登录", httpMethod = "POST", response = BaseResultVo.class, notes = "登录")
	public String loginSystem(
			@ApiParam(required = true, value = "用户名字") @RequestParam(value = "userName") String userName,
			@ApiParam(required = true, value = "用户密码") @RequestParam(value = "userPassword") String userPassword,
			HttpServletRequest request) {
		// LOGGER.debug(String.format("at function, %s", userName));
		if (TextUtils.isEmpty(userName, userPassword)) {
			return super.failedResult(-1001, "用户或者密码不能为空");
		}
		List<HXUser> list = hxService.checkUserName(userName);
		// 用户名字重复
		if (list != null&& list.size() > 0) {
			if (!list.get(0).getPassword().equals(userPassword)) {
				return super.failedResult(-1005, "密码错误");

			}
			LoginBody body = new LoginBody();
			body.setHxid(list.get(0).getHxid());
			body.setHxpassword(list.get(0).getHxpassword());
			// System.out.println(TokenGenerateUtil.getToken());
			body.setToken(TokenGenerateUtil.getToken());
			TokenManager.addToken(body.getToken(), userName);
			body.setUser_name(list.get(0).getUser_name());
			return super.okResult(body);
		} else {
			return super.failedResult(-1003, "当前用户不存在！");
		}

	}

	@ResponseBody
	@RequestMapping(value = "queryTokenList", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String queryTokenList() {
		return okResult(TokenManager.DATA_MAP);
	}

	@ResponseBody
	@RequestMapping(value = "findFriends", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String findFriends(@ApiParam(required = true, value = "关键字") @RequestParam(value = "keyName") String keyName) {
		if (TextUtils.isEmpty(keyName)) {
			return failedResult(-1, "关键字不能为空");
		}
		
		return okResult(hxService.findFriends(keyName));
	}

}

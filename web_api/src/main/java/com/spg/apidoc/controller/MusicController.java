package com.spg.apidoc.controller;

import java.util.Random;
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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.spg.apidoc.po.UserInfo;
import com.spg.apidoc.service.MusicService;
import com.spg.apidoc.service.UserService;
import com.spg.apidoc.vo.BaseResultVo;
import com.spg.apidoc.vo.MusicVo;
import com.spg.apidoc.vo.User;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 项目名称：web_api
 *
 * @description:
 * @version V1.0.0
 *
 */
// @Api(basePath = "/", value = "MusicController")
@Controller
@RequestMapping("MusicController")
public class MusicController extends BaseController {

	private static final Log LOGGER = LogFactory.getLog(MusicController.class);

	@Resource
	@Autowired
	MusicService musicService;

	@RequestMapping(value = "insertMusic", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ApiOperation(value = "音乐插入")
	public ModelAndView insertMusicMethod(
			@ApiParam(required = true, name = "name_music", value = "音乐名字") @RequestParam(value = "name_music") String name_music,
			@ApiParam(required = true, name = "id_dj", value = "dj的id") @RequestParam(value = "id_dj") String id_dj,
			@ApiParam(required = true, name = "id_class", value = "音乐的分类") @RequestParam(value = "id_class") String id_class,
			@ApiParam(required = true, name = "music_address", value = "音乐的地址") @RequestParam(value = "music_address") String music_address,
			@ApiParam(required = true, name = "pic_address", value = "音乐的配图，多张用,分割") @RequestParam(value = "pic_address") String pic_address,
			@ApiParam(required = false, name = "intro", value = "音乐的简介") @RequestParam(value = "intro") String intro,
			@ApiParam(required = false, name = "content", value = "音乐的内容") @RequestParam(value = "content") String content
			) {
		MusicVo music=new MusicVo();
		music.setContent("".equals(content)?"":content);
		music.setId( UUID.randomUUID()+"");
		music.setId_class(id_class);
		music.setId_dj(id_dj);
		music.setIntro(intro);
		music.setMusic_address(music_address);
		music.setName_music(name_music);
		music.setPic_address(pic_address);
		musicService.insertMusic(music);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insertMusicMethod");
		mav.addObject("MusicVo", music);
		return mav;
	}

}

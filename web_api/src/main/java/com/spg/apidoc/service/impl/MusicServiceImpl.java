package com.spg.apidoc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spg.apidoc.dao.Dao_Music;
import com.spg.apidoc.dao.UserDAO;
import com.spg.apidoc.po.UserInfo;
import com.spg.apidoc.service.MusicService;
import com.spg.apidoc.service.UserService;
import com.spg.apidoc.vo.MusicVo;
import com.spg.apidoc.vo.User;

/**
 * 项目名称：apidoc
 *
 * @description:
 * @author Wind-spg
 * @create_time：2015年2月3日 上午10:28:43
 * @version V1.0.0
 *
 */
@Service("musicService")
public class MusicServiceImpl implements MusicService {
	private static final Log LOGGER = LogFactory.getLog(MusicServiceImpl.class);

	@Autowired
	@Qualifier("dao_Music")
	private Dao_Music dao_Music;

	public int insertMusic(MusicVo music) {
		return dao_Music.insertMusic(music);
	}

}

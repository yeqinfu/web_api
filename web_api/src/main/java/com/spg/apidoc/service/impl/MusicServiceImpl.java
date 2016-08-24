package com.spg.apidoc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spg.apidoc.dao.Dao_Music;
import com.spg.apidoc.service.MusicService;
import com.spg.apidoc.vo.MusicVo;

@Service("musicService")
public class MusicServiceImpl implements MusicService {
	private static final Log LOGGER = LogFactory.getLog(MusicServiceImpl.class);

	@Autowired
	@Qualifier("dao_Music")
	private Dao_Music dao_Music;

	public int insertMusic(MusicVo music) {
		return dao_Music.insertMusic(music);
	}

	public List<MusicVo> getMusic(int offset, int rows) {
		return dao_Music.getMusic(offset, rows);
	}

	public List<MusicVo> getAllMusic() {
		// TODO Auto-generated method stub
		return dao_Music.getAllMusic();
	}

}

package com.spg.apidoc.service;

import java.util.List;

import com.spg.apidoc.vo.MusicVo;

public interface MusicService {
	int insertMusic(MusicVo music);

	List<MusicVo> getMusic(int offset, int rows);
	List<MusicVo> getAllMusic();
}

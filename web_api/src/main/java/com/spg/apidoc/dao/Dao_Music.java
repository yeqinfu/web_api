package com.spg.apidoc.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spg.apidoc.vo.MusicVo;
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public interface Dao_Music {
	public int insertMusic(MusicVo music);
	
	public List<MusicVo> getMusic(@Param("offset") int offset,@Param("rows") int rows);
	public List<MusicVo> getAllMusic();
}

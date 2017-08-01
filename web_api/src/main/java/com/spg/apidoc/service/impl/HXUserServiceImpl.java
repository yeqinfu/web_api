package com.spg.apidoc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spg.apidoc.dao.Dao_Music;
import com.spg.apidoc.dao.HXUserDao;
import com.spg.apidoc.service.HXUserService;
import com.spg.apidoc.vo.HXUser;
@Service("hxService")
public class HXUserServiceImpl implements HXUserService{
	@Autowired
	@Qualifier("HXUserDao")
	private HXUserDao hxUserDao;
	public int addUser(HXUser user) {
		return hxUserDao.addUser(user);
	}
	public List<HXUser> checkUserName(String userName) {
		// TODO Auto-generated method stub
		return hxUserDao.checkUserName(userName);
	}
	@Override
	public List<HXUser> findFriends(String key) {
		return hxUserDao.findFriends(key);
	}

}

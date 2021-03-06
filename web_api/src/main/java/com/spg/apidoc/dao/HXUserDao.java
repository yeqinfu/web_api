package com.spg.apidoc.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spg.apidoc.vo.HXUser;
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public interface HXUserDao {
	public int addUser(HXUser user);
	public List<HXUser> checkUserName(String userName);

	public List<HXUser> findFriends(String key);


}

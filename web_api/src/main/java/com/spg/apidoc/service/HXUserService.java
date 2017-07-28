package com.spg.apidoc.service;

import java.util.List;

import com.spg.apidoc.vo.HXUser;

public interface HXUserService {
	  int addUser(HXUser user);
	  List<HXUser> checkUserName(String userName);
}

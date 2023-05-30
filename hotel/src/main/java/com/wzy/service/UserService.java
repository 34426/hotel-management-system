package com.wzy.service;


import com.wzy.pojo.UserPo;

public interface UserService {

	public UserPo selectLogin(UserPo user);
	public UserPo findIdByuserName(String userName);
	
}

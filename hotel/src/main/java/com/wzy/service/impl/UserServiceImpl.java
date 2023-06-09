package com.wzy.service.impl;

import com.wzy.mapper.UserMapper;
import com.wzy.pojo.UserPo;
import com.wzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value="userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserPo selectLogin(UserPo user) {

		UserPo userPo = userMapper.selectLogin(user);
//		System.out.println("selectLogin");
		return userPo;
	}

	@Override
	public UserPo findIdByuserName(String userName) {
		return userMapper.findIdByuserName(userName);
	}


}

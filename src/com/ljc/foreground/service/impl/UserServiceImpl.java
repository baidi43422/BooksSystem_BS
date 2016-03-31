package com.ljc.foreground.service.impl;

import com.ljc.foreground.dao.impl.UserDaoImpl;
import com.ljc.foreground.dao.intf.UserDaoIntf;
import com.ljc.foreground.model.User;
import com.ljc.foreground.service.intf.UserServiceIntf;

public class UserServiceImpl implements UserServiceIntf {

	@Override
	public User login(User user) {
		UserDaoIntf daoIntf = new UserDaoImpl();
		return daoIntf.getByNameAndPWD(user);
	}

	@Override
	public boolean register(User user) {
		UserDaoIntf daoIntf = new UserDaoImpl();
		return daoIntf.addUser(user);
	}

}

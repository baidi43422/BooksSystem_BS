package com.ljc.foreground.dao.intf;

import com.ljc.foreground.model.User;
import com.ljc.util.PageBean;



public interface UserDaoIntf {
	public boolean addUser(User user);
	public User getByNameAndPWD(User user);
	public PageBean<User> query(PageBean<User> pageBean,User user);
	public int getCount(User user);
}

package com.ljc.foreground.service.intf;

import com.ljc.foreground.model.User;
import com.ljc.util.PageBean;

public interface UserServiceIntf {
	public boolean register(User user);//зЂВс
	public User login(User user);
	public PageBean<User> query(PageBean<User> pageBean,User user);
	public int getCount(User user);
}

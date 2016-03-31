package com.ljc.foreground.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ljc.foreground.dao.intf.UserDaoIntf;
import com.ljc.foreground.model.User;
import com.ljc.util.DButil;

public class UserDaoImpl implements UserDaoIntf{

	@Override
	public boolean addUser(User user) {
		String id=user.getId();
		String name=user.getName();
		String pwd=user.getPwd();
		String status=user.getStatus();
		String province=user.getProvince();
		String city=user.getCity();
		String county=user.getCountry();
		String street=user.getStreet();
		String phone=user.getPhone();
		String sql="insert into user values(?,?,?,?,?,?,?,?,?)";
		int i=DButil.addUser(sql, id, name, pwd, status, province, city, county, street, phone);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public User getByNameAndPWD(User user) {
		// TODO Auto-generated method stub
		String name=user.getName();
		String pwd=user.getPwd();
		String sql="select status from user where name=? and id=?";
		int i=0;
		try {
			ResultSet re=DButil.loginFind(sql, name, pwd);
			while(re.next()){
				String status=re.getString("status");
				user.setStatus(status);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}

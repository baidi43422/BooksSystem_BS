package com.ljc.foreground.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ljc.foreground.dao.intf.UserDaoIntf;
import com.ljc.foreground.model.User;
import com.ljc.util.DButil;
import com.ljc.util.PageBean;

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

	@Override
	public int getCount(User user) {
		String id=user.getId();
		String name=user.getName();
		String status=user.getStatus();
		String province=user.getProvince();
		String sql="select count(*) c from user where id like ? and name like ? and status like ? and province like ?";
		ResultSet re=DButil.getSet1(sql, id, name,status, province);
		int i=0;
		try {
			while(re.next()){
				i=re.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public PageBean<User> query(PageBean<User> pageBean, User user) {
		List<User> list = new ArrayList<User>();
		String id=user.getId();
		String name=user.getName();
		String status=user.getStatus();
		String province=user.getProvince();
		int start=(pageBean.getCurrentPage()-1)*pageBean.getCountOfPage();
		int end=pageBean.getCountOfPage();
		String sql="select * from user where id like ? and name like ? " +
				"and status like ? and province like ? limit ?,?";
		ResultSet re=DButil.getSet1(sql, id, name, status, province,start,end);
		try {
			while(re.next()){
				String id1=re.getString("id");
				String name1=re.getString("name");
				String pwd=re.getString("pwd");
				String status1=re.getString("status");
				String province1=re.getString("province");
				String city=re.getString("city");
				String country=re.getString("country");
				String street=re.getString("street");
				String phone=re.getString("phone");
				User user1=new User(id1, name1, pwd, status1, province1, city, country, street, phone);
				list.add(user1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setData(list);
		return pageBean;
	}

	

}

package com.ljc.background.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ljc.background.dao.intf.ControllerDaoIntf;
import com.ljc.background.model.Controller;
import com.ljc.util.DButil;
import com.ljc.util.PageBean;


public class ControllerDaoImpl implements ControllerDaoIntf {

	@Override
	public boolean UpdatUser(Controller controller) {
		// TODO Auto-generated method stub
		String id=controller.getId();
		String name=controller.getName();
		String pwd=controller.getPwd();
		String status=controller.getStatus();
		String sql="update controller set name=?,pwd=?,status=? where id=?";
		int i=DButil.update(sql, name, pwd, status, id);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public boolean addUser(Controller controller) {
		// TODO Auto-generated method stub
		String id=controller.getId();
		String name=controller.getName();
		String pwd=controller.getPwd();
		String status=controller.getStatus();
		if(status==null || "".equals(status))
			status="yes";
		String sql="insert into controller values(?,?,?,?,'D')";
		int i=DButil.add(sql, id, name, pwd, status);
		if(i>0)
			return true;
		return  false;
	}

	@Override
	public boolean deleUser(String id) {
		// TODO Auto-generated method stub
		String sql="delete from controller where id=?";
		int i=DButil.deleteData(sql, id);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public int getAllCounts(Controller controller) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageBean<Controller> query(Controller controller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  Controller getByNameAndPWD(Controller controller) {
		// TODO Auto-generated method stub
		String s1=controller.getName();
		String s2=controller.getPwd();
		String sql="select status from controller where name=? and pwd=?";
		ResultSet re=null;
		try {
			 re=DButil.loginFind(sql, s1, s2);
			 while(re.next()){
				 String status=re.getString("status");
				 controller.setStatus(status);
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return controller;
	}

}

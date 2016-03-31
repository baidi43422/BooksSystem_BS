package com.ljc.background.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ljc.background.dao.impl.ControllerDaoImpl;
import com.ljc.background.dao.intf.ControllerDaoIntf;
import com.ljc.background.model.Controller;
import com.ljc.background.service.intf.ControllerServiceInt;
import com.ljc.util.PageBean;


public class ControllerServiceImpl implements ControllerServiceInt {

	@Override
	public boolean UpdatUser(Controller controller) {
		ControllerDaoIntf daoIntf=new ControllerDaoImpl();
		return daoIntf.UpdatUser(controller);
	}

	@Override
	public boolean addUser(Controller ntroller) {
		ControllerDaoIntf daoIntf=new ControllerDaoImpl();
		return daoIntf.addUser(ntroller);
	}

	@Override
	public boolean deleUser(String id) {
		ControllerDaoIntf daoIntf=new ControllerDaoImpl();
		return daoIntf.deleUser(id);
	}

	@Override
	public int getAllCounts(Controller controller) {
		ControllerDaoIntf daoIntf=new ControllerDaoImpl();
		return 0;
	}

	@Override
	public PageBean<Controller> query(Controller controller) {
		ControllerDaoIntf daoIntf=new ControllerDaoImpl();
		return null;
	}

	@Override
	public Controller login(Controller controller) {
		ControllerDaoIntf daoIntf=new ControllerDaoImpl();
		return daoIntf.getByNameAndPWD(controller);
	}

}

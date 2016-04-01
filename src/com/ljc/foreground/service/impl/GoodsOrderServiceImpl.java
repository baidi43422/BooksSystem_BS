package com.ljc.foreground.service.impl;

import java.util.List;

import com.ljc.foreground.dao.impl.GoodsOrderDaoImpl;
import com.ljc.foreground.dao.intf.GoodsOrderDaoIntf;
import com.ljc.foreground.model.GoodsOrder;
import com.ljc.foreground.model.User;
import com.ljc.foreground.service.intf.GoodsOrderServiceIntf;
import com.ljc.util.PageBean;

public class GoodsOrderServiceImpl implements GoodsOrderServiceIntf {

	@Override
	public boolean addOrder(GoodsOrder goodsOrder) {
		GoodsOrderDaoIntf daoIntf=new GoodsOrderDaoImpl();
		return daoIntf.addOrder(goodsOrder);
	}

	@Override
	public boolean deleteOrder(GoodsOrder goodsOrder) {
		GoodsOrderDaoIntf daoIntf=new GoodsOrderDaoImpl();
		return daoIntf.deleteOrder(goodsOrder);
	}

	@Override
	public boolean updateOrder(GoodsOrder goodsOrder) {
		GoodsOrderDaoIntf daoIntf=new GoodsOrderDaoImpl();
		return daoIntf.updateOrder(goodsOrder);
	}

	@Override
	public List<GoodsOrder> query(User user) {
		GoodsOrderDaoIntf daoIntf=new GoodsOrderDaoImpl();
		return daoIntf.query(user);
	}

}

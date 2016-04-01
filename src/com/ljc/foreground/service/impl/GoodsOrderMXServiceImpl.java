package com.ljc.foreground.service.impl;


import com.ljc.background.model.Goods;
import com.ljc.foreground.dao.impl.GoodsOrderMXDaoImpl;
import com.ljc.foreground.dao.intf.GoodsOrderMXDaoIntf;
import com.ljc.foreground.model.GoodsOrderMX;
import com.ljc.foreground.model.OrderMessage;
import com.ljc.foreground.service.intf.GoodsOrderMXServiceIntf;
import com.ljc.util.PageBean;

public class GoodsOrderMXServiceImpl implements GoodsOrderMXServiceIntf{

	@Override
	public boolean UpdateOrderMX(GoodsOrderMX goodsOrderMX) {
		GoodsOrderMXDaoIntf mxDaoIntf=new GoodsOrderMXDaoImpl();
		return mxDaoIntf.UpdateOrderMX(goodsOrderMX);
	}

	@Override
	public boolean addOrderMX(GoodsOrderMX goodsOrderMX) {
		GoodsOrderMXDaoIntf mxDaoIntf=new GoodsOrderMXDaoImpl();
		return mxDaoIntf.addOrderMX(goodsOrderMX);
	}

	@Override
	public boolean deleteOrderMX(GoodsOrderMX goodsOrderMX) {
		GoodsOrderMXDaoIntf mxDaoIntf=new GoodsOrderMXDaoImpl();
		return mxDaoIntf.deleteOrderMX(goodsOrderMX);
	}

	@Override
	public PageBean<OrderMessage> query(PageBean<OrderMessage> pageBean,GoodsOrderMX goodsOrderMX) {
		GoodsOrderMXDaoIntf mxDaoIntf=new GoodsOrderMXDaoImpl();
		return mxDaoIntf.query(pageBean,goodsOrderMX);
	}

	@Override
	public int getCount(GoodsOrderMX goodsOrderMX) {
		GoodsOrderMXDaoIntf mxDaoIntf=new GoodsOrderMXDaoImpl();
		return mxDaoIntf.getCount(goodsOrderMX);
	}

	@Override
	public double totalPriceOfOrder(String id) {
		GoodsOrderMXDaoIntf mxDaoIntf=new GoodsOrderMXDaoImpl();
		return mxDaoIntf.totalPriceOfOrder(id);
	}
}

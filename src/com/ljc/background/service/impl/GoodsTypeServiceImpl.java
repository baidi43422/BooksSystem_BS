package com.ljc.background.service.impl;

import java.util.List;

import com.ljc.background.dao.impl.GoodsTypeDaoImpl;
import com.ljc.background.dao.intf.GoodsTypeDaoIntf;
import com.ljc.background.model.GoodsType;
import com.ljc.background.service.intf.GoodsTypeServiceIntf;
import com.ljc.util.PageBean;

public class GoodsTypeServiceImpl implements GoodsTypeServiceIntf {

	@Override
	public boolean add(GoodsType goodsType) {
	GoodsTypeDaoIntf daoIntf = new GoodsTypeDaoImpl();
		return daoIntf.addGoodsType(goodsType);
	}

	@Override
	public boolean update(GoodsType goodsType) {
		GoodsTypeDaoIntf daoIntf = new GoodsTypeDaoImpl();
		return daoIntf.updateGoodsType(goodsType);
	}

	@Override
	public boolean dele(GoodsType goodsType) {
		GoodsTypeDaoIntf daoIntf = new GoodsTypeDaoImpl();
		return daoIntf.deletdGoodsType(goodsType);
	}

	@Override
	public PageBean<GoodsType> query(PageBean<GoodsType> pageBean,
			GoodsType goodsType) {
		GoodsTypeDaoIntf daoIntf = new GoodsTypeDaoImpl();
		return daoIntf.query(pageBean, goodsType);
	}

	@Override
	public List<GoodsType> getAllType() {
		GoodsTypeDaoIntf daoIntf = new GoodsTypeDaoImpl();
		return daoIntf.getAllType();
	}

	@Override
	public int getCount(String p_id) {
		GoodsTypeDaoIntf daoIntf = new GoodsTypeDaoImpl();
		return daoIntf.getCount(p_id);
	}

	@Override
	public PageBean<GoodsType> query(PageBean<GoodsType> pageBean, String p_id) {
		GoodsTypeDaoIntf daoIntf = new GoodsTypeDaoImpl();
		return daoIntf.query(pageBean, p_id);
	}

}

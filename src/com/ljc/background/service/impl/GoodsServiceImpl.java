package com.ljc.background.service.impl;

import com.ljc.background.dao.impl.GoodsDaoImpl;
import com.ljc.background.dao.intf.GoodsDaoIntf;
import com.ljc.background.model.Goods;
import com.ljc.background.service.intf.GoodsServiceIntf;
import com.ljc.util.PageBean;

public class GoodsServiceImpl implements GoodsServiceIntf {

	@Override
	public boolean add(Goods goods) {
		GoodsDaoIntf daoIntf=new GoodsDaoImpl();
		return daoIntf.add(goods);
	}

	@Override
	public boolean deleGoods(Goods goods) {
		GoodsDaoIntf daoIntf=new GoodsDaoImpl();
		return daoIntf.deleGoods(goods);
	}

	@Override
	public boolean updateGoods(Goods goods) {
		GoodsDaoIntf daoIntf=new GoodsDaoImpl();
		return daoIntf.updateGoods(goods);
	}

	@Override
	public PageBean<Goods> query(PageBean<Goods> pageBean, Goods goods) {
		GoodsDaoIntf daoIntf=new GoodsDaoImpl();
		return daoIntf.query(pageBean, goods);
	}

	@Override
	public int getCounts(Goods goods) {
		GoodsDaoIntf daoIntf=new GoodsDaoImpl();
		return daoIntf.getCounts(goods);
	}

	@Override
	public Goods getGoods(Goods goods) {
		GoodsDaoIntf daoIntf=new GoodsDaoImpl();
		return daoIntf.getGoodsByID(goods);
	}

}

package com.ljc.background.dao.intf;

import java.util.List;

import com.ljc.background.model.GoodsType;
import com.ljc.util.PageBean;

public interface GoodsTypeDaoIntf {
	public boolean addGoodsType(GoodsType goodsType);
	public boolean updateGoodsType(GoodsType goodsType);
	public boolean deletdGoodsType(GoodsType goodsType);
	//暂不实现
	public PageBean<GoodsType> query(PageBean<GoodsType> pageBean,GoodsType type);
	public List<GoodsType> getAllType();
}

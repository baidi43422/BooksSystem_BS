package com.ljc.background.service.intf;

import java.util.List;

import com.ljc.background.model.GoodsType;
import com.ljc.util.PageBean;

public interface GoodsTypeServiceIntf {
	public boolean add(GoodsType goodsType);
	public boolean update(GoodsType goodsType);
	public boolean dele(GoodsType goodsType);
	public PageBean<GoodsType> query(PageBean<GoodsType> pageBean,GoodsType goodsType);
	public PageBean<GoodsType> query(PageBean<GoodsType> pageBean,String p_id);
	public List<GoodsType>  getAllType();
	public int getCount(String p_id);
	
}

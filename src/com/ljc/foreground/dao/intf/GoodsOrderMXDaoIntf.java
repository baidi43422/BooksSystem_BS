package com.ljc.foreground.dao.intf;

import com.ljc.foreground.model.GoodsOrderMX;
import com.ljc.foreground.model.OrderMessage;
import com.ljc.util.PageBean;

public interface GoodsOrderMXDaoIntf {
	public boolean addOrderMX(GoodsOrderMX goodsOrderMX);
	public boolean deleteOrderMX(GoodsOrderMX goodsOrderMX);
	public PageBean<OrderMessage> query(PageBean<OrderMessage> pageBean,GoodsOrderMX goodsOrderMX);
	//根据订单明细表修改购买商品的数量
	public boolean UpdateOrderMX(GoodsOrderMX goodsOrderMX);
	public int getCount(GoodsOrderMX goodsOrderMX);
	//获取同一个订单内的总价格
	public double totalPriceOfOrder(String id);//id代表GoodsOrder的ID
}

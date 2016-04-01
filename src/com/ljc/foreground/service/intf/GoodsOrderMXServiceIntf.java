package com.ljc.foreground.service.intf;

import com.ljc.foreground.model.GoodsOrderMX;
import com.ljc.foreground.model.OrderMessage;
import com.ljc.util.PageBean;

public interface GoodsOrderMXServiceIntf {
	public boolean addOrderMX(GoodsOrderMX goodsOrderMX);
	public boolean deleteOrderMX(GoodsOrderMX goodsOrderMX);
	public PageBean<OrderMessage> query(PageBean<OrderMessage> pageBean,GoodsOrderMX goodsOrderMX);
	//根据订单明细表修改购买商品的数量
	public boolean UpdateOrderMX(GoodsOrderMX goodsOrderMX);
	public int getCount(GoodsOrderMX goodsOrderMX);
	public double totalPriceOfOrder(String id);//id代表GoodsOrder的ID
}

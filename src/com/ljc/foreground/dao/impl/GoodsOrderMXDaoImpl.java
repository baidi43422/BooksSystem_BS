package com.ljc.foreground.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ljc.foreground.dao.intf.GoodsOrderMXDaoIntf;
import com.ljc.foreground.model.GoodsOrderMX;
import com.ljc.foreground.model.OrderMessage;
import com.ljc.util.DButil3;
import com.ljc.util.PageBean;

public class GoodsOrderMXDaoImpl implements GoodsOrderMXDaoIntf {

	@Override
	public boolean UpdateOrderMX(GoodsOrderMX goodsOrderMX) {
		String id=goodsOrderMX.getId();
		String goods_id=goodsOrderMX.getGoods_id();
		String order_id=goodsOrderMX.getOrder_id();
		int amount=goodsOrderMX.getAmount();
		String sql="update all_order set id=?,goods_id=?,order_id=?,amount=? where id=?";
		int i=DButil3.update(sql, id, goods_id, order_id, amount, id);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public boolean addOrderMX(GoodsOrderMX goodsOrderMX) {
		String id=goodsOrderMX.getId();
		String goods_id=goodsOrderMX.getGoods_id();
		String order_id=goodsOrderMX.getOrder_id();
		int amount=goodsOrderMX.getAmount();
		String sql="insert into all_order values(?,?,?,?)";
		int i=DButil3.addElement(sql, id, goods_id, order_id, amount);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteOrderMX(GoodsOrderMX goodsOrderMX) {
		String id=goodsOrderMX.getId();
		String sql="delete from all_order where id=?";
		int i=DButil3.deleteData(sql, id);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public PageBean<OrderMessage> query(PageBean<OrderMessage> pageBean,GoodsOrderMX goodsOrderMX) {
		String goods_id=goodsOrderMX.getGoods_id();
		String order_id=goodsOrderMX.getOrder_id();
		List<OrderMessage> list=new ArrayList<OrderMessage>();
		int start=(pageBean.getCurrentPage()-1)*pageBean.getCountOfPage();
		int end=pageBean.getCountOfPage();
		String sql="select g.name,g.price,g.remark,g.small_pic,a.amount,g.price*a.amount totalPrice from"+
		"(select * from goods) g,(select amount,goods_id from all_order where order_id=?) a"+
			"where g.id=a.goods_id limit ?,?;";
		ResultSet re=DButil3.getSet1(sql, order_id,start,end);
		try {
			while(re.next()){
				String name=re.getString("name");
				double price=re.getDouble("price");
				String remark=re.getString("remark");
				String small_pic=re.getString("small_pic");
				int amount=re.getInt("amount");
				double totalPrice=re.getDouble("totalPrice");
				OrderMessage orderMessage=new OrderMessage(name, price, remark, small_pic, amount, totalPrice);
				list.add(orderMessage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setData(list);
		return pageBean;
	}

	@Override
	public int getCount(GoodsOrderMX goodsOrderMX) {
		String order_id=goodsOrderMX.getOrder_id();
		String sql="select count(*) c from where order_id=?";
		ResultSet re=DButil3.getSet1(sql, order_id);
		int i=0;
		try {
			while(re.next()){
				i=re.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public double totalPriceOfOrder(String id) {//idÎª¶©µ¥±àºÅ
		String sql="select SUM(c.totalPrice) sum from"+
		" (select g.price*a.amount totalPrice from"+
		" (select * from goods ) g,(select amount,goods_id from all_order where order_id=?) a"+
		" where g.id=a.goods_id) c;";
		ResultSet re=DButil3.getSet1(sql, id);
		double i=0;
		try {
			while(re.next()){
				i=re.getDouble("sum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
}

package com.ljc.foreground.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ljc.foreground.dao.intf.GoodsOrderDaoIntf;
import com.ljc.foreground.model.GoodsOrder;
import com.ljc.foreground.model.User;
import com.ljc.util.DButil3;

public class GoodsOrderDaoImpl implements GoodsOrderDaoIntf {

	@Override
	//订单添加应该先生成订单号，加入到数据库，在让对应的订单明细表生成，然后
	//才能根据订单明细设置订单的总价格,所以先设置一个默认的总价格。
	public boolean addOrder(GoodsOrder goodsOrder) {
		String id=goodsOrder.getId();
		double price=0.0;
		Timestamp create_time=goodsOrder.getCreate_time();
		String user_id=goodsOrder.getUser_id();
		String sql="insert into goods_order values(?,?,?,?)";
		int i=DButil3.add(sql, id,price,create_time, user_id);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteOrder(GoodsOrder goodsOrder) {
		String id=goodsOrder.getId();
		String sql="delete from goods_order where id=?";
		int i=DButil3.deleteData(sql, id);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public boolean updateOrder(GoodsOrder goodsOrder) {
		double price=goodsOrder.getPrice();
		String id=goodsOrder.getId();
		String sql="update goods_order set price=? where id=?";
		int i=DButil3.updateElement(sql, price, id);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public List<GoodsOrder> query(User user) {
		List<GoodsOrder> list = new ArrayList<GoodsOrder>();
		String id1=user.getId();
		String sql="select * from goods_order where user_id=?";
		ResultSet re=DButil3.getSet1(sql, id1);
		try {
			while(re.next()){
				String id=re.getString("id");
				double price=re.getDouble("price");
				Timestamp create_time=re.getTimestamp("create_time");
				String user_id=re.getString("user_id");
				GoodsOrder goodsOrder=new GoodsOrder(id, price, create_time, user_id);
				list.add(goodsOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		Timestamp time=new Timestamp(new Date().getTime());
		GoodsOrder goodsOrder=new GoodsOrder("006", 120.2,time, "001");
		new GoodsOrderDaoImpl().addOrder(goodsOrder);
	}

}

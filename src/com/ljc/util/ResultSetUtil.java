package com.ljc.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ljc.background.model.Goods;

//处理resulet的工具类
public class ResultSetUtil {
	public static void  reUtil(ResultSet re,List<Goods> list){
		try {
			while(re.next()){
				String id=re.getString("id");
				String name=re.getString("name");
				String type_id=re.getString("type_id");
				double price=re.getDouble("price");
				int amount=re.getInt("amount");
				String remark=re.getString("remark");
				String small_pic=re.getString("small_pic");
				String big_pic=re.getString("big_pic");
				Goods goods = new Goods(id, name, type_id, price, amount, remark, small_pic, big_pic);
				list.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

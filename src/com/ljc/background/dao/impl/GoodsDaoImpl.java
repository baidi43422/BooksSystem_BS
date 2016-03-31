package com.ljc.background.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ljc.background.dao.intf.GoodsDaoIntf;
import com.ljc.background.model.Goods;
import com.ljc.util.DButil;
import com.ljc.util.PageBean;
import com.ljc.util.ResultSetUtil;

public class GoodsDaoImpl implements GoodsDaoIntf {

	@Override
	public boolean add(Goods goods) {
		String id=goods.getId();
		String name=goods.getName();
		String type_id=goods.getType_id();
		double price=goods.getPrice();
		int amount=goods.getAmount();
		String remark=goods.getRemark();
		String small_pic=goods.getSmall_pic();
		String big_pic=goods.getBig_pic();
		String sql="insert into goods values(?,?,?,?,?,?,?,?)";
		int i=DButil.addGoods(sql, id, name, type_id, price, amount, remark, small_pic, big_pic);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public boolean deleGoods(Goods goods) {
		String sql="delete from goods where id=?";
		int i=DButil.deleteData(sql, goods.getId());
		if(i>0)
			return true;
		return false;
	}

	@Override
	public boolean updateGoods(Goods goods) {
		String id=goods.getId();
		String name=goods.getName();
		String type_id=goods.getType_id();
		double price=goods.getPrice();
		int amount=goods.getAmount();
		String remark=goods.getRemark();
		String small_pic=goods.getSmall_pic();
		String big_pic=goods.getBig_pic();
		String sql="update goods set id=?,name=?,type_id=?,price=?,amount=?,remark=?" +
				",small_pic=?,big_pic=? where id=?";
		int i = DButil.updateGoods(sql, id, name, type_id, price, amount, remark, small_pic, big_pic, id);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public PageBean<Goods> query(PageBean<Goods> pageBean, Goods goods) {
		List<Goods> list = new ArrayList<Goods>();
		String name = goods.getName();
		String type_name=goods.getType_name();
		double p1=goods.getPrice();
		double p2=goods.getPrice1();
		int start=(pageBean.getCurrentPage()-1)*pageBean.getCountOfPage();
		int end=pageBean.getCountOfPage();
		String sql="select count(*) c from goods where name=? and type_id in (select id " +
		"from goods_type where name=?)";
		try {
			if(p1==0 && p2== 0){
						ResultSet re=DButil.loginFind(sql, name,type_name,start,end);
						while(re.next()){
						
						}
					
			}else if(p1==0 && p2!=0){
					sql=sql+"and price=? limit ?,?";
					ResultSet re=DButil.findGoods(sql, name, type_name, p2,start,end);
					ResultSetUtil.reUtil(re, list);
				}else if(p1!=0 && p2==0){
					sql=sql+"and price=? limit ?,?";
					ResultSet re=DButil.findGoods(sql, name, type_name, p1,start,end);
					ResultSetUtil.reUtil(re, list);
				}else{
					sql=sql+"and price>p1 and price<p2 limit ?,?";
					ResultSet re = DButil.findGoods(sql, name,type_name,p1, p2,start,end);
					ResultSetUtil.reUtil(re, list);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pageBean.setData(list);
		return pageBean;
	}

	@Override
	public int getCounts(Goods goods) {
		String name = goods.getName();
		String type_name=goods.getType_name();
		double p1=goods.getPrice();
		double p2=goods.getPrice1();
		int i=0;
		String sql="select count(*) c from goods where name=? and type_id in (select id " +
		"from goods_type where name=?)";
		try {
		if(p1==0 && p2== 0){
					ResultSet re=DButil.loginFind(sql, name,type_name);
					while(re.next()){
						i=re.getInt("c");
					}
				
		}else if(p1==0 && p2!=0){
				sql=sql+"and price=?";
				ResultSet re=DButil.findGoods(sql, name, type_name, p2);
				while(re.next()){
					i=re.getInt("c");
				}
			}else if(p1!=0 && p2==0){
				sql=sql+"and price=?";
				ResultSet re=DButil.findGoods(sql, name, type_name, p1);
				while(re.next()){
					i=re.getInt("c");
				}
			}else{
				sql=sql+"and price>p1 and price<p2";
				ResultSet re = DButil.findGoods(sql, name,type_name,p1, p2);
				while(re.next()){
					i=re.getInt("c");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Goods getGoodsByID(Goods goods) {
		String id = goods.getId();
		String sql="select * from goods where id=?";
		ResultSet re=DButil.getSet1(sql, id);
		try {
			while(re.next()){
				String s=re.getString("small_pic");
				String b=re.getString("big_pic");
				goods.setSmall_pic(s);
				goods.setBig_pic(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

}

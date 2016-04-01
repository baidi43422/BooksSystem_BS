package com.ljc.background.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ljc.background.dao.intf.GoodsTypeDaoIntf;
import com.ljc.background.model.GoodsType;
import com.ljc.util.DButil2;
import com.ljc.util.PageBean;

public class GoodsTypeDaoImpl implements GoodsTypeDaoIntf {

	@Override
	public boolean addGoodsType(GoodsType goodsType) {
		String id = goodsType.getId();
		String name = goodsType.getName();
		String p_id = goodsType.getP_id();
		String sql="insert into goods_type values(?,?,?)";
		int i=DButil2.addElement(sql, id, name, p_id);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public boolean updateGoodsType(GoodsType goodsType) {
		String id = goodsType.getId();
		String name = goodsType.getName();
		String p_id = goodsType.getP_id();
		String sql="update goods_type set id=?,name=?,p_id=? where id=?";
		int i=DButil2.update(sql, id, name, p_id, id);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public boolean deletdGoodsType(GoodsType goodsType) {
		String id=goodsType.getId();
		String sql="delete from goods_type where id=?";
		int i=DButil2.deleteData(sql, id);
		if(i>0)
			return true;
		return false;
	}
	//‘›≤ª µœ÷
	@Override
	public PageBean<GoodsType> query(PageBean<GoodsType> pageBean,
			GoodsType type) {
		
		return null;
	}
	@Override
	public PageBean<GoodsType> query(PageBean<GoodsType> pageBean,String p_id) {
		List<GoodsType> list = new ArrayList<GoodsType>();
		String sql="select * from goods_type where p_id=?";
		ResultSet re=DButil2.findGoodsType(sql, p_id);
		try {
			while(re.next()){
				String id=re.getString("id");
				String name=re.getString("name");
				String pID=re.getString("p_id");
				GoodsType goodsType=new GoodsType(id, name, pID);
				list.add(goodsType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setData(list);
		return pageBean;
	}
	@Override
	public List<GoodsType> getAllType() {
		
		return null;
	}

	@Override
	public int getCount(String p_id) {
		String sql="select count(*) c from goods_type where p_id=?";
		ResultSet re=DButil2.getSet1(sql, p_id);
		int i=0;
		try {
			while(re.next()){
				i =re.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	

}

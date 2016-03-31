package com.ljc.background.model;
/**
 * 商品对象
 * @author scxh
 *
 */
public class Goods {
	private String id;
	private String name;
	private String type_id;
	private double price;
	private int amount;//数量
	private String remark;//商品描述
	private String small_pic;//商品小图
	private String big_pic;//商品大图
	private double price1;//查询使用
	private String type_name;//查询时使用表示父类的名字
	public Goods(String id, String name, String typeId, double price,
			int amount, String remark, String smallPic, String bigPic) {
		super();
		this.id = id;
		this.name = name;
		type_id = typeId;
		this.price = price;
		this.amount = amount;
		this.remark = remark;
		small_pic = smallPic;
		big_pic = bigPic;
	}
	
	public Goods(String name, double price, double price1, String typeName) {
		super();
		this.name = name;
		this.price = price;
		this.price1 = price1;
		type_name = typeName;
	}

	public Goods(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String typeId) {
		type_id = typeId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSmall_pic() {
		return small_pic;
	}
	public void setSmall_pic(String smallPic) {
		small_pic = smallPic;
	}
	public String getBig_pic() {
		return big_pic;
	}
	public void setBig_pic(String bigPic) {
		big_pic = bigPic;
	}

	public double getPrice1() {
		return price1;
	}

	public void setPrice1(double price1) {
		this.price1 = price1;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String typeName) {
		type_name = typeName;
	}
	
}

package com.ljc.foreground.model;

public class OrderMessage {
	private String id;//订单id对应GoodsOrderMX的id
	private String goodsID;//商品的ID
	private String goodsName;
	private double price;//商品的单价
	private String remark;//商品的描述
	private String small_pic;//商品图片
	private int count;//购买的总数量
	private double totalPrice;//这件商品的总价格
	public OrderMessage(String goodsName, double price, String remark,
			String smallPic, int count, double totalPrice) {
		super();
		this.goodsName = goodsName;
		this.price = price;
		this.remark = remark;
		small_pic = smallPic;
		this.count = count;
		this.totalPrice = totalPrice;
	}
	
	
}

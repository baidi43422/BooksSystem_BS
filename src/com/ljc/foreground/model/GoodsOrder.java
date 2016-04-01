package com.ljc.foreground.model;

import java.sql.Timestamp;

public class GoodsOrder {
	private String id;
	private double price;
	private  Timestamp create_time;
	private String user_id;
	
	public GoodsOrder(String id, double price, Timestamp createTime, String userId) {
		super();
		this.id = id;
		this.price = price;
		create_time = createTime;
		user_id = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp createTime) {
		create_time = createTime;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}
	
}

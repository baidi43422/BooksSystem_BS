package com.ljc.foreground.model;
/**
 * 注册用户对象（后台管理员查看）
 * @author scxh
 *
 */
public class User {
	private String id;
	private String name;
	private String pwd;
	private String status;
	private String province;
	private String city;
	private String country;
	private String street;
	private String phone;
	
	public User(String id, String name, String pwd, String status,
			String province, String city, String country, String street,
			String phone) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.status = status;
		this.province = province;
		this.city = city;
		this.country = country;
		this.street = street;
		this.phone = phone;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String id, String name, String status, String province) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.province = province;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

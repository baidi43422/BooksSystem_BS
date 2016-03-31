package com.ljc.background.model;
/**
 * 商品类型对象
 * @author scxh
 *
 */
public class GoodsType {
	private String id;
	private String name;
	private String p_id;//父类id
	
	public GoodsType(String id, String name, String p_id) {
		super();
		this.id = id;
		this.name = name;
		this.p_id = p_id;
	}
	public GoodsType(){
		
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
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String pId) {
		p_id = pId;
	}
	
}

package com.ljc.background.control;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

public class Test {
	private String name;
	private String id;
	public Test(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static void main(String[] args) {
		long time1=new Date().getTime();
		Timestamp time=new Timestamp(time1);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s=simpleDateFormat.format(time);
		System.out.println(s.hashCode());
	}
	public static void lis(List<String> list){
		for(int i=0;i<100;i++){
			list.add("a"+i);
		}
	}
}

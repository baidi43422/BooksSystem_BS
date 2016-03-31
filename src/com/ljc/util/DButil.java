package com.ljc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/*
 连接数据库版本3

*/
public class DButil {
	private static Connection con;
	private static Statement sta;
	private static ResultSet rs;
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	private static FileInputStream fis;
	private static PreparedStatement psta;
	static{
		getPro();
		try {
			Class.forName(driver);
			try {
				con=DriverManager.getConnection(url,user,pwd);
				sta=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void getPro(){
		try {
			//与属性文件建立连接
			fis=new FileInputStream("../webapps/MallSystem/WEB-INF/classes/MySqlJDBC.properties");
			//获取属性文件对象
			Properties pp=new Properties();
			//加载属性文件
			pp.load(fis);
			//读取属性值
			driver=pp.getProperty("DRIVER_NAME");
			url=pp.getProperty("URL");
			user=pp.getProperty("USER_NAME");
			pwd=pp.getProperty("PWD");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static int addElement(String sql,String s1,String s2,String s3,String s4,String s5,int d){
		int i=0;
		try {
			psta=con.prepareStatement(sql);
			psta.setString(1, s1);
			psta.setString(2, s2);
			psta.setString(3, s3);
			psta.setString(4, s4);
			psta.setString(5, s5);
			psta.setInt(6, d);
			i=psta.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static int addUser(String sql,String id,String name,String pwd,
			String  status,String province,String city,String country,
			String street,String phone
		){
		int i=0;
		try {
			psta=con.prepareStatement(sql);
			psta.setString(1, id);
			psta.setString(2, name);
			psta.setString(3, pwd);
			psta.setString(4,status);
			psta.setString(5, province);
			psta.setString(6, city);
			psta.setString(7, country);
			psta.setString(8, street);
			psta.setString(8, phone);
			i=psta.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return i;
	}
		public static int updateBook(String sql,String name,double price,int count,String publish,String type_name,String id){
			int i=0;
			try {
				psta=con.prepareStatement(sql);
				psta.setString(6, id);
				psta.setString(1, name);
				psta.setDouble(2, price);
				psta.setInt(3,count);
				psta.setString(4, publish);
				psta.setString(5, type_name);
				i=psta.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return i;
	}
		public static int update(String sql,String name,String pwd,String status,String id){
			int i=0;
			try {
				psta=con.prepareStatement(sql);
				psta.setString(1, name);
				psta.setString(2, pwd);
				psta.setString(3, status);
				psta.setString(4, id);
				i=psta.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return i;
	}
	public static ResultSet findBooks(String sql,String s1,String s2,String s3){
		try {
			psta=con.prepareStatement(sql);
			psta.setString(1, s1);
			psta.setString(2, s2);
			psta.setString(3, s3);
			rs=psta.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet findBooksOfPage(String sql,String s1,String s2,String s3,int start,int end){
		try {
			psta=con.prepareStatement(sql);
			psta.setString(1, s1);
			psta.setString(2, s2);
			psta.setString(3, s3);
			psta.setInt(4, start);
			psta.setInt(5, end);
			rs=psta.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet findBookType(String sql){
		try {
			psta=con.prepareStatement(sql);
			rs=psta.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//查询符合条件的学生
	public static int add(String sql,String s1,String s2,String s3,String s4){
			int i=0;
		try {
			psta=con.prepareStatement(sql);
			psta.setString(1, s1);
			psta.setString(2, s2);
			psta.setString(3, s3);
			psta.setString(4, s4);
			i=psta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	
	public static int deleteData(String sql,String s){
		int i=0;
		try {
			psta=con.prepareStatement(sql);
			psta.setString(1, s);
			i=psta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet loginFind(String sql,String s1,String s2) throws SQLException{
		psta=con.prepareStatement(sql);
		psta.setString(1, s1);
		psta.setString(2,s2);
		rs=psta.executeQuery();
		return rs;
	}
	//使用prepareStatement实现增删改查
	public static ResultSet getSet1(String sql,String s){
		try {
			psta=con.prepareStatement(sql);
			psta.setString(1, s);
			rs=psta.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet getSet(String sql){
		try {
			rs=sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static int getUp(String sql){
		int a=0;
		try {
			a = sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public static void closeLiu(){
		try {
			if(fis!=null){
			fis.close();
			System.out.println("fis关闭成功");
			}
			if(rs!=null){
				rs.close();
				System.out.println("rs关闭成功");
			}
			if(sta!=null){
				sta.close();
				System.out.println("sta关闭成功");
			}
			if(con!=null){
				con.close();
				System.out.println("con关闭成功");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
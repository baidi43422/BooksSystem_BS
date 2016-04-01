package com.ljc.foreground.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ljc.foreground.model.GoodsOrder;
import com.ljc.foreground.service.impl.GoodsOrderServiceImpl;
import com.ljc.foreground.service.intf.GoodsOrderServiceIntf;

public class AddOrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddOrderServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//只需要从前台接收订单用户的ID，时间和订单号后台生成,订单号为用户id的前两位+当前时间的HashCode
		String user_id=request.getParameter("user_id");
		long time1=new Date().getTime();
		Timestamp time=new Timestamp(time1);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s=simpleDateFormat.format(time);
		String id=user_id.substring(0,3)+s.hashCode();
		GoodsOrderServiceIntf serviceIntf=new GoodsOrderServiceImpl();
		GoodsOrder goodsOrder=new GoodsOrder(id, 0, time, user_id);
		boolean temp=serviceIntf.addOrder(goodsOrder);
		if(temp){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

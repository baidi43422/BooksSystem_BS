package com.ljc.background.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljc.background.model.Goods;
import com.ljc.background.service.impl.GoodsServiceImpl;
import com.ljc.background.service.intf.GoodsServiceIntf;

public class DeletGoodsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeletGoodsServlet() {
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
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("gID");
		String path="E:/百度云下载文件/javaEE/1-20/day08_tomcat服务器/" +
		"day08_tomcat服务器/03.资料和工具/apache-tomcat-6.0.39/webapps" +
		"/MallSystem/goodsImg/";
		id="002";
		Goods goods = new Goods();
		goods.setId(id);
		GoodsServiceIntf intf = new GoodsServiceImpl();
		Goods goods1=intf.getGoods(goods);
		boolean temp = intf.deleGoods(goods);
		if(temp){
			File f= new File(path+goods1.getSmall_pic());
			File f1= new File(path+goods1.getBig_pic());
			//要同时删除两张照片才算删除成功！
			if(f.exists() && f1.exists() && f.delete() && f1.delete()){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除用户成功图片删除失败！");
			}
			
		}else{
			System.out.println("删除失败！");
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

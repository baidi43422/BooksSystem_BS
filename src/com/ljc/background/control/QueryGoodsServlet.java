package com.ljc.background.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.ljc.background.model.Goods;
import com.ljc.background.service.impl.GoodsServiceImpl;
import com.ljc.background.service.intf.GoodsServiceIntf;
import com.ljc.util.PageBean;
/**
 * 查询商品的类，前端使用ajax
 * @author scxh
 *
 */

public class QueryGoodsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryGoodsServlet() {
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
		GoodsServiceIntf serviceIntf = new GoodsServiceImpl();
		String name=request.getParameter("gName");
		String type_name=request.getParameter("typeName");
		String price1=request.getParameter("gPrice1");
		String price2=request.getParameter("gPrice2");
		String currentPage=request.getParameter("currentPage");
		double p1=0;
		double p2=0;
		Goods goods=null;
		try{
			if("".equals(price1))
				p1=Double.parseDouble(price1);
			if("".equals(price2))
				p2=Double.parseDouble(price2);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
			name="".equals(name) ? "%" : name;
			type_name="".equals(type_name) ? "%":type_name;
			goods=new Goods(name, p1, p2, type_name);
		
		int count = serviceIntf.getCounts(goods);
		PageBean<Goods> pageBean=new PageBean<Goods>(count);
		if("".equals(currentPage) && currentPage!=null){
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}
		pageBean=serviceIntf.query(pageBean, goods);
		JSONObject json=JSONObject.fromObject(pageBean);
		out.print(json);
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

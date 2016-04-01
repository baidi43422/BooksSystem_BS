package com.ljc.foreground.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljc.background.model.Goods;
import com.ljc.background.service.impl.GoodsServiceImpl;
import com.ljc.background.service.intf.GoodsServiceIntf;
import com.ljc.util.PageBean;

public class GetGoodsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetGoodsServlet() {
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
	 * ��ȡ��Ӧ���͵���Ʒ
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String typeId=request.getParameter("typeID");
		String currentPage=request.getParameter("currentPage");
		Goods goods=new Goods("", 0,0, typeId);
		GoodsServiceIntf serviceIntf = new GoodsServiceImpl();
		int count=serviceIntf.getCounts(goods);
		PageBean<Goods> pageBean = new PageBean<Goods>(count);
		if(currentPage != null && !"".equals(currentPage)){
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}
		//����һҳ��ʾ������
		pageBean.setCountOfPage(30);
		pageBean=serviceIntf.query(pageBean, goods);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("").forward(request, response);
		
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
package com.ljc.foreground.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.ljc.foreground.model.User;
import com.ljc.foreground.service.impl.UserServiceImpl;
import com.ljc.foreground.service.intf.UserServiceIntf;
import com.ljc.util.PageBean;

/**
 * 查询用户的类，前端使用ajax
 * @author scxh
 *
 */
public class QueryUserServelt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryUserServelt() {
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
		String id=request.getParameter("uID");
		String name=request.getParameter("uName");
		String province=request.getParameter("uProcince");
		String status=request.getParameter("status");
		String currentPage=request.getParameter("currentPage");
		id="".equals(id) ? "%" : id;
		name="".equals(name) ? "%" : name;
		province="".equals(province) ? "%" : province;
		status="".equals(status) ? "%" : status;
		User user = new User(id, name, status, province);
		UserServiceIntf serviceIntf =new UserServiceImpl();
		int count=serviceIntf.getCount(user);
		PageBean<User> pageBean=new PageBean<User>(count);
		if("".equals(currentPage) && currentPage!=null){
			  pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}
		pageBean=serviceIntf.query(pageBean, user);
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

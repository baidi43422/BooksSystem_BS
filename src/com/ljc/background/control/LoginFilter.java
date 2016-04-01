package com.ljc.background.control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljc.background.model.Controller;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
			HttpServletRequest httpServletRequest=(HttpServletRequest)arg0;
			Controller controller=(Controller)httpServletRequest.getSession().getAttribute("controller");
			if(controller != null){
				//如果登录了就请求继续
				arg2.doFilter(arg0, arg1);
			}else{
				//如果没有登录就跳转到登录页面
				//httpServletRequest.getRequestDispatcher("/login.html").forward(arg0, arg1);
				HttpServletResponse httpServletResponse=(HttpServletResponse)arg1;
				httpServletResponse.sendRedirect("../login.html");
			}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

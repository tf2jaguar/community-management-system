package com.shetuan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Administrator
 */
public class PermissionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 获取请求的URL
		String requestURL = req.getRequestURI();
		// 获取session
		HttpSession session = req.getSession();
		// 获取session域中的login字段，判断是否登录
		Object login = session.getAttribute("login");

		// 获取项目根路径
		int num = requestURL.indexOf("shetuan");
		String shetuan = requestURL.substring(0, num + "shetuan/".length());

		// 添加不拦截的请求
		if (requestURL != null
				&& (requestURL.equals("/login.jsp") || requestURL.equals("/admin_login.jsp")
						|| requestURL.equals("/index.jsp"))
				|| requestURL.equals("/Login") || requestURL.equals("/error.html")) {
			chain.doFilter(req, resp);
		} else {
			// 拦截后检查是否登录
			if (login == null) {
				// 未登录，返回主页
				req.getSession().setAttribute("msg", 1);
				resp.sendRedirect(shetuan + "index.jsp");
			} else {
				// 登录，不做拦截
				chain.doFilter(req, resp);
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}

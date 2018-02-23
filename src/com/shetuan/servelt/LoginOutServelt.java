package com.shetuan.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 退出登录servlet
 * 
 * @author Administrator
 */
public class LoginOutServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取session
		HttpSession session = request.getSession();
		// 获取是普通页面退出还是后台退出
		String log = (String) session.getAttribute("log");
		request.getSession().invalidate();
		if (log != null) {
			if (log.equals("log")) {
				// 普通界面退出，返回主页
				response.sendRedirect("index.jsp");
			} else if (log.equals("admin")) {
				// 后天退出，返回后台登录界面
				response.sendRedirect("admin_login.jsp");
			}
		} else {
			response.sendRedirect("index.jsp");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.shetuan.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.Login;
import com.shetuan.bean.Member;
import com.shetuan.dao.LoginDao;
import com.shetuan.dao.MemberDao;

/**
 * 登录的servlet
 * 
 * @author Administrator
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取是普通界面登录还是后台登录的标记
		String log = request.getParameter("log");
		request.getSession().setAttribute("log", log);
		// 获取返回URL值ַ
//		String returnUri = request.getParameter("return_uri");

		LoginDao logindao = new LoginDao();
		MemberDao memberdao = new MemberDao();

		// 获取界面传入的用户名密码
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		// 调用登录方法
		Login login = logindao.login(username, userpass);
		if (login == null) {// 登录失败，返回到对应的请求界面
			if (log.equals("log")) {
				request.getRequestDispatcher("login.jsp?error=uname").forward(request, response);
				return;
			} else if (log.equals("admin")) {
				request.getRequestDispatcher("admin_login.jsp?error=uname").forward(request, response);
				return;
			}
		} else {// 登陆成功，登录到对应界面
			if (log.equals("log")) {// 登录到普通界面
				request.getSession().setAttribute("msg", 2);
				request.getSession().setAttribute("login", login);
				response.sendRedirect("index.jsp");
				return;
			} else if (log.equals("admin")) {// 登录到后台
				Member member = memberdao.getMemberByName(login.getLoginName());
				request.getSession().setAttribute("member", member);
				response.sendRedirect("admin");
				return;
			}
		}
	}

}

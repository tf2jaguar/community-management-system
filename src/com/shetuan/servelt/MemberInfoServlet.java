package com.shetuan.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.Member;
import com.shetuan.dao.MemberDao;

/**
 * 成员信息Servlet
 * 
 * @author Administrator
 */
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取界面传来的成员姓名
		String membername = request.getParameter("mname");
		// 调用memberdao方法获取member
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.getMemberByName(membername);
		request.setAttribute("member", member);
		// 返回到成员信息页面
		request.getRequestDispatcher("admin/memberInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

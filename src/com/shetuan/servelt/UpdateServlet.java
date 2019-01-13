package com.shetuan.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.Login;
import com.shetuan.dao.LoginDao;
import com.shetuan.dao.MemberDao;
/**
 * 所有的更新servlet
 * @author Administrator
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDao logindao = new LoginDao();
		String ope = request.getParameter("ope");
		System.out.println("Updateservlet " + ope);
		if (ope.equals("mupdate")) {
			/**
			 * MemberUpdate
			 */
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String uppass2 = request.getParameter("newpass2");
			// ��ȡ���ݿ����˺����룬�����ж�������Ϣ�Ƿ����
			Login db_login = logindao.getLoginByName(username);

			System.out.println("loginservlet->update");
			if (db_login == null) {
				request.getRequestDispatcher("manager_update.jsp?rs=namewrong").forward(request, response);
			} else {
				String db_pass = db_login.getLoginPass();
				if (!db_pass.equals(userpass)) {
					System.out.println("db_pass!=uppass" + db_pass + " " + userpass);
					request.getRequestDispatcher("manager_update.jsp?rs=wrong").forward(request, response);
				} else {
					int rs = logindao.updatePassword(Integer.parseInt(username), uppass2);
					if (rs > 0) {
						System.out.println("rs>0 " + rs);
						response.sendRedirect("manager_update.jsp?rs=success");
					} else {
						System.out.println("更新失败" + rs);
						request.getRequestDispatcher("manager_update.jsp?rs=fail").forward(request, response);
					}
				}
			}
		} else if (ope.equals("dele")) {
			int loginName = Integer.parseInt(request.getParameter("loginname"));
			MemberDao memberdao = new MemberDao();
			memberdao.deleteMember(loginName);

		}

	}

}

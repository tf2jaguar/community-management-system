package com.shetuan.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.Community;
import com.shetuan.bean.Login;
import com.shetuan.bean.Member;
import com.shetuan.dao.CommunityDao;
import com.shetuan.dao.LoginDao;
import com.shetuan.dao.MemberDao;

/**
 * 所有的注册servlet
 * 
 * @author Administrator
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDao logindao = new LoginDao();
		MemberDao memberDao = new MemberDao();
		CommunityDao communitydao = new CommunityDao();
		Object ope = request.getParameter("ope");
		System.out.println("registServlet" + ope);

		if (ope.equals("manager")) {
			/**
			 * LoginRegist
			 */
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String managerId = request.getParameter("power");
			Login login = new Login();
			login.setLoginName(username);
			login.setLoginPass(userpass);
			login.setManagerId(Integer.parseInt(managerId));
			String judge = logindao.addLogin(login);
			if (judge.equals("success")) {
				System.out.println("登录成功");
				request.getRequestDispatcher("admin/manager_add.jsp?rs=success").forward(request, response);
			} else if (judge.equals("exist")) {
				request.getRequestDispatcher("admin/manager_add.jsp?rs=exist").forward(request, response);
			} else {
				request.getRequestDispatcher("admin/manager_add.jsp?rs=fail").forward(request, response);
			}
		} else if (ope.equals("index")) {
			/**
			 * IndexRegist
			 */
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String useremail = request.getParameter("email");
			String userphone = request.getParameter("phone");
			Login login = new Login();
			login.setLoginName(username);
			login.setLoginPass(userpass);
			Member member = new Member();
			member.setMemberEmail(useremail);
			member.setMemberPhone(userphone);
			String judge = memberDao.addIndexLogin(login, member);
			if (judge.equals("success")) {
				System.out.println("注册成功");
				request.getRequestDispatcher("regist.jsp?rs=success").forward(request, response);
			} else if (judge.equals("exist")) {
				request.getRequestDispatcher("regist.jsp?rs=exist").forward(request, response);
			} else {
				request.getRequestDispatcher("regist.jsp?rs=fail").forward(request, response);
			}

		} else if (ope.equals("community")) {
			/**
			 * CommunityRegist
			 */

			String cname = request.getParameter("communityName");
			String crname = request.getParameter("createrName");

			int createrId = memberDao.getLoginNameByName(crname);
			if (createrId == 0) {
				System.out.println("创建者 " + crname );
				request.getRequestDispatcher("admin/community_add.jsp?rs=mNotIn").forward(request, response);
			} else {
				String crdate = request.getParameter("createDate");
				int csum = Integer.parseInt(request.getParameter("communitySum"));
				String crange = request.getParameter("communityRange");
				int cclass = Integer.parseInt(request.getParameter("communityClass"));
				String cInfo = request.getParameter("communityInfo");
				int isCreate = Integer.parseInt(request.getParameter("isCreate"));

				Community community = new Community();
				community.setCommunityName(cname);
				community.setCommunityCreaterId(createrId);
				community.setCommunityCreateDate(crdate);
				community.setCommunityNum(csum);
				community.setCommunityRange(crange);
				community.setCommunityClassId(cclass);
				community.setCommunityInfo(cInfo);
				community.setCommunityCreate(isCreate);

				String judge = communitydao.addAdminCommunity(community);
				if (judge.equals("success")) {
					System.out.println("创建成功");
					request.getRequestDispatcher("admin/community_add.jsp?rs=success").forward(request, response);
				} else if (judge.equals("exist")) {
					request.getRequestDispatcher("admin/community_add.jsp?rs=exist").forward(request, response);
				} else {
					request.getRequestDispatcher("admin/community_add.jsp?rs=fail").forward(request, response);
				}
			}
		}

	}

}

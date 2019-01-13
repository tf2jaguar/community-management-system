package com.shetuan.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.Activity;
import com.shetuan.bean.Community;
import com.shetuan.bean.Member;
import com.shetuan.dao.ActivityDao;
import com.shetuan.dao.CommunityDao;
import com.shetuan.dao.MemberDao;
import com.shetuan.util.Page;

/**
 * 所有的查询servlet
 * 
 * @author Administrator
 */
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取界面传来的判断参数
		String lru = request.getParameter("lru");
		MemberDao memberdao = new MemberDao();
		if (lru.equals("ulist")) {// 查询所有的member，结果集

			String cpagestr = request.getParameter("cpage");
			System.out.println("MemberServlet-获取所有member:" + cpagestr);
			int cpage = 1;
			if (cpagestr != null) {
				cpage = Integer.parseInt(cpagestr.trim());
			}

			Page page = new Page();
			page.setPageCurrent(cpage);

			List<Member> members = memberdao.getMembersForPage(page);

			request.setAttribute("members", members);
			request.setAttribute("page", page);
			// 跳转到成员列表界面
			request.getRequestDispatcher("member_list.jsp").forward(request, response);
		} else if (lru.equals("clist")) {// 查询所有的社团，结果集

			CommunityDao communitydao = new CommunityDao();
			String cpagestr = request.getParameter("cpage");
			System.out.println("communityServlet-获取所有社团:" + cpagestr);
			int cpage = 1;
			if (cpagestr != null) {
				cpage = Integer.parseInt(cpagestr.trim());
			}

			Page page = new Page();
			page.setPageCurrent(cpage);

			List<Community> communities = communitydao.getCommunitiesForPage(page);
			request.setAttribute("Community", communities);
			request.setAttribute("page", page);
			// 跳转到社团列表界面
			request.getRequestDispatcher("community_list.jsp").forward(request, response);
		} else if (lru.equals("alist")) {// 查询时所有的社团活动，结果集

			ActivityDao activityDao = new ActivityDao();
			String cpagestr = request.getParameter("cpage");
			int cpage = 1;
			if (cpagestr != null) {
				cpage = Integer.parseInt(cpagestr.trim());
			}

			Page page = new Page();
			page.setPageCurrent(cpage);
			List<Activity> activities = activityDao.getActivitiesForPage(page);
			request.setAttribute("activity", activities);
			request.setAttribute("page", page);
			// 跳转到社团活动列表界面
			request.getRequestDispatcher("communityactivity_list.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

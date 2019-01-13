package com.shetuan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shetuan.bean.Login;
import com.shetuan.bean.Member;
import com.shetuan.util.Page;

/**
 * 成员的增删改查
 * 
 * @author Administrator
 */
public class MemberDao extends BaseDao {
	/**
	 * 获取成员列表
	 * 
	 * @param page
	 * @return
	 */
	public List<Member> getMembersForPage(Page page) {

		List<Member> members = new ArrayList<Member>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "select count(1) from member as m,login as l,community as c where m.login_name=l.login_name and  m.join_communityId=c.community_id ";
			// 执行SQL
			exeQuery(countsql);
			// 获取结果集
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果结果集存在，获取该字段，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 查询成员的详细信息
			String sql = "select l.login_name,m.member_name,m.member_gender,l.manager_id,m.member_grade,m.member_institute,m.member_phone,m.member_email,c.community_name from member as m,login as l,community as c where m.login_name=l.login_name and  m.join_communityId=c.community_id limit ?,?";
			//// 执行sql ，传入分页的起始页，每页大小
			exeQuery(sql, page.getItemStart(), page.getPageSize());
			// 获取结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果集存在，获取对应字段将其赋值给一个新的member对象，并将其添加到members集合中
			while (rs.next()) {
				Member member = new Member();
				member.setLoginName(rs.getString("login_name"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberGender(rs.getString("member_gender"));
				member.setManagerId(rs.getInt("manager_id"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMemberInstitute(rs.getString("member_institute"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setJoinCommunity(rs.getString("community_name"));
				//将member添加到集合中
				members.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return members;
	}

	/**
	 * 根据登录名名获取成员对象
	 * @param loginname
	 * @return
	 */
	public Member getMemberByName(String loginname) {
		Member member = new Member();
		try {
			//获取连接
			getCon();
			//要执行的SQL
			String sql = "select l.login_name,m.member_name,m.member_gender,l.manager_id,m.member_grade,m.member_institute,m.member_add,m.member_phone,m.member_email,member_header,c.community_name from member as m,login as l,community as c where m.login_name=l.login_name and  m.join_communityId=c.community_id and l.login_name=?";
			//执行查询，并传入参数：登录名
			exeQuery(sql, loginname);
			//获取结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			//如果结果集存在，获取对应的字段将其赋值都给member对象
			while (rs.next()) {
				member.setLoginName(rs.getString("login_name"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberGender(rs.getString("member_gender"));
				member.setManagerId(rs.getInt("manager_id"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMemberInstitute(rs.getString("member_institute"));
				member.setMemberAdd(rs.getString("member_add"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setMemberHeader(rs.getString("member_header"));
				member.setJoinCommunity(rs.getString("community_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return member;
	}

	/**
	 * 主页中的注册
	 * @param login
	 * @param member
	 * @return
	 */
	public String addIndexLogin(Login login, Member member) {
		String judge = null;
		try {
			//获取连接
			Connection con = getCon();
			//根据登录名获取登录对象
			LoginDao logindao = new LoginDao();
			Login l = logindao.getLoginByName(login.getLoginName());
			if (l == null) {//判断该登录名是否可用
				try {
					//设置不自动提交
					con.setAutoCommit(false);
					//要插入到login  和  member  的 SQL
					String sql = "insert into login(login_name,login_pass) values(?,?)";
					String sql1 = "insert into member(login_name,member_email,member_phone)values(?,?,?)";
					//获取SQL执行结果
					int temp = exeUpdate(sql, login.getLoginName(), login.getLoginPass());
					int temp1 = exeUpdate(sql1, login.getLoginName(), member.getMemberEmail(), member.getMemberPhone());
					//如果两条SQL都执行成功，则提交，否自回滚
					if (temp > 0 && temp1 > 0) {// 都执行成功
						//提交事务
						con.commit();
						//设置为自动提交
						con.setAutoCommit(true);
						judge = "success";
					} else {//有失败的信息
						//回滚事务，不提交
						con.rollback();
						//设为自动提交
						con.setAutoCommit(true);
						judge = "fail";
					}
				} catch (Exception e) {
					judge = "fail";
				} finally {
					//关闭所有连接
					closeAll();
				}
			} else {//该登录名已经存在，不能注册，退出
				judge = "exist";
			}
		} catch (SQLException e) {
			System.out.println("MemberDao addIndexLogin is wrong");
			judge = "fail";
		}
		return judge;
	}

	/**
	 * 添加成员
	 * @param member
	 * @return
	 */
	public int addMember(Member member) {
		int msg = 0;
		try {
			//获取连接
			getCon();
			//要执行的插入SQL语句
			String sql = "insert into member(member_name,member_gender,member_head,member_grade,member_add,member_email,member_phone,creat_community,join_communityId) values(?,?,?,?,?,?,?,?,?)";
			//执行SQL，并传参数，并获手影响行数
			msg = exeUpdate(sql, member.getMemberName(), member.getMemberGender(), member.getMemberHeader(),
					member.getMemberGrade(), member.getMemberAdd(), member.getMemberEmail(), member.getMemberPhone(),
					member.getIscreatCommunity(), member.getIsJoinCommunity());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return msg;
	}

	/**
	 * 根据登录名删除成员
	 * @param loginName
	 * @return
	 */
	public int deleteMember(int loginName) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的删除SQL
			String sql = "delete from member where login_name=?";
			//执行SQL传入参数，并获取受影响行数
			result = exeUpdate(sql, new Object[] { loginName });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}

	/**
	 * 更新成员 根据loginname
	 * @param member
	 * @return
	 */
	public int updateMember(Member member) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的更新SQL
			String sql = "update member set member_name=?,member_gender=?,member_header=?,member_grade=?,member_institute=?,member_add=?,member_email=?,member_phone=?,creat_community=?,join_communityId=? where login_name=?";
			//执行SQL传入参数，并获取手影响行数
			result = exeUpdate(sql,
					new Object[] { member.getMemberName(), member.getMemberGender(), member.getMemberHeader(),
							member.getMemberGrade(), member.getMemberInstitute(), member.getMemberAdd(),
							member.getMemberEmail(), member.getMemberPhone(), member.getIscreatCommunity(),
							member.getIsJoinCommunity(), member.getLoginName() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}

	/**
	 * 根据成员名获取登录名
	 * @param membername
	 * @return
	 */
	public int getLoginNameByName(String membername) {
		int loginName = 0;
		try {
			//获取连接
			getCon();
			//要执行的查询SQL，
			String sql = "select login_name from member where member_name=?";
			//执行SQL并传入参数
			exeQuery(sql, membername);
			//获取结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			//如果结果集存在，获取对应loginName字段
			while (rs.next()) {
				loginName = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return loginName;
	}

	/**
	 * 未搜索框获取成员列表
	 * @param membername  模糊字段
	 * @param page 分页信息
	 * @return
	 */
	public List<Member> getMemberForSerach(String membername, Page page) {
		List<Member> members = new ArrayList<Member>();

		try {
			//获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "select count(1) from member as m,login as l,community as c where m.login_name=l.login_name and  m.join_communityId=c.community_id and m.member_name like ? ";
			//执行SQL 并传入参数
			exeQuery(countsql, "%" + membername + "%");
			//获取结果集
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果存在结果，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			//要执行的查询的SQL
			String sql = "select l.login_name,m.member_name,m.member_gender,l.manager_id,m.member_grade,m.member_institute,m.member_phone,m.member_email,c.community_name from member as m,login as l,community as c where m.login_name=l.login_name and  m.join_communityId=c.community_id and m.member_name like ? limit ?,?";
			//执行SQL 并传入参数
			exeQuery(sql, "%" + membername + "%", page.getItemStart(), page.getPageSize());
			//获取结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			//如果结果集不为空，获取相应字段，赋值给一个新的member对象，并将其添加到members集合
			while (rs.next()) {
				Member member = new Member();
				member.setLoginName(rs.getString("login_name"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberGender(rs.getString("member_gender"));
				member.setManagerId(rs.getInt("manager_id"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMemberInstitute(rs.getString("member_institute"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setJoinCommunity(rs.getString("community_name"));
				//将member对象添加到members集合中
				members.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return members;
	}

}

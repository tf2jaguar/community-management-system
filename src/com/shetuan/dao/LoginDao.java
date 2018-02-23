package com.shetuan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shetuan.bean.Login;

/**
 * 登录信息的增删改查
 * 
 * @author Administrator
 */
public class LoginDao extends BaseDao {
	/**
	 * 获取所有登录信息
	 * 
	 * @return 登录对象的 集和
	 */
	public List<Login> getLogins() {
		List<Login> logins = new ArrayList<Login>();
		try {
			// 获取连接
			getCon();
			Statement statement = connection.createStatement();
			String sql = "select login_id,manager_id,login_name,login_pass from login";
			// 执行sql
			ResultSet rs = statement.executeQuery(sql);
			// 如果结果存在，获取每一个字段的值，将其赋值给新的login对象,并将新的login对象添加到logins集合中
			while (rs.next()) {
				int mId = rs.getInt("login_id");
				int maId = rs.getInt("manager_id");
				String lName = rs.getString("login_name");
				String lPass = rs.getString("login_pass");
				// 创建新的login对象
				Login login = new Login();
				login.setLoginId(mId);
				login.setManagerId(maId);
				login.setLoginName(lName);
				login.setLoginPass(lPass);
				// 将该对象添加到logins集合中
				logins.add(login);
			}
			// 关闭结果集
			rs.close();
			// 关闭statement
			statement.close();
			// 关闭连接
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭全部连接
			closeAll();
		}
		return logins;
	}

	/**
	 * 根据登录名获取登录对象
	 * 
	 * @param loginName
	 * @return
	 */
	public Login getLoginByName(String loginName) {
		Login login = null;
		try {
			// 如果当前没有connection，创建新的连接，否则，使用当前连接
			if (connection == null) {
				getCon();
			}
			// 要执行的sql语句
			String sql = "select login_name,login_pass,manager_id from login where login_name=?";
			// 执行sql
			exeQuery(sql, new Object[] { loginName });
			// 获取返回结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果集存在，获取没一个字段并将其封装为一个login对象
			if (rs.next()) {
				login = new Login();
				login.setLoginName(rs.getString("login_name"));
				login.setLoginPass(rs.getString("login_pass"));
				login.setManagerId(rs.getInt("manager_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return login;
	}

	/**
	 * 根据登录名获取密码
	 * 
	 * @param loginName
	 * @return
	 */
	public String getPassByName(String loginName) {
		String login_pass = null;
		try {
			// 获取连接
			getCon();
			// 要执行的sql
			String sql = "select login_pass from login where login_name=?";
			// 执行查询，传入参数：登录名
			exeQuery(sql, loginName);
			// 获取结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果集存在，获取login_pass字段
			if (rs.next()) {
				login_pass = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 关闭所有连接
		closeAll();
		return login_pass;

	}

	/**
	 * 根据登录名获取权限
	 * 
	 * @param loginName
	 * @return
	 */
	public int getPower(String loginName) {
		// 默认权限为 0
		int manager_id = 0;
		try {
			// 获取连接
			getCon();
			// 要执行的sql
			String sql = "select manager_id from login where login_name=?";
			// 执行sql。并传入参数：登录名
			exeQuery(sql, loginName);
			// 获取结果集
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果集存在，获取manager_id字段
			if (rs.next()) {
				manager_id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 关闭所有连接
		closeAll();
		return manager_id;

	}

	/**
	 * 添加登录用户
	 * 
	 * @param login
	 * @return
	 */
	public String addLogin(Login login) {
		String judge = null;
		try {
			// 获取连接
			Connection con = getCon();
			// 获取传入的用户名
			String uname = login.getLoginName();
			// 查询该用户是否存在
			Login l = getLoginByName(uname);
			if (l == null) {// 用户不存在，可以注册
				try {
					// 设置事务，不自动提交
					con.setAutoCommit(false);
					// 同时添加到login和member表中
					String sql = "insert into login(login_name,login_pass,manager_id) values(?,?,?)";
					String sql1 = "insert into member(login_name)values(?)";
					// 执行sql，传入参数，并获取执行结果
					int temp = exeUpdate(sql, login.getLoginName(), login.getLoginPass(), login.getManagerId());
					int temp1 = exeUpdate(sql1, login.getLoginName());
					// 判断是否成功
					if (temp > 0 && temp1 > 0) {// 两个都插入成功
						// 提交事务
						con.commit();
						// 设置自动提交
						con.setAutoCommit(true);
						judge = "success";
					} else {// 插入有错误
						// 取消提交
						con.rollback();
						// 设置自动提交
						con.setAutoCommit(true);
						judge = "fail";
					}
				} catch (Exception e) {
					judge = "fail";
				} finally {
					// 关闭所有连接
					closeAll();
				}
			} else {// 用户名已经存在不能注册，退出
				judge = "exist";
			}
		} catch (SQLException e) {
			System.out.println("LoginDao addLogin is wrong");
		}
		return judge;
	}

	/**
	 * 根据用户名删除登录用户
	 * 
	 * @param loginName
	 * @return
	 */
	public int deleteLogin(int loginName) {
		int result = 0;
		try {
			// 获取连接
			getCon();
			// 要执行的删除sql
			String sql = "DELETE login,member from member LEFT JOIN login ON login.login_name=member.login_name WHERE login.login_name=?";
			// 执行sql，传入参数，并获取执行结果
			result = exeUpdate(sql, loginName);
		} catch (SQLException se) {
			System.out.println("LoginDao 删除异常");
		}
		return result;
	}

	/**
	 * 根据登录名修改密码
	 * 
	 * @param loginName
	 * @param passwrod
	 * @return
	 */
	public int updatePassword(int loginName, String passwrod) {
		int result = 0;
		try {
			// 获取连接
			getCon();
			// 要执行的修改SQL
			String sql = "update login set login_pass=?  where login_name=?";
			// 执行SQL并传入参数
			result = exeUpdate(sql, new Object[] { passwrod, loginName });
		} catch (SQLException e) {
			System.out.println("LoginDao 更新密码异常");
		}
		return result;
	}

	/**
	 * 登录校验
	 * 
	 * @param mname
	 * @param mpass
	 * @return
	 */
	public Login login(String mname, String mpass) {
		// 根据用户名获取用户
		Login login = getLoginByName(mname);
		// 该用户存在，并且登录密码不为空，并且与输入密码相同登陆成功，否则，登录失败
		if (login != null && login.getLoginPass() != null && login.getLoginPass().equals(mpass)) {
			return login;
		} else {
			System.out.println("loginDao 登录失败");
			return null;
		}
	}

}

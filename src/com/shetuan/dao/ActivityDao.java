package com.shetuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shetuan.bean.Activity;
import com.shetuan.util.Page;

/**
 * 社团活动的增删改查
 * 
 * @author Administrator
 */
public class ActivityDao extends BaseDao {
	/**
	 * 获取活动列表
	 * 
	 * @param page
	 *            分页信息
	 * @return 社团活动集合
	 */
	public List<Activity> getActivitiesForPage(Page page) {
		List<Activity> activities = new ArrayList<Activity>();

		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(1) FROM activity_detil as ad,community as c,activitylist_community as alc WHERE alc.activity_id=ad.activity_id and alc.community_id=c.community_id";
			// 执行sql
			exeQuery(countsql);
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果查询结果存在，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 分页查询活动的详细信息
			String sql = "SELECT alc.activity_name,activity_date,c.community_name,activity_place,activity_info FROM activity_detil as ad,community as c,activitylist_community as alc WHERE alc.activity_id=ad.activity_id and alc.community_id=c.community_id limit ?,?";
			// 执行sql ，传入分页的起始页，每页大小
			exeQuery(sql, page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果存在结果将其封装为一个新的activity对象，添加到list集合
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setActivityName(rs.getString(1));
				activity.setActivityDate(rs.getString(2));
				activity.setCommunityName(rs.getString(3));
				activity.setActivityPlace(rs.getString(4));
				activity.setActivityInfo(rs.getString(5));
				// 将新的activity对象添加到activities集合中
				activities.add(activity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接，管道
			closeAll();
		}
		return activities;
	}
}

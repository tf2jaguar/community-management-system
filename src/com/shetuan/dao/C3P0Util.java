package com.shetuan.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 连接池的相关配置
 * 
 * @author Administrator
 */
public class C3P0Util {
	private static C3P0Util c3p0Util = null;

	private static String dbdriver;
	private static String dburl;
	private static String dbusername;
	private static String dbpass;

	private ComboPooledDataSource comboPooledDataSource;

	private C3P0Util() {
		comboPooledDataSource = new ComboPooledDataSource();

		Properties properties = new Properties();
		try {
			// 读取属性文件，获取连接信息
			properties.load(BaseDao.class.getClassLoader().getResourceAsStream("db.properties"));
			dbdriver = properties.getProperty("dbdriver");
			dburl = properties.getProperty("dburl");
			dbusername = properties.getProperty("dbusername");
			dbpass = properties.getProperty("dbpass");

			comboPooledDataSource.setDriverClass(dbdriver);
			comboPooledDataSource.setJdbcUrl(dburl);
			comboPooledDataSource.setUser(dbusername);
			comboPooledDataSource.setPassword(dbpass);
			// 设置连接池的初始大小，
			comboPooledDataSource.setInitialPoolSize(5);
			// 设置连接池的最大连接值
			comboPooledDataSource.setMaxPoolSize(50);
			// 设置连接池的最小连接值
			comboPooledDataSource.setMinPoolSize(3);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static C3P0Util getInstance() {
		if (c3p0Util == null) {
			c3p0Util = new C3P0Util();
		}
		return c3p0Util;
	}

	// 获取连接
	public Connection getConnection() throws SQLException {
		return comboPooledDataSource.getConnection();
	}
}

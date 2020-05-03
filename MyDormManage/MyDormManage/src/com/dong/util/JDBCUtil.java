package com.dong.util;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;


import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {
	public static DataSource ds = null;
	// 创建连接池
	static {
		// 1.加载驱动
		try {
			Properties p = new Properties();
			String path = JDBCUtil.class.getClassLoader().getResource("db.properties").getPath();
			FileInputStream in = new FileInputStream(path);
//			FileInputStream in = new FileInputStream("resource/db.properties");
			p.load(in);
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static DataSource getDataSource() {
		return ds;
	}

}

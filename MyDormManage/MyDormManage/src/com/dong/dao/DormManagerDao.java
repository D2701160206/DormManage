package com.dong.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dong.domain.DormManager;
import com.dong.util.JDBCUtil;

public class DormManagerDao {

	public static List<DormManager> dormManagerList(DormManager dormManager) throws Exception {
		String sql = "select * from t_dormmanager";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.query(sql, new BeanListHandler<DormManager>(DormManager.class));
	}

	public static DormManager dormManagerShow(String dormManagerId) throws SQLException {
		String sql = "select * from t_dormManager t1 where t1.dormManagerId=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.query(sql, new BeanHandler<DormManager>(DormManager.class),dormManagerId);
		
		
	}

	public static int dormManagerUpdate(DormManager dormManager) throws Exception {
		String sql = "update t_dormManager set userName=?,password=?,name=?,sex=?,tel=? where dormManagerId=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.update(sql,dormManager.getUserName(),dormManager.getPassword(),dormManager.getName(), dormManager.getSex(), dormManager.getTel(), dormManager.getDormManagerId());

	}

	public static boolean haveManagerByUser(String userName) throws Exception {
		String sql = "select * from t_dormmanager t1 where t1.userName=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		DormManager re = qr.query(sql, new BeanHandler<DormManager>(DormManager.class),userName);
		if(re != null) {
			return true;
		}
		return false;
	}

	public static int dormManagerAdd(DormManager dormManager) throws Exception {
		String sql = "insert into t_dormManager values(null,?,?,null,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.update(sql,dormManager.getUserName(),dormManager.getPassword(),dormManager.getName(),dormManager.getSex(),dormManager.getTel());

	}

	public static int dormManagerDelete(String dormManagerId) throws Exception {
		String sql = "delete from t_dormManager where dormManagerId=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.update(sql,dormManagerId);
	}

	
	

}

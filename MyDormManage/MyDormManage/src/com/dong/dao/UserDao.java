package com.dong.dao;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dong.domain.Admin;
import com.dong.domain.DormManager;
import com.dong.domain.Student;
import com.dong.util.JDBCUtil;


public class UserDao {
	public static DormManager Login(DormManager dormManager)throws Exception {
		String sql = "select * from t_dormmanager where userName=? and password=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		
		return qr.query(sql, new BeanHandler<DormManager>(DormManager.class),dormManager.getUserName(),dormManager.getPassword());
	}
	
	public static Student Login( Student student)throws Exception {
		String sql = "select * from t_student where stuNumber=? and password=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		 
		return qr.query(sql, new BeanHandler<Student>(Student.class),student.getStuNumber(),student.getPassword());
	}
	
	
	
	public static int managerUpdate(int managerId, String password)throws Exception {
		String sql = "update t_dormmanager set password=? where dormManId=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.update(sql,password,managerId);
	}
	
	public static int studentUpdate(int studentId, String password)throws Exception {
		String sql = "update t_student set password=? where studentId=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.update(sql,password,studentId);
	}

	public static int adminUpdate(Integer adminId, String newPassword) throws Exception {
		String sql = "update t_admin set password=? where adminId=?";		
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.update(sql,newPassword,adminId);
	}

	public static Admin Login(Admin admin) throws Exception {
		String sql = "select * from t_Admin where userName=? and password=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		
		return qr.query(sql, new BeanHandler<Admin>(Admin.class),admin.getUserName(),admin.getPassword());
	}
	
}

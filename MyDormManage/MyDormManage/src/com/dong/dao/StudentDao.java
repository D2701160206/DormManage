package com.dong.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dong.domain.DormBuild;
import com.dong.domain.Student;
import com.dong.util.JDBCUtil;
import com.dong.util.StringUtil;

public class StudentDao {
	public static List<Student> studentList(Student s_student) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_student t1");
		if (StringUtil.isNotEmpty(s_student.getUserName())) {
			sb.append(" and t1.username like '%" + s_student.getUserName() + "%'");
		} else if (StringUtil.isNotEmpty(s_student.getStuNumber())) {
			sb.append(" and t1.stuNumber like '%" + s_student.getStuNumber() + "%'");
		} else if (StringUtil.isNotEmpty(s_student.getDormName())) {
			sb.append(" and t1.dormName like '%" + s_student.getDormName() + "%'");
		}
		if (s_student.getDormBuildId() != 0) {
			sb.append(" and t1.dormBuildId=" + s_student.getDormBuildId());
		}
		String sql = sb.toString().replaceFirst("and", "where");
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

		return qr.query(sql, new BeanListHandler<Student>(Student.class));
	}
	public static List<DormBuild> dormBuildList()throws Exception {
		String sql = "select * from t_dormBuild";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.query(sql, new BeanListHandler<DormBuild>(DormBuild.class));
		
	}

	public static Student studentShow(String studentId) throws Exception {
		String sql = "select * from t_student t1 where t1.studentId=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.query(sql, new BeanHandler<Student>(Student.class), studentId);

	}

	public static int studentUpdate(Student student) throws Exception {
		String sql = "update t_student set stuNumber=?,password=?,userName=?,dormBuildName=?,dormName=?,sex=?,tel=? where studentId=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.update(sql, student.getStuNumber(), student.getPassword(), student.getUserName(),
				student.getDormBuildName(), student.getDormName(), student.getSex(), student.getTel(),
				student.getStudentId());

	}

	public static boolean haveNameByNumber(String stuNumber) throws Exception {
		String sql = "select * from t_student t1 where t1.stuNumber=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		Student re = qr.query(sql, new BeanHandler<Student>(Student.class), stuNumber);
		if (re != null) {
			return true;
		}
		return false;
	}

	public static int studentAdd(Student student) throws Exception {
		String sql = "insert into t_student values(null,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.update(sql, student.getStuNumber(), student.getPassword(), student.getUserName(),
				student.getDormBuildId(), student.getDormName(), student.getSex(), student.getTel());

	}

	public static int studentDelete(String studentId) throws Exception {
		String sql = "delete from t_student where studentId=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.update(sql,studentId);
		
	}
	public static Student getStudent(String stuNumber) throws Exception {
		String sql = "select * from t_student t1 where t1.stuNumber=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.query(sql, new BeanHandler<Student>(Student.class),stuNumber);
	}

}

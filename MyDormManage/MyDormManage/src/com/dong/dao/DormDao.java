package com.dong.dao;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.dong.domain.Dorm;
import com.dong.util.JDBCUtil;


public class DormDao {
	
	/***
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
	 * @throws Exception 
 **/
	
	public static List<Dorm> dormList(Dorm dorm) throws Exception {{

			String sql = "select * from t_dorm";
			
			QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
	
			return qr.query(sql, new BeanListHandler<Dorm>(Dorm.class));
		}
	}

	
	/**
	public static int dormUpdate(int studentId, String password)throws Exception {
		String sql = "update t_student set password=? where studentId=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.update(sql,password,studentId);
	}
	
	public static Student getDorm(String stuNumber) throws Exception {
		String sql = "select * from t_student t1 where t1.stuNumber=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		return qr.query(sql, new BeanHandler<Student>(Student.class),stuNumber);
	}
	*/
	
}

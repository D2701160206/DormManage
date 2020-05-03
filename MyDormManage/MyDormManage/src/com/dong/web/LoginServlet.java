package com.dong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dong.dao.UserDao;
import com.dong.domain.Admin;
import com.dong.domain.DormManager;
import com.dong.domain.Student;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");

		Admin currentAdmin = null;
		DormManager currentDormManager = null;
		Student currentStudent = null;
		
		if("admin".equals(userType)) {
			Admin admin = new Admin(userName,password);
			
				try {
					currentAdmin = UserDao.Login(admin);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
//			System.out.println(currentAdmin);
			if(currentAdmin == null) {
				request.setAttribute("admin", admin);
				request.setAttribute("error", "用户名或密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				
				session.setAttribute("currentUserType", "admin");
				session.setAttribute("currentUser", currentAdmin);
				request.setAttribute("mainPage", "admin/blank.jsp");
				request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
			}
		}else if ("student".equals(userType)) {
			Student student = new Student(userName, password);
				try {
					currentStudent = UserDao.Login(student);
				} catch (Exception e) {
					e.printStackTrace();
				}
//				System.out.println(currentStudent);
			if (currentStudent == null) {
				request.setAttribute("student", student);
				request.setAttribute("error", "用户名或密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				session.setAttribute("currentUserType", "student");
				session.setAttribute("currentUser", currentStudent);
				session.setAttribute("stuNumber", userName);
//				System.out.println(userName);
				request.setAttribute("mainPage", "student/blank.jsp");
				request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
			}
		} else if ("dormManager".equals(userType)) {
			DormManager dormManager = new DormManager(userName, password);
			try {
				currentDormManager = UserDao.Login(dormManager);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println(currentDormManager);
			if (currentDormManager == null) {
				request.setAttribute("dormManager", dormManager);
				request.setAttribute("error", "用户名或密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				session.setAttribute("currentUserType", "dormManager");
				session.setAttribute("currentUser", currentDormManager);
				request.setAttribute("mainPage", "dormManager/blank.jsp");
				request.getRequestDispatcher("mainManager.jsp").forward(request, response);
			}
		}
	}
}

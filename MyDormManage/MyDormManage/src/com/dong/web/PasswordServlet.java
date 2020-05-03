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


@WebServlet("/PasswordServlet")
public class PasswordServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		if("preChange".equals(action)) {
			passwordPreChange(request, response);
			return;
		} else if("change".equals(action)) {
			passwordChange(request, response);
			return;
		}
	}
	
	private void passwordChange(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object currentUserType = session.getAttribute("currentUserType");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		if("admin".equals((String)currentUserType)) {
			Admin admin = (Admin)(session.getAttribute("currentUser"));
			if(oldPassword.equals(admin.getPassword())) {
				try {
					UserDao.adminUpdate(admin.getAdminId(),newPassword);
				} catch (Exception e) {
					e.printStackTrace();
				}
				admin.setPassword(newPassword);
				request.setAttribute("oldPassword", oldPassword);
				request.setAttribute("newPassword", newPassword);
				request.setAttribute("rPassword", newPassword);
				request.setAttribute("error", "修改成功 ");
				request.setAttribute("mainPage", "admin/blank.jsp");
				request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
			} else {
				request.setAttribute("oldPassword", oldPassword);
				request.setAttribute("newPassword", newPassword);
				request.setAttribute("rPassword", newPassword);
				request.setAttribute("error", "原密码错误");
				request.setAttribute("mainPage", "admin/passwordChange.jsp");
				request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
			}
		} else if("dormManager".equals((String)currentUserType)) {
				DormManager manager = (DormManager)(session.getAttribute("currentUser"));
				if(oldPassword.equals(manager.getPassword())) {
					try {
						UserDao.managerUpdate(manager.getDormManagerId(), newPassword);
					} catch (Exception e) {
						e.printStackTrace();
					}
					manager.setPassword(newPassword);
					request.setAttribute("oldPassword", oldPassword);
					request.setAttribute("newPassword", newPassword);
					request.setAttribute("rPassword", newPassword);
					request.setAttribute("error", "修改成功 ");
					request.setAttribute("mainPage", "dormManager/blank.jsp");
					request.getRequestDispatcher("mainManager.jsp").forward(request, response);
				} else {
					request.setAttribute("oldPassword", oldPassword);
					request.setAttribute("newPassword", newPassword);
					request.setAttribute("rPassword", newPassword);
					request.setAttribute("error", "原密码错误");
					request.setAttribute("mainPage", "dormManager/passwordChange.jsp");
					request.getRequestDispatcher("mainManager.jsp").forward(request, response);
				}
			} else if("student".equals((String)currentUserType)) {
				Student student = (Student)(session.getAttribute("currentUser"));
				if(oldPassword.equals(student.getPassword())) {
					try {
						UserDao.studentUpdate(student.getStudentId(), newPassword);
					} catch (Exception e) {
						e.printStackTrace();
					}
					student.setPassword(newPassword);
					request.setAttribute("oldPassword", oldPassword);
					request.setAttribute("newPassword", newPassword);
					request.setAttribute("rPassword", newPassword);
					request.setAttribute("error", "修改成功 ");
					request.setAttribute("mainPage", "student/blank.jsp");
					request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
				} else {
					request.setAttribute("oldPassword", oldPassword);
					request.setAttribute("newPassword", newPassword);
					request.setAttribute("rPassword", newPassword);
					request.setAttribute("error", "原密码错误");
					request.setAttribute("mainPage", "student/passwordChange.jsp");
					request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
				}
			}
		
	}

	private void passwordPreChange(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object currentUserType = session.getAttribute("currentUserType");
		if("admin".equals((String)currentUserType)) {
			request.setAttribute("mainPage", "admin/passwordChange.jsp");
			request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
		} else if("dormManager".equals((String)currentUserType)) {
			request.setAttribute("mainPage", "dormManager/passwordChange.jsp");
			request.getRequestDispatcher("mainManager.jsp").forward(request, response);
		} else if("student".equals((String)currentUserType)) {
			request.setAttribute("mainPage", "student/passwordChange.jsp");
			request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
		}
	}
	
}

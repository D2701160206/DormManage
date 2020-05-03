package com.dong.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dong.dao.StudentDao;
import com.dong.domain.Student;
import com.dong.util.StringUtil;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Object currentUserType = session.getAttribute("currentUserType");
		String s_studentText = (String)request.getParameter("s_studentText");
		String dormBuildId = request.getParameter("buildToSelect");
		String searchType = request.getParameter("searchType");
		String action = request.getParameter("action");
		Student student = new Student();
//		System.out.println(s_studentText);
		if ("preSave".equals(action)) {
			try {
				studentPreSave(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		} else if ("save".equals(action)) {
			try {
				studentSave(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		} 
		else if ("delete".equals(action)) {
			try {
				studentDelete(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		} else if ("list".equals(action)) {
			if (StringUtil.isNotEmpty(s_studentText)) {
				if ("name".equals(searchType)) {
					student.setUserName(s_studentText);
				} else if ("number".equals(searchType)) {
					student.setStuNumber(s_studentText);
				} else if ("dorm".equals(searchType)) {
					student.setDormName(s_studentText);
				}
			}
			if (StringUtil.isNotEmpty(dormBuildId)) {
				student.setDormBuildId(Integer.parseInt(dormBuildId));
			}
			session.removeAttribute("s_studentText");
			session.removeAttribute("searchType");
			session.removeAttribute("buildToSelect");
			request.setAttribute("s_studentText", s_studentText);
			request.setAttribute("searchType", searchType);
			request.setAttribute("buildToSelect", dormBuildId);
		} else if ("search".equals(action)) {
			if (StringUtil.isNotEmpty(s_studentText)) {
				if ("name".equals(searchType)) {
					student.setUserName(s_studentText);
				} else if ("number".equals(searchType)) {
					student.setStuNumber(s_studentText);
				} else if ("dorm".equals(searchType)) {
					student.setDormName(s_studentText);
				}
				session.setAttribute("s_studentText", s_studentText);
				session.setAttribute("searchType", searchType);
			} else {
				session.removeAttribute("s_studentText");
				session.removeAttribute("searchType");
			}
			if (StringUtil.isNotEmpty(dormBuildId)) {
				student.setDormBuildId(Integer.parseInt(dormBuildId));
				session.setAttribute("buildToSelect", dormBuildId);
			} else {
				session.removeAttribute("buildToSelect");
			}
		} else if("infor".equals(action)) {
			String stuNumber = (String) session.getAttribute("stuNumber");
//			System.out.println(stuNumber);
			try {
				student = StudentDao.getStudent(stuNumber);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println(student);
			request.setAttribute("student", student);
			request.setAttribute("mainPage", "student/information.jsp");
			request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
		} else {
			if ("dormManager".equals((String) currentUserType)) {
				if (StringUtil.isNotEmpty(s_studentText)) {
					if ("name".equals(searchType)) {
						student.setUserName(s_studentText);
					} else if ("number".equals(searchType)) {
						student.setStuNumber(s_studentText);
					} else if ("dorm".equals(searchType)) {
						student.setDormName(s_studentText);
					}
					session.setAttribute("s_studentText", s_studentText);
					session.setAttribute("searchType", searchType);
				}
				if (StringUtil.isEmpty(s_studentText)) {
					Object o1 = session.getAttribute("s_studentText");
					Object o2 = session.getAttribute("searchType");
					if (o1 != null) {
						if ("name".equals((String) o2)) {
							student.setUserName((String) o1);
						} else if ("number".equals((String) o2)) {
							student.setStuNumber((String) o1);
						} else if ("dorm".equals((String) o2)) {
							student.setDormName((String) o1);
						}
					}
				}
			}
		}

		if ("dormManager".equals((String) currentUserType)) {
			List<Student> studentList = null;
			try {
				studentList = StudentDao.studentList(student);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println(studentList);
			request.setAttribute("studentList", studentList);
			request.setAttribute("mainPage", "dormManager/student.jsp");
			request.getRequestDispatcher("mainManager.jsp").forward(request, response);
		}
	}

	private void studentDelete(HttpServletRequest request, HttpServletResponse response) throws Exception, Exception {
		String studentId = request.getParameter("studentId");
			StudentDao.studentDelete(studentId);
			request.getRequestDispatcher("StudentServlet?action=list").forward(request, response);
		

	}

	private void studentSave(HttpServletRequest request, HttpServletResponse response) throws Exception, Exception {
		String studentId = request.getParameter("studentId");
		String stuNumber = request.getParameter("stuNumber");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String dormBuildName = request.getParameter("dormBuildName");
		String dormName = request.getParameter("dormName");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		Student student = new Student(stuNumber,password, dormBuildName, dormName, userName, sex, tel);
		if(StringUtil.isNotEmpty(studentId)) {
			student.setStudentId(Integer.parseInt(studentId));
		}
		request.setAttribute("dormBuildList", StudentDao.dormBuildList());
			int saveNum = 0;
			if(StringUtil.isNotEmpty(studentId)) {
				saveNum = StudentDao.studentUpdate(student);
			} else if(StudentDao.haveNameByNumber(student.getStuNumber())){
				request.setAttribute("student", student);
				request.setAttribute("error", "该学号已存在");
				request.setAttribute("mainPage", "dormManager/studentSave.jsp");
				request.getRequestDispatcher("mainManager.jsp").forward(request, response);
	
				return;
			} else {
				saveNum = StudentDao.studentAdd(student);
			}
			
			if(saveNum > 0) {
				request.getRequestDispatcher("StudentServlet?action=list").forward(request, response);
			} else {
				request.setAttribute("student", student);
				request.setAttribute("error", "保存失败");
				request.setAttribute("mainPage", "dormManager/studentSave.jsp");
				request.getRequestDispatcher("mainManager.jsp").forward(request, response);
			}
	
	}

	private void studentPreSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentId = request.getParameter("studentId");
		request.setAttribute("dormBuildList", StudentDao.dormBuildList());
			if (StringUtil.isNotEmpty(studentId)) {
				Student student = StudentDao.studentShow(studentId);
				request.setAttribute("student", student);
			}
		request.setAttribute("mainPage", "dormManager/studentSave.jsp");
		request.getRequestDispatcher("mainManager.jsp").forward(request, response);

	}

}

package com.dong.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dong.dao.DormManagerDao;
import com.dong.domain.DormManager;
import com.dong.util.StringUtil;

@WebServlet("/DormManagerServlet")
public class DormManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		DormManager dormManager = new DormManager();
		if ("preSave".equals(action)) {
			dormManagerPreSave(request, response);
			return;
		} else if ("save".equals(action)) {
			try {
				dormManagerSave(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		} else if ("delete".equals(action)) {
			try {
				dormManagerDelete(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		} 
		List<DormManager> dormManagerList = null;
		try {
			dormManagerList = DormManagerDao.dormManagerList(dormManager);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(dormManagerList);
		request.setAttribute("dormManagerList", dormManagerList);
		request.setAttribute("mainPage", "admin/dormManager.jsp");
		request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);

	}

	private void dormManagerDelete(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		String dormManagerId = request.getParameter("dormManagerId");
//		System.out.println(dormManagerId);
			DormManagerDao.dormManagerDelete(dormManagerId);
			request.getRequestDispatcher("DormManagerServlet?action=list").forward(request, response);

	}

	private void dormManagerSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dormManagerId = request.getParameter("dormManagerId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		DormManager dormManager = new DormManager(userName, password, name, sex, tel);
		if (StringUtil.isNotEmpty(dormManagerId)) {
			dormManager.setDormManagerId(Integer.parseInt(dormManagerId));
		}
		int saveNum = 0;
		if (StringUtil.isNotEmpty(dormManagerId)) {
			saveNum = DormManagerDao.dormManagerUpdate(dormManager);
		} else if (DormManagerDao.haveManagerByUser(dormManager.getUserName())) {
			request.setAttribute("dormManager", dormManager);
			request.setAttribute("error", "该用户名已存在");
			request.setAttribute("mainPage", "admin/dormManagerSave.jsp");
			request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
			return;
		} else {
			saveNum = DormManagerDao.dormManagerAdd(dormManager);
		}
		if (saveNum > 0) {
			request.getRequestDispatcher("DormManagerServlet?action=list").forward(request, response);
		} else {
			request.setAttribute("dormManager", dormManager);
			request.setAttribute("error", "保存失败");
			request.setAttribute("mainPage", "admin/dormManagerSave.jsp");
			request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
		}

	}

	private void dormManagerPreSave(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String dormManagerId = request.getParameter("dormManagerId");
		if (StringUtil.isNotEmpty(dormManagerId)) {
			DormManager dormManager = null;
			try {
				dormManager = DormManagerDao.dormManagerShow(dormManagerId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("dormManager", dormManager);

		}
		request.setAttribute("mainPage", "admin/dormManagerSave.jsp");
		request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);

	}

}

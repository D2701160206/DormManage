package com.dong.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dong.dao.DormDao;
import com.dong.domain.Dorm;





@WebServlet("/DormServlet")
public class DormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		Object currentUserType = session.getAttribute("currentUserType");
		Dorm dorm = new Dorm();
		if ("dormManager".equals((String) currentUserType)) {
			List<Dorm> dormList = null;
			try {
				dormList = DormDao.dormList(dorm);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println(dormList);
			request.setAttribute("dormList", dormList);
			request.setAttribute("mainPage", "dormManager/dorm.jsp");
			request.getRequestDispatcher("mainManager.jsp").forward(request, response);
		}
	}

}

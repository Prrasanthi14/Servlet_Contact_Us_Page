package com.contactusservletproject;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User adminuser=new User();
		adminuser.setAdminname(name);
		adminuser.setPassword(password);
		UserDao userDao=new UserDao();
		boolean flag=true;
		try {
			flag = userDao.setUserDao(adminuser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag) {
			response.sendRedirect("dashboard");
			HttpSession session = request.getSession();
			session.setAttribute("admin", name);
			session.setAttribute("pass", password);
		}	
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}		
	}
}

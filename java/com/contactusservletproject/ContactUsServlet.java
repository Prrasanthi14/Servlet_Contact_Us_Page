package com.contactusservletproject;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		Request requestobj=new Request(name,email,message);
		RequestDao requestdao=new RequestDao();
		try {
			requestdao.requestDao(requestobj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("contactus.jsp");
		dispatcher.forward(request, response);
	}
}
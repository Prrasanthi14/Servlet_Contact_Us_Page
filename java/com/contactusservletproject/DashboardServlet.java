package com.contactusservletproject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDao requestdao = new RequestDao();
        List<Request> requestlist;
        try {
            requestlist = requestdao.fetchRequests();
            HttpSession session = request.getSession();
            session.setAttribute("list", requestlist);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String status = request.getParameter("status");
        Request requestdata = new Request();
        requestdata.setStatus(status);
        requestdata.setId(id);
        RequestDao requestDao = new RequestDao();
        try {
            requestDao.changeStatus(requestdata);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("dashboard");
    }
}

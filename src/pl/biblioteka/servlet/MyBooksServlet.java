package pl.biblioteka.servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.biblioteka.beans.Book;
import pl.biblioteka.beans.Student;
import pl.biblioteka.conn.ConnectionUtils;
import pl.biblioteka.utils.DBUtils;
import pl.biblioteka.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/MyBooks" })
public class MyBooksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public MyBooksServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	Student loggedInStudent = MyUtils.getLoggedInStudent(session);
    	 if (loggedInStudent == null) {
             // Redirect to login page.
             response.sendRedirect(request.getContextPath() + "/login");
             return;
         }
    	 
    	 Connection conn = MyUtils.getStoredConnection(request);	 
         String errorString = null;
         List<Book> list = null;
       
         try {
             list = DBUtils.queryMyBooks(conn, loggedInStudent.getStudentId());
         } catch (SQLException e) {
             e.printStackTrace();
             errorString = e.getMessage();
         }
    	 
         request.setAttribute("errorString", errorString);
         request.setAttribute("booksList", list);
         
         RequestDispatcher dispatcher = request.getServletContext()
                 .getRequestDispatcher("/WEB-INF/views/myBooksListView.jsp");
         dispatcher.forward(request, response);
    }
    	
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}
package pl.biblioteka.servlet;

import java.lang.System;
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
 
@WebServlet(urlPatterns = { "/BookList" })
public class BooksListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public BooksListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String errorString = null;
        List<Book> list = null;

        try {
            list = DBUtils.queryAllBooks(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        // Store info in request attribute, before forward to views       
        request.setAttribute("errorString", errorString);
        request.setAttribute("booksList", list);
         
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/booksListView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	Connection conn = MyUtils.getStoredConnection(request);
    	boolean hasError = false;
    	String errorString = null;
    	// Check User has logged in
        Student loggedInStudent = MyUtils.getLoggedInStudent(session);
 
        // Not logged in
        if (loggedInStudent == null) {
            // Redirect to login page.
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
    	 int bookId = Integer.valueOf(request.getParameter("id"));
    	 int userId = loggedInStudent.getStudentId();
    	 try {
    		 DBUtils.makeReservation(conn, bookId, userId);
    	 } catch (SQLException e) {
             e.printStackTrace();
             errorString = e.getMessage();
             hasError = true;
    	 }
    	 
    	 if(hasError) {
    		 request.setAttribute("errorString", errorString);
    		 doGet(request, response);
    	 }else {
    		 response.sendRedirect(request.getContextPath() + "/MyBooks");
    	 }  	 
    }
 
}

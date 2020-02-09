package pl.biblioteka.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import pl.biblioteka.beans.*;

public class DBUtils {
 
    public static Student findUser(Connection conn, //
            String name, String surname, String index_number) throws SQLException {
 
        String sql = "select * from students where name = ? and surname = ? and index_number = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.setString(2, surname);
        pstm.setString(3, index_number);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
        	int id_student = rs.getInt("id_student");
            Student student = new Student();
            student.setStudentId(id_student);
            student.setName(name);
            student.setSurname(surname);
            student.setIndexNumber(index_number);
            return student;
        }
        return null;
    }
 
    public static List<Book> queryMyBooks(Connection conn, //
    		int id_student) throws SQLException {
        String sql = "select books.title, books.author, books.year, books.id_book, rentals.deadline from books, rentals where rentals.id_student = ? and rentals.id_book = books.id_book order by rentals.deadline";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_student);
        ResultSet rs = pstm.executeQuery();
        
        List<Book> list = new ArrayList<Book>();
        while (rs.next()) {
            String title = rs.getString("title");
            String author = rs.getString("author");
            String deadline = rs.getString("deadline");
            int year = rs.getInt("year");
            int id_book = rs.getInt("id_book");
            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            book.setDeadline(deadline);
            book.setYear(year);
            book.setBookId(id_book);
            list.add(book);
            
        }
        return list;
    }
    
    public static List<Book> queryAllBooks(Connection conn) throws SQLException {

        String sql = "select * from books order by title";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        
        List<Book> list = new ArrayList<Book>();
        while (rs.next()) {
            String title = rs.getString("title");
            String author = rs.getString("author");
            int year = rs.getInt("year");
            int id_book = rs.getInt("id_book");
            boolean status = rs.getBoolean("status");
            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            book.setYear(year);
            book.setBookId(id_book);
            book.setStatus(status);
            list.add(book);
        }
        return list;
    }
    
    public static void makeReservation(Connection conn, int bookId, int userId) throws SQLException {
    	String sql = "CALL reservation(?,?)";
    	 PreparedStatement pstm = conn.prepareStatement(sql);
    	 pstm.setInt(1, bookId);
    	 pstm.setInt(2, userId);
         pstm.executeQuery();
    	
    }
 
 
}

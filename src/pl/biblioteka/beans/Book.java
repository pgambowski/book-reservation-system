package pl.biblioteka.beans;

public class Book {

	private String title;
	private String author;
	private int year;
	private int id_book;
	private boolean status;
	private String deadline;
	
	public Book() {
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getBookId() {
		return id_book;
	}
	
	public void setBookId(int id_book) {
		this.id_book = id_book;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getDeadline() {
		return deadline;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
}

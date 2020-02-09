package pl.biblioteka.beans;

public class Rental {
	private int id_rental;
	private int id_student;
	private int id_book;
	private String deadline;

	public Rental(int id_student, int id_book, int id_rental) {
		this.id_rental = id_rental;
		this.id_student = id_student;
		this.id_book = id_book;
		this.deadline = deadline;
	}
	
	public int getRentalID() {
		return id_rental;
	}
	
	public void setRentalID(int id_rental) {
		this.id_student = id_rental;
	}
	
	public int getStudentID() {
		return id_student;
	}
	
	public void setStudentID(int id_student) {
		this.id_student = id_student;
	}
	
	public int getBookID() {
		return id_book;
	}
	
	public void setBookID(int id_book) {
		this.id_book = id_book;
	}
	
	public String getDedline() {
		return deadline;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
}

package pl.biblioteka.beans;

public class Student {
	
	private int id_student;
	private String name;
	private String surname;
	private String index_number;
	
	public Student() {
		
	}
	
	public int getStudentId() {
		return id_student;
	}
	
	public void setStudentId(int id_student) {
		this.id_student = id_student;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getFullName() {
		return name + " " + surname;
	}
	
	public String getIndexNumber() {
		return index_number;
	}
	
	public void setIndexNumber(String index_number) {
		this.index_number = index_number;
	}
}

package logic;

import java.util.Date;

public class Student {
	private String id;
	private String name;
	private String lastName;
	private Integer grade;
	public Student(String name, String lastName, Integer grade) {
		this.id = this.generateId();
		this.name = name;
		this.lastName = lastName;
		this.grade = grade;
	}
	private String generateId() {
		Date currentDate = new Date();
		return currentDate.getTime() + "_" + Math.random() * 100;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
}

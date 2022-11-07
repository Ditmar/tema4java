package ui;

import java.awt.Dimension;

import javax.swing.JPanel;

import custom.HandlerOnSubmit;
import logic.Student;

public class Form extends JPanel {
	private CustomTextField name, lastName, grade;
	private CustomButton button;
	private HandlerOnSubmit listener;
	
	public Form() {
		super();
		this.setLayout(null);
		this.setSize(new Dimension(500, 700));
		this.setLocation(0, 0);
		createComponents();
		registerEvents();
	}
	//Evento
	public void onSubmitForm(HandlerOnSubmit listener) 
	{
		this.listener = listener;
	}
	
	private void registerEvents() {
		button.addActionListener((event) -> {
			Student student = new Student(
					this.name.getText(), 
					this.lastName.getText(), 
					Integer.parseInt(this.grade.getText()));
			resetForm();
			//dispatch
			this.listener.onSubmit(student);
		});
	}
	private void resetForm() {
		this.name.setText("");
		this.lastName.setText("");
		this.grade.setText("");
	}
	private void createComponents() {
		name = new CustomTextField("Name");
		lastName = new CustomTextField("lastName");
		grade = new CustomTextField("Grade");
		button = new CustomButton("Crear");
		
		name.setCenter(this, 50);
		lastName.setCenter(this, 100);
		grade.setCenter(this, 200);
		button.setCenter(this, 300);
		
		this.add(name);
		this.add(grade);
		this.add(lastName);
		this.add(button);
		
	 }
	
	public Student submitStudent() {
		String name = this.name.getText();
		String lastName = this.lastName.getText();
		String grade = this.grade.getText();
		return new Student(name, lastName, Integer.parseInt(grade));
	} 
	
}
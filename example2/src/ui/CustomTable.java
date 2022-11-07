package ui;

import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logic.Student;

public class CustomTable extends JTable {
	private DefaultTableModel model;
	private String[] labels;
	public CustomTable(String[] labels) {
		super();
		this.labels = labels;
		this.model = (DefaultTableModel)super.getModel();
		for (String label : this.labels) {
			this.model.addColumn(label);
		}
		this.setLocation(0, 0);
		this.setSize(new Dimension(700, 700)); 
	}
	public DefaultTableModel getModel() {
		return this.model;
	}
	private Object[] transFormClass(Student student) {
		Object[] result = new Object[this.labels.length];
		result[0] = student.getId();
		result[1] = student.getName();
		result[2] = student.getLastName();
		result[3] = student.getGrade();
		return result;
	}
	public void add(Student student) {
		
		this.model.addRow(this.transFormClass(student));
	}
}

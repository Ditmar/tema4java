package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainWindows extends JFrame {
	private String title;
	private CustomTable table;
	private CustomPanel leftPanel;
	private CustomPanel rightPanel;
	private Form form;
	public MainWindows (String title) {
		super(title);
		this.title = title;
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1200, 700));
		this.setLocationRelativeTo(this);
		this.setLayout(null);
		this.setVisible(true);
		createComponents();
		createTable();
		createForm();
		createEvents();
		
	}
	private void createEvents() {
		form.onSubmitForm((student) -> {
			table.add(student);
		});
	}
	public void createComponents() {
		leftPanel = new CustomPanel();
		leftPanel.setPosition(0, 0, 700, 700);
		leftPanel.setLayout(null);
		this.add(leftPanel);
		rightPanel = new CustomPanel();
		rightPanel.setPosition(700, 0, 500, 700);
		rightPanel.setBackground(Color.blue);
		rightPanel.setLayout(null);
		this.add(rightPanel);
	}
	
	public void createTable() {
		
		table = new CustomTable(new String[] {"id", "name", "lastName", "Grade"});
		leftPanel.add(table);
	}
	
	public void createForm() {
		form = new Form();
		rightPanel.add(form);
	}
}


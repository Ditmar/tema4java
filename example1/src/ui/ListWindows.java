package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class ListWindows extends JFrame{
	private String title;
	private JPanel leftPanel;
	private HandlerListClickEvent listener;
	public ListWindows (String title) {
		super(title);
		this.title = title;
		//this.setDefaultCloseOperation(this.E);
		this.setSize(new Dimension(300, 400));
		this.setLocationRelativeTo(this);
		this.setLayout(null);
		this.setVisible(true);
		createPanels();
		createList();
	}
	public void addActionHandlerSelectedEvent(HandlerListClickEvent listener) {
		this.listener = listener;
	}
	public void createPanels() { 
		leftPanel = new JPanel();
		leftPanel.setSize(new Dimension(300, 400));
		leftPanel.setLocation(0, 0);
		leftPanel.setLayout(null);
		Color color = new Color(125, 229, 237);
		leftPanel.setBackground(color);
		this.add(leftPanel);
	}
	public void createList() {
		ArrayList<String> users = new ArrayList();
		users.add("rick");
		users.add("lisa");
		users.add("maggie");
		users.add("marge");
		users.add("homer");
		users.add("bart");
		
		JList list = new JList(users.toArray());
		list.setSize(new Dimension(300, 400));
		list.addListSelectionListener((e) -> {
			
			String name = (String) list.getSelectedValue();
			if (this.listener != null) {
				this.listener.onSelectedItem(name);
			}
		});
		leftPanel.add(list);
	}
	
}

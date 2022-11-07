package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class CustomPanel extends JPanel{
	public CustomPanel() {
		super();
		Color color = new Color(125, 229, 237);
		this.setBackground(color);
	}
	
	public void setPosition(Integer x, Integer y, Integer width, Integer height) {
		this.setSize(new Dimension(width, height));
		this.setLocation(x, y);
		
	}
}

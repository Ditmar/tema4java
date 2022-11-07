package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;

import helpers.Helpers;

public class CustomButton extends JButton{
	public CustomButton(String title) {
		super(title);
		this.setSize(new Dimension(300, 50));
		this.setForeground(Color.BLUE);
		this.setBackground(Color.WHITE);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void setCenter(JComponent container, Integer y) {
		this.setLocation(Helpers.getCenterPosition(container, this), y);
	}
}

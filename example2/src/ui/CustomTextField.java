package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import helpers.Helpers;

public class CustomTextField extends JTextField {
	public CustomTextField(String title) {
		super(title);
		this.setSize(new Dimension(300, 50));
		//text.setBounds(Helpers.getCenterPosition(this.rightPanfzel, text), 300, 300, 50);
		this.setForeground(Color.DARK_GRAY);
		this.setBackground(Color.WHITE);
		this.setCaretColor(Color.BLUE);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}
	public void setCenter(JComponent container, Integer y) {
		this.setLocation(Helpers.getCenterPosition(container, this), y);
	}
}

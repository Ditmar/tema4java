package example3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindows extends JFrame {
	private HashMap<String, JPanel> panelList;
	private ArrayList<Color> colors;
	public MainWindows () {
		super();
		this.panelList = new HashMap();
		this.colors = new ArrayList();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1200, 700));
		this.setLocationRelativeTo(this);
		this.setLayout(null);
		this.setVisible(true);
		setUpColors();
		createPanels();
		createBorderLayout();
		createBoxLayout();
		createFlowLayout();
	}
	private void createFlowLayout() {
		// TODO Auto-generated method stub
		JPanel panel = this.panelList.get("panel_2");
		for (Integer i = 0; i < 20; i++) {
			JButton button = new JButton("Label" + i);
			
			Double w = (5 + 20 * Math.random());
			Integer width = w.intValue();
			
			Double h = (5 + 20 * Math.random());
			Integer height = h.intValue();
		
			button.setSize(new Dimension(width, height));
			panel.add(button);
		}
	}
	private void createBorderLayout() {
		// TODO Auto-generated method stub
		JPanel panel = this.panelList.get("panel_0");
		JButton north = new JButton("north");
		JButton south = new JButton("south");
		JButton east = new JButton("east");
		JButton west = new JButton("west");
		JButton center = new JButton("center");
		panel.setLayout(new BorderLayout(5, 5));
		panel.add(north, BorderLayout.NORTH);
		panel.add(south, BorderLayout.SOUTH);
		panel.add(east, BorderLayout.EAST);
		panel.add(west, BorderLayout.WEST);
		panel.add(center, BorderLayout.CENTER);
		
	}
	private void createBoxLayout() 
	{
		JPanel panel = this.panelList.get("panel_1");
		JButton btn1 = new JButton("north");
		JButton btn2 = new JButton("south");
		JButton btn3 = new JButton("east");
		JButton btn4 = new JButton("west");
		JButton btn5 = new JButton("center");
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
	}
	
	private void setUpColors() {
		this.colors.add(Color.RED);
		this.colors.add(Color.CYAN);
		this.colors.add(Color.BLUE);
		this.colors.add(Color.YELLOW);
		this.colors.add(Color.GRAY);
		
	}
	private void createPanels() {
		//400
		Integer j = 0;
		for (Integer i = 0; i < 5; i++) {
			JPanel panel = new JPanel();
			panel.setSize(400, 400);
			panel.setBackground(this.colors.get(i));
			if (i % 3 == 0 && i != 0) {
				j++;
			}
			panel.setLocation(new Point((i) % 3 * 400, j * 400));
			panelList.put("panel_" + i, panel);
			this.add(panel);
		}
	}
	
}

package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import helpers.Helpers;

public class Window extends JFrame implements ActionListener {
	private static final String JTextPasswordField = null;
	private String title;
	private JPanel leftPanel;
	private JPanel rightPanel; 
	private HashMap<String, String> hash;
	private JLabel labelImage;
	private Window root;
	//decorator
	private Font titleFont, mainFont, subTitleFont;
	public Window(String title) {
		super(title);
		this.root = this;
		this.title = title;
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1200, 700));
		this.setLocationRelativeTo(this);
		this.setLayout(null);
		this.setVisible(true);
		hash = new HashMap();
		hash.put("bart", "/Users/ditmarcastroangulo/tema4/example1/resources/images/bart.png");
		hash.put("homer", "/Users/ditmarcastroangulo/tema4/example1/resources/images/homer.jpeg");
		hash.put("maggie", "/Users/ditmarcastroangulo/tema4/example1/resources/images/maggie.png");
		hash.put("lisa", "/Users/ditmarcastroangulo/tema4/example1/resources/images/lisa.png");
		hash.put("marge", "/Users/ditmarcastroangulo/tema4/example1/resources/images/marge.png");
		hash.put("rick", "/Users/ditmarcastroangulo/tema4/example1/resources/images/rick.jpeg");
		registerNewFonts();
		createPanels();
		createDecorators();
		createLabels();
		createTextField();
		createComboBox();
		createButton();
		createCheckButton();
		createLabelWithImages(hash.get("rick"));
		createTable();	
		root.repaint();
	}
	public void createPanels() { 
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		leftPanel.setSize(new Dimension(600, 600));
		leftPanel.setLocation(0, 0);
		Color color = new Color(125, 229, 237);
		leftPanel.setBackground(color);
		this.add(leftPanel);
		
		rightPanel.setSize(new Dimension(400, 600));
		rightPanel.setLocation(600, 0);
		rightPanel.setBackground(Color.BLUE);
		rightPanel.setLayout(null);
		this.add(rightPanel);
	}
	public void registerNewFonts() {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(
					Font.createFont(Font.TRUETYPE_FONT, 
							new File("/Users/ditmarcastroangulo/tema4/example1/resources/fonts/FuzzyBubbles-Regular.ttf")));
		
		} catch(IOException | FontFormatException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void createDecorators() {
		mainFont = new Font("Fuzzy Bub", Font.PLAIN, 20);
		titleFont = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
		subTitleFont = new Font("Forte", Font.PLAIN, 13);

	}
	
	public void createLabels() {
		JLabel label = new JLabel("Te ayudamos en todo");
		label.setBounds(130, 20, Helpers.getCenterPosition(this.rightPanel, label), 100);
		label.setForeground(Color.WHITE);
		label.setFont(mainFont);
		this.rightPanel.add(label);
	}
	public void createTextField() {
		JTextField text  = new JTextField("Username name");
		text.setSize(new Dimension(300, 50));
		text.setLocation(Helpers.getCenterPosition(this.rightPanel, text), 300);
		//text.setBounds(Helpers.getCenterPosition(this.rightPanel, text), 300, 300, 50);
		text.setForeground(Color.DARK_GRAY);
		text.setBackground(Color.WHITE);
		text.setCaretColor(Color.BLUE);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		this.rightPanel.add(text);
		
		JPasswordField password = new JPasswordField("Password");
		password.setSize(new Dimension(300, 50));
		password.setLocation(Helpers.getCenterPosition(this.rightPanel, text), 360);
		password.setForeground(Color.DARK_GRAY);
		password.setCaretColor(Color.BLUE);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		this.rightPanel.add(password);
	}
	public void createComboBox() {
		JComboBox combo = new JComboBox<String>();
		combo.addItem("User");
		combo.addItem("Cashier");
		combo.addItem("Admin");
		combo.setSize(300, 30);
		combo.setLocation(Helpers.getCenterPosition(this.rightPanel, combo), 420);
		combo.setForeground(Color.DARK_GRAY);
		combo.setBackground(Color.WHITE);
		JLabel label = (JLabel)combo.getRenderer();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		this.rightPanel.add(combo);
	}
	public void createButton() {
		JButton button = new JButton("Login");
		button.setSize(new Dimension(300, 50));
		button.setLocation(Helpers.getCenterPosition(this.rightPanel, button), 480);
		button.setForeground(Color.BLUE);
		button.setBackground(Color.WHITE);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon icon = new ImageIcon("/Users/ditmarcastroangulo/tema4/example1/resources/images/emote.png");
		button.setIcon(icon);
//		button.addActionListener((e) -> {
//			
//		});
		button.addActionListener(this);
		this.rightPanel.add(button);
	}
	public void createCheckButton () {
		JCheckBox check = new JCheckBox("Si");
		check.setSize(new Dimension(60, 25));
		check.setFocusable(false);
		check.setBackground(Color.WHITE);
		check.setLocation(100, 450);
		rightPanel.add(check);
		
		JCheckBox check2 = new JCheckBox("No");
		check2.setSize(new Dimension(60, 25));
		check2.setFocusable(false);
		check2.setBackground(Color.WHITE);
		check2.setLocation(200, 450);
		rightPanel.add(check2);
		ButtonGroup group = new ButtonGroup();
		group.add(check);
		group.add(check2);
	}
	public void createLabelWithImages(String url) {
		labelImage = new JLabel("");
		labelImage.setSize(new Dimension(600, 600));
		//labelImage.setBounds(130, 20, Helpers.getCenterPosition(this.rightPanel, labelImage), 100);
		labelImage.setForeground(Color.WHITE);
		ImageIcon image = new ImageIcon(url);
		labelImage.setIcon(image);
		leftPanel.add(labelImage);
	}
	
	public void createTable () {
		 JTable table = new JTable();
		 table.setSize(new Dimension(300, 200));
		 table.setLocation(10, 110);
		 DefaultTableModel model = (DefaultTableModel)table.getModel();
		 model.addColumn("id");
		 model.addColumn("name");
		 model.addColumn("LastName");
		 model.addColumn("Grade");
		 model.addRow(new Object[] {"0001", "Carlos", "Lopez", "10"});
		 model.addRow(new Object[] {"0002", "Juan", "Vargas", "11"});
		 model.addRow(new Object[] {"0003", "Maria", "Duran", "16"});
		 table.updateUI();
		 rightPanel.add(table);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ListWindows win = new ListWindows("lista");
		win.addActionHandlerSelectedEvent((name) -> {
			leftPanel.remove(labelImage);
			createLabelWithImages(hash.get(name));
			root.repaint();
		
		});
	}
	
}

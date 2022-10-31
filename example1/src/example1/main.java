package example1;

import javax.swing.SwingUtilities;

import ui.Window;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable run = () -> {
			Window window = new Window("Main Window");
			window.getClass();
		};
		SwingUtilities.invokeLater(run);
			
	}

}

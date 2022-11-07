package example2;

import javax.swing.SwingUtilities;

import ui.MainWindows;


public class main {

	public static void main(String[] args) {
		Runnable run = () -> {
			MainWindows window = new MainWindows("Main Window");
			window.getClass();
		};
		SwingUtilities.invokeLater(run);
	}

}

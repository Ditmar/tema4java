package example3;

import javax.swing.SwingUtilities;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable run = () -> {
			MainWindows window = new MainWindows();
			window.getClass();
		};
		SwingUtilities.invokeLater(run);
	}

}

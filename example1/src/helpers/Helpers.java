package helpers;

import javax.swing.JComponent;

public class Helpers {
	static  public Integer getCenterPosition(JComponent container, JComponent component) {
		return (container.getWidth() - component.getWidth()) / 2;
	}
}

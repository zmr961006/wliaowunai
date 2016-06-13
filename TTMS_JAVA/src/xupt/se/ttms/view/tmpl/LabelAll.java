package xupt.se.ttms.view.tmpl;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelAll extends JLabel {
	String name = null;

	public LabelAll(String name) {
		super(name);
	}

	public LabelAll(String name, int x) {
		super(name, x);
	}

	public void setLabel(String name) {
		this.name = name;
	}

	public String getLabel() {
		return name;
	}
}

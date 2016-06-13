package xupt.se.ttms.view.tmpl;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ButtonAll extends JButton {
	String name = null;
	private int tag = 0;
	private int num = 0;

	public ButtonAll() {

	}

	public ButtonAll(int tag, int num) {
		super();
		this.tag = tag;
		this.num = num;
	}

	public ButtonAll(String name) {
		super(name);
	}

	public int getSeatNum() {
		return num;
	}

	public void setSeatNum(int num) {
		this.num = num;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getTag() {
		return tag;
	}
}


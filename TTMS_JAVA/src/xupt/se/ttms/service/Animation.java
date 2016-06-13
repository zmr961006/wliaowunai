package xupt.se.ttms.service;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import xupt.se.ttms.view.tmpl.*;


public class Animation extends TimerTask {
	private Timer timer;
	private JFrame rootFrame;
	private JPanel panel;
	private boolean isPush;
	private boolean isNext;

	public Animation(Timer timer, JFrame frame, JPanel panel,
			boolean isPush, boolean isNext) {
		this.timer = timer;
		this.rootFrame = frame;
		this.panel = panel;
		this.isPush = isPush;
		this.isNext = isNext;
	}

	@Override
	public void run() {
		int x;
		if (isPush) {
			x = this.panel.getX() - 5;
		} else {
			x = this.panel.getX() + 5;
		}
		int y = this.panel.getY();
		this.panel.setLocation(x, y);

		if (isPush && x < -Basic.Width()) {
			this.panel.setVisible(false);
			this.timer.cancel();
		}
		if (!isPush) {
			if (!isNext && x >= Basic.Width()) {
				this.panel.setVisible(false);
				this.rootFrame.remove(this.panel);
				this.timer.cancel();
			} else if (isNext && x >= 0) {
				this.timer.cancel();
			}
			
		}
	}

}
package xupt.se.ttms.view.tmpl;

import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import xupt.se.ttms.service.*;

/**
 * 该类提供了一个界面之间的转换效果 作为一个界面的控制器 使用该控制器的同时 需要设置根panel
 * 
 * @author Tangtang
 */

@SuppressWarnings("serial")
public class TTNavigationController extends JFrame {
	private MyStack<JPanel> navigationSK;
	private final static TTNavigationController navigation = new TTNavigationController();

	private TTNavigationController() {
		setUndecorated(true);
		setLayout(null);
		HeadPanel headPanel = HeadPanel.getHeadPanel();
		headPanel.superFrame = this;
		add(headPanel);
		this.navigationSK = MyStack.getInstance();
	}

	public static TTNavigationController getInstance() {
		return navigation;
	}

	public void addRootPanel(JPanel rootPanel) {
		rootPanel.setBounds(0, 0, Basic.Width(),
				Basic.Height());
		navigationSK.push(rootPanel);
		add(rootPanel);
		repaint();
	}

	/**
	 * 该函数用来推出下一个界面
	 * 
	 * @param viewPanel
	 *            要推进去的下一个界面的参数
	 * @param animation
	 *            是否开启动画
	 */
	public void pushViewController(JPanel viewPanel, Boolean animation) {
		JPanel prePanel = this.navigationSK.peek();

		if (animation) {
			Timer timerPre = new Timer();
			timerPre.scheduleAtFixedRate(new Animation(timerPre, this,
					prePanel, true, false), 0, 3);
		} else {
			prePanel.setVisible(false);
		}

		this.navigationSK.push(viewPanel);
		add(viewPanel);
		viewPanel.setVisible(true);
	}

	/**
	 * 该函数用来退回上一层界面，对应的当前界面被移除
	 * 
	 * @param animation
	 *            是否开启动画
	 */
	public void popViewController(Boolean animation) {
		if (navigationSK.size() == 1) {
			return;
		}
		
		JPanel nowPanel = this.navigationSK.pop();
		JPanel prePanel = this.navigationSK.peek();

		prePanel.setVisible(true);

		if (animation) {
			Timer timerBack = new Timer();
			timerBack.scheduleAtFixedRate(new Animation(timerBack, this,
					nowPanel, false, false), 0, 3);

			Timer timerNext = new Timer();
			timerNext.scheduleAtFixedRate(new Animation(timerNext, this,
					prePanel, false, true), 3, 3);
		} else {
			nowPanel.setVisible(false);
			remove(nowPanel);
		}

	}

	/**
	 * 返回到根视图方法
	 * 
	 * @param animation
	 */
	public void popToRootPanel(boolean animation) {
		if (navigationSK.size() == 1) {
			return;
		}
		JPanel nowPanel = navigationSK.pop();
		for (int i = navigationSK.size(); i > 1; i--) {
			navigationSK.pop();
		}
		JPanel rootPanel = navigationSK.peek();
		rootPanel.setVisible(true);

		if (animation) {
			Timer timerBack = new Timer();
			timerBack.scheduleAtFixedRate(new Animation(timerBack, this,
					nowPanel, false, false), 0, 3);

			Timer timerNext = new Timer();
			timerNext.scheduleAtFixedRate(new Animation(timerNext, this,
					rootPanel, false, true), 3, 3);
		} else {
			nowPanel.setVisible(false);
			remove(nowPanel);
		}
	}

	/**
	 * 获取头视图
	 * 
	 * @return 返回一个当前界面的头视图
	 */
	public static HeadPanel getHeadPanel() {
		return HeadPanel.getHeadPanel();
	}
}

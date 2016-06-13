package xupt.se.ttms.view.tmpl;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import xupt.se.ttms.view.tmpl.Basic;

@SuppressWarnings("serial")
public class HeadPanel extends JPanel implements MouseMotionListener,
		MouseListener {
	private final static HeadPanel headPanel = new HeadPanel();
	public JFrame superFrame;
	public JButton userButton;
	public JLabel titleLabel;
	public JLabel userNameLabel;
	int mx, my, jfx, jfy;

	private HeadPanel() {
		setBounds(0, 0, Basic.Width() + 1, Basic.HeadHeight());
		setLayout(null);
		setBackground(Color.white);
		// 设置边框
		setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		// 设置缩小到底部的按钮
		CircleButton downButton = new CircleButton(null,
				new Color(248, 189, 68));
		downButton.setBounds(Basic.Width() - 40, 2, 16, 16);
		add(downButton);

		downButton.addMouseListener(this);

		// 设置关闭按钮
		CircleButton closeButton = new CircleButton(null, new Color(255, 125,
				110));
		closeButton.setBounds(Basic.Width() - 20, 2, 16, 16);
		add(closeButton);

		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		addMouseMotionListener(this);
		
		titleLabel = new JLabel("影院管理系统",JLabel.CENTER);
		titleLabel.setForeground(new Color(162, 157, 157));
		titleLabel.setFont(new Font("Kaiti SC", 1, 24));
		titleLabel.setBounds(Basic.Width() / 2 - 80, 20, 
				160, 24);
		add(titleLabel);
		
		userButton = new CircleButton(null, Color.WHITE);
		userButton.setBounds(20, 15, 39, 39);
		add(userButton);
		
		ImageIcon RightIcon = new ImageIcon("resource/image/changeLeft.png");
		userButton.setIcon(RightIcon);
		userButton.setBorderPainted(false);
		userButton.setContentAreaFilled(false);
	
	}

	public JFrame getSuperFrame() {
		return superFrame;
	}

	public void setSuperFrame(JFrame superFrame) {
		this.superFrame = superFrame;
	}

	public static HeadPanel getHeadPanel() {
		return headPanel;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		if (this.superFrame != null) {
			this.superFrame.setLocation(jfx + (arg0.getXOnScreen() - mx), jfy
					+ (arg0.getYOnScreen() - my));
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		if (this.superFrame != null) {
			mx = arg0.getXOnScreen();
			my = arg0.getYOnScreen();
			jfx = this.superFrame.getX();
			jfy = this.superFrame.getY();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (this.superFrame != null) {
			this.superFrame.setExtendedState(JFrame.HIDE_ON_CLOSE);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

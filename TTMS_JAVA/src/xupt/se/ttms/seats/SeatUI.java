package xupt.se.ttms.seats;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import xupt.se.ttms.view.tmpl.ButtonAll;
import xupt.se.ttms.view.tmpl.LabelAll;

@SuppressWarnings("serial")
public class SeatUI extends JPanel implements ActionListener {

	private int cnt = 0;
	String s = null;
	private ButtonAll button = null;
	private ButtonAll button1 = null;
	private ButtonAll button2 = null;
	private ButtonAll button3 = null;
	private ButtonAll button4 = null;
	private LabelAll label1 = null; // 标签
	private LabelAll labelData = null;
	private LabelAll labelTime = null;
	private LabelAll label4 = null;
	private LabelAll label5 = null;
	private LabelAll label6 = null;
	private LabelAll label7 = null;
	private LabelAll label8 = null;
	private LabelAll label9 = null;
	private LabelAll labelFilmType = null;
	private ArrayList<String> seatnum = new ArrayList<String>(); // 存储座位的数组

	@SuppressWarnings("static-access")
	public SeatUI(final String price, final String movieName,
			final String movieTime, final String movieType) {
		this.setBounds(0, 0, 815, 548);
		// this.setBackground(new Color(0,0,0));
		this.setLayout(null);

		label1 = new LabelAll("奥斯卡国际影城");
		label1.setFont(new Font("Kaiti SC", 1, 15));
		label1.setForeground(new Color(162, 157, 157));
		label1.setBounds(90, 75, 300, 30);
		this.add(label1);

		labelData = new LabelAll(movieName);
		labelData.setFont(new Font("Kaiti SC", 1, 13));
		labelData.setForeground(new Color(162, 157, 157));
		labelData.setBounds(86, 110, 60, 15);
		this.add(labelData);
		labelTime = new LabelAll(movieTime);
		labelTime.setFont(new Font("Kaiti SC", 1, 13));
		labelTime.setForeground(new Color(162, 157, 157));
		labelTime.setBounds(138, 110, 100, 15);
		this.add(labelTime);
		labelFilmType = new LabelAll(movieType);
		labelFilmType.setFont(new Font("Kaiti SC", 1, 13));
		labelFilmType.setForeground(new Color(162, 157, 157));
		labelFilmType.setBounds(236, 110, 60, 15);
		this.add(labelFilmType);

		label4 = new LabelAll("可选座位");
		label4.setFont(new Font("Kaiti SC", 1, 13));
		label4.setForeground(new Color(162, 157, 157));
		label4.setBounds(460, 110, 60, 15);
		this.add(label4);
		label5 = new LabelAll("不可选座位");
		label5.setFont(new Font("Kaiti SC", 1, 13));
		label5.setForeground(new Color(162, 157, 157));
		label5.setBounds(580, 110, 80, 15);
		this.add(label5);
		label6 = new LabelAll("已选座位");
		label6.setFont(new Font("Kaiti SC", 1, 13));
		label6.setForeground(new Color(162, 157, 157));
		label6.setBounds(700, 110, 60, 15);
		this.add(label6);

		button1 = new ButtonAll();
		button1.setIcon(new ImageIcon("resource/image/sit1.png"));
		button1.setBounds(440, 108, 18, 18);
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		this.add(button1);
		button2 = new ButtonAll();
		button2.setIcon(new ImageIcon("resource/image/sit2.png"));
		button2.setBounds(560, 108, 18, 18);
		button2.setBorderPainted(false);
		button2.setContentAreaFilled(false);
		this.add(button2);
		button3 = new ButtonAll();
		button3.setIcon(new ImageIcon("resource/image/sit3.png"));
		button3.setBounds(680, 108, 18, 18);
		button3.setBorderPainted(false);
		button3.setContentAreaFilled(false);
		this.add(button3);

		label7 = new LabelAll("银幕", label7.CENTER);
		label7.setFont(new Font("Kaiti SC", 1, 15));
		label7.setForeground(new Color(162, 157, 157));
		label7.setBounds(280, 140, 220, 30);
		label7.setOpaque(true);
		label7.setBackground(new Color(190, 190, 190));
		this.add(label7);
		label8 = new LabelAll("银幕中央", label8.CENTER);
		label8.setFont(new Font("Kaiti SC", 1, 12));
		label8.setForeground(new Color(162, 157, 157));
		label8.setBounds(340, 185, 100, 25);
		label8.setOpaque(true);
		label8.setBackground(new Color(211, 211, 211));
		this.add(label8);

		// 演出厅中央放座位
		int x = 265, y = 230;
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				button = new ButtonAll(0, i * 10 + j);
				button.setIcon(new ImageIcon(
						"resource/image/sit1.png"));
				button.setBounds(x, y, 18, 18);
				button.setBorderPainted(false);
				button.setContentAreaFilled(false);
				button.addActionListener(this);
				this.add(button);
				x = x + 26;
			}
			x = x - 10 * 26;
			y = y + 24;
		}

		label9 = new LabelAll("一次最多选6个座位");
		label9.setFont(new Font("Kaiti SC", 1, 12));
		label9.setForeground(new Color(162, 157, 157));
		label9.setBounds(640, 410, 120, 25);
		this.add(label9);
		button4 = new ButtonAll("提交订单");
		button4.setFont(new Font("Kaiti SC", 1, 11));
		button4.setBounds(645, 440, 90, 25);
		button4.setForeground(Color.WHITE);
		button4.setOpaque(true);
		button4.setBackground(new Color(244, 164, 96));
		button4.setBorderPainted(false);
		this.add(button4);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seatnum.size() > 0) {
//					TestPay test = new TestPay(movieName, movieType, movieTime,
//							price, seatnum);
//					TTNavigationController navigation = TTNavigationController
//							.getInstance();
//					navigation.pushViewController(test, true);
				} else {
					JOptionPane.showConfirmDialog(null, "还未选择座位！","", JOptionPane.YES_OPTION);
				}
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		ButtonAll chooseButton = (ButtonAll) e.getSource();
		if (chooseButton.getTag() == 0 && cnt <= 5) {
			chooseButton.setIcon(new ImageIcon(
					"resource/image/sit3.png"));
			chooseButton.setTag(1);
			if (chooseButton.getSeatNum() == 110) {
				s = "10排10号";
			} else {
				int y = (chooseButton.getSeatNum()) % 10;
				int x = (chooseButton.getSeatNum()) / 10;
				s = x + "排" + y + "号";
			}
			seatnum.add(s);
			cnt++;
		} else if (chooseButton.getTag() == 1) {
			chooseButton.setIcon(new ImageIcon(
					"resource/image/sit1.png"));
			chooseButton.setTag(0);
			if (chooseButton.getSeatNum() == 110) {
				s = "10排10号";
			} else {
				int y = (chooseButton.getSeatNum()) % 10;
				int x = (chooseButton.getSeatNum()) / 10;
				s = x + "排" + y + "号";
			}
			seatnum.remove(s);
			cnt--;
		} else if (chooseButton.getTag() == 2) {
			return;
		}
		if (cnt == 6) {
			javax.swing.JOptionPane.showMessageDialog(null, "一次最多只能选6个座位");
		}
	}

}

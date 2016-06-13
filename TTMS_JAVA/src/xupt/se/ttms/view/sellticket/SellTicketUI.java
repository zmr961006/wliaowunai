package xupt.se.ttms.view.sellticket;

import javax.swing.*;

import xupt.se.ttms.view.tmpl.Basic;
import xupt.se.ttms.view.tmpl.TTNavigationController;
import xupt.se.ttms.view.tmpl.ImageScrollView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import xupt.se.ttms.seats.SeatUI;

@SuppressWarnings("serial")
public class SellTicketUI extends JPanel implements ActionListener {

	private JPanel numberLogin, emailLogin, phoneNumberLogin;
	private JTabbedPane choice;

	private JLabel t1, t2;
	private JPanel data4, data7, data8;

	// 底部按钮
	private JPanel p1;

	public SellTicketUI() {
		
	}
	
	public SellTicketUI(ArrayList<String> imagePaths) {
		setLayout(null);
		
		ImageScrollView scrollView = new ImageScrollView(imagePaths);
		scrollView.setBounds(0, Basic.HeadHeight(), Basic.Width(), 230);
		add(scrollView);

		// 时间场次选择
		JPanel data2 = new JPanel();
		Box vtemp = Box.createVerticalBox();

		Box b32a = Box.createHorizontalBox();
		Box b32b = Box.createHorizontalBox();
		Box b32c = Box.createHorizontalBox();
		JButton b321 = new JButton("立即购票");
		b321.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatUI tms = new SeatUI("25", "超人", "3月7日 17:00", "英语3D");
				TTNavigationController navigation = TTNavigationController
						.getInstance();
				navigation.pushViewController(tms, true);
				
			}
		});
		JButton b322 = new JButton("立即购票");
		b322.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatUI tms = new SeatUI("25", "超人", "3月7日 17:00", "英语3D");
				TTNavigationController navigation = TTNavigationController
						.getInstance();
				navigation.pushViewController(tms, true);
			}
		});
		JButton b323 = new JButton("立即购票");
		b323.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatUI tms = new SeatUI("25", "超人", "3月7日 17:00", "英语3D");
				TTNavigationController navigation = TTNavigationController
						.getInstance();
				navigation.pushViewController(tms, true);
			}
		});
		t1 = new JLabel("奥斯卡国际影城        9:00  - 12:00    ");
		t2 = new JLabel("奥斯卡国际影城        2:00  - 16:00    ");
		JLabel t3 = new JLabel("奥斯卡国际影城        20:00 - 22:00   ");
		b32a.add(t1);
		b32a.add(b321);
		b32b.add(t2);
		b32b.add(b322);
		b32c.add(t3);
		b32c.add(b323);

		vtemp.add(b32a);
		vtemp.add(b32b);
		vtemp.add(b32c);
		data2.add(vtemp);
	
		data4 = new JPanel();
		Box vte3 = Box.createVerticalBox();
		Box BB1 = Box.createHorizontalBox();
		Box BB2 = Box.createHorizontalBox();
		Box BB3 = Box.createHorizontalBox();
		JButton LB1 = new JButton("立即购票");
		JButton LB2 = new JButton("立即购票");
		JButton LB3 = new JButton("立即购票");
		JLabel Button1 = new JLabel("奥斯卡国际影城A        9:00  - 12:00    ");
		JLabel Button2 = new JLabel("奥斯卡国际影城A    	 2:00  - 16:00    ");
		JLabel Button3 = new JLabel("奥斯卡国际影城A        20:00 - 22:00   ");
		BB1.add(Button1);
		BB1.add(LB1);
		BB2.add(Button2);
		BB2.add(LB2);
		BB3.add(Button3);
		BB3.add(LB3);
		vte3.add(BB1);
		vte3.add(BB2);
		vte3.add(BB3);
		data4.add(vte3);

		data7 = new JPanel();
		Box vte7 = Box.createVerticalBox();
		Box FF1 = Box.createHorizontalBox();
		Box FF2 = Box.createHorizontalBox();
		Box FF3 = Box.createHorizontalBox();
		JButton BU1 = new JButton("立即购票");
		JButton BU2 = new JButton("立即购票");
		JButton BU3 = new JButton("立即购票");
		JLabel LA1 = new JLabel("奥斯卡国际影城A        9:00  - 12:00    ");
		JLabel LA2 = new JLabel("奥斯卡国际影城A      	 2:00  - 16:00    ");
		JLabel LA3 = new JLabel("奥斯卡国际影城A        20:00 - 22:00   ");
		BB1.add(LA1);
		BB1.add(BU1);
		BB2.add(LA2);
		BB2.add(BU2);
		BB3.add(LA3);
		BB3.add(BU3);
		vte7.add(FF1);
		vte7.add(FF2);
		vte7.add(FF3);
		data7.add(vte7);

		data8 = new JPanel();
		Box vte8 = Box.createVerticalBox();
		Box DD1 = Box.createHorizontalBox();
		Box DD2 = Box.createHorizontalBox();
		Box DD3 = Box.createHorizontalBox();
//		JButton AU1 = new JButton("立即购票");
//		JButton AU2 = new JButton("立即购票");
//		JButton AU3 = new JButton("立即购票");
		JLabel DA1 = new JLabel("奥斯卡国际影城A        9:00  - 12:00    ");
		JLabel DA2 = new JLabel("奥斯卡国际影城A    	 2:00  - 16:00    ");
		JLabel DA3 = new JLabel("奥斯卡国际影城A        20:00 - 22:00   ");
		DD1.add(DA1);
//		DD1.add(AU1);
		DD2.add(DA2);
//		DD2.add(AU2);
		DD3.add(DA3);
//		DD3.add(AU3);
		vte8.add(DD1);
		vte8.add(DD2);
		vte8.add(DD3);
		data8.add(vte8);

		JPanel data1 = new JPanel();
		Box vtemp1 = Box.createVerticalBox();

		Box tic1 = Box.createHorizontalBox();
		Box tic2 = Box.createHorizontalBox();
		Box tic3 = Box.createHorizontalBox();
		JButton ticc1 = new JButton("立即购票");
		ticc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatUI tms = new SeatUI("25", "超人", "3月7日 17:00", "英语3D");
				TTNavigationController navigation = TTNavigationController
						.getInstance();
				navigation.pushViewController(tms, true);
			}
		});
		JButton ticc2 = new JButton("立即购票");
		ticc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatUI tms = new SeatUI("25", "超人", "3月7日 17:00", "英语3D");
				TTNavigationController navigation = TTNavigationController
						.getInstance();
				navigation.pushViewController(tms, true);
			}
		});
		JButton ticc3 = new JButton("立即购票");
		ticc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatUI tms = new SeatUI("25", "超人", "3月7日 17:00", "英语3D");
				TTNavigationController navigation = TTNavigationController
						.getInstance();
				navigation.pushViewController(tms, true);
			}
		});
		JLabel x1 = new JLabel("奥斯卡国际影城        9:00  - 12:00    ");
		JLabel x2 = new JLabel("奥斯卡国际影城        2:00  - 16:00    ");
		JLabel x3 = new JLabel("奥斯卡国际影城        20:00 - 22:00    ");

		tic1.add(x1);
		tic1.add(ticc1);
		tic2.add(x2);
		tic2.add(ticc2);
		tic3.add(x3);
		tic3.add(ticc3);

		vtemp1.add(tic1);
		vtemp1.add(tic2);
		vtemp1.add(tic3);
		data1.add(vtemp1);

		JPanel data3 = new JPanel();
		Box vtemp3 = Box.createVerticalBox();
		Box b33a = Box.createHorizontalBox();
		Box b33b = Box.createHorizontalBox();
		Box b33c = Box.createHorizontalBox();
		JButton b331 = new JButton("立即购票");
		b331.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatUI tms = new SeatUI("25", "超人", "3月7日 17:00", "英语3D");
				TTNavigationController navigation = TTNavigationController
						.getInstance();
				navigation.pushViewController(tms, true);
			}
		});
		JButton b332 = new JButton("立即购票");
		b332.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatUI tms = new SeatUI("25", "超人", "3月7日 17:00", "英语3D");
				TTNavigationController navigation = TTNavigationController
						.getInstance();
				navigation.pushViewController(tms, true);
			}
		});
		JButton b333 = new JButton("立即购票");
		b333.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatUI tms = new SeatUI("25", "超人", "3月7日 17:00", "英语3D");
				TTNavigationController navigation = TTNavigationController
						.getInstance();
				navigation.pushViewController(tms, true);
			}
		});
		JLabel Q1 = new JLabel("奥斯卡国际影城        9:00  - 12:00    ");
		JLabel Q2 = new JLabel("奥斯卡国际影城        2:00  - 16:00    ");
		JLabel Q3 = new JLabel("奥斯卡国际影城        20:00 - 22:00   ");
		b33a.add(Q1);
		b33a.add(b331);
		b33b.add(Q2);
		b33b.add(b332);
		b33c.add(Q3);
		b33c.add(b333);
		vtemp3.add(b33a);
		vtemp3.add(b33b);
		vtemp3.add(b33c);
		data3.add(vtemp3);

		p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p1.setBounds(0, Basic.HeadHeight() + 240, Basic.Width(), 
				Basic.Height() - Basic.HeadHeight() - 240);

		// 中部布局的设置
		// 3月2日
		phoneNumberLogin = new JPanel();
		phoneNumberLogin.add(data2);

		// 3月1日
		numberLogin = new JPanel();
		numberLogin.add(data1);

		// 3月3日
		emailLogin = new JPanel();
		emailLogin.add(data3);

		// 标签卡
		choice = new JTabbedPane();
		choice.add("3月1日", numberLogin);
		choice.add("3月2日", phoneNumberLogin);
		choice.add("3月3日", emailLogin);
		choice.setFont(new Font("宋体", 0, 14));

		p1.add(choice);
		p1.add(new JPanel());
		add(p1, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton button = (JButton) arg0.getSource();
		
		String str = button.getIcon().toString();
		
		if (str.equals("resource/image/动物城.jpeg")) {
//			phoneNumberLogin.removeAll();
//			phoneNumberLogin.add(data4);
//			phoneNumberLogin.repaint();
		} else if (str.equals("resource/image/超人.jpg")) {
			System.out.println("sdfsdfsd");
//			phoneNumberLogin.removeAll();
//			phoneNumberLogin.add(data7);
//			phoneNumberLogin.repaint();
		} else if (str.equals("resource/image/钢铁侠.jpg")) {
//			phoneNumberLogin.removeAll();
//			phoneNumberLogin.add(data8);
//			phoneNumberLogin.repaint();
		}

	}
}

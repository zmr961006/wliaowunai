package xupt.se.ttms.view.tmpl;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import xupt.se.ttms.login.marge_login;



@SuppressWarnings("serial")
public class MainUITmpl extends JFrame {

	protected final JPanel contPan = new JPanel();
	
	public MainUITmpl() {
		marge_login respanel = new marge_login();
		respanel.setBackground(Color.WHITE);

		TTNavigationController navigation = TTNavigationController
				.getInstance();
		navigation.addRootPanel(respanel);
		navigation.setBackground(Color.WHITE);
		navigation.setSize(815, 548);
		navigation.setLocationRelativeTo(null);
		navigation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		navigation.setVisible(true);

//		JButton saleLogin = LoginedUserUI.getUserLogin();
//		saleLogin.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				ArrayList<String> ImagePath = new ArrayList<String>();
//				ImagePath.add("resource/image/动物城.jpeg");
//				ImagePath.add("resource/image/超人.jpg");
//				ImagePath.add("resource/image/钢铁侠.jpg");
//				ImagePath.add("resource/image/荒野.jpg");
//				ImagePath.add("resource/image/少林.jpg");
//
//				SellTicketUI demo7 = new SellTicketUI(ImagePath);
//				demo7.setBackground(Color.WHITE);
//				demo7.setBounds(0, 0, Basic.Width(),
//						Basic.Height());
//				TTNavigationController navigation = TTNavigationController
//						.getInstance();
//				navigation.pushViewController(demo7, true);
//			}
//		});
//
//		JButton collLogin = LoginedUserUI.getManageLogin();
//		collLogin.addActionListener(this);

		HeadPanel headPanel = HeadPanel.getHeadPanel();
		JButton userButton = headPanel.userButton;
		userButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TTNavigationController navigation = TTNavigationController
						.getInstance();
				navigation.popViewController(true);
			}
		});
	}

	public static void main(String[] args) {
		new MainUITmpl();
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		AdminModUI moviePanel = new AdminModUI();
//		moviePanel.setBackground(Color.WHITE);
//		moviePanel.setBounds(0, 0, Basic.Width(),
//				Basic.Height());
//
//		TTNavigationController navigation = TTNavigationController
//				.getInstance();
//		navigation.pushViewController(moviePanel, true);
//	}
	
	protected void initContent(){
	}

}
package xupt.se.ttms.login;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import xupt.se.ttms.view.system.LoginedUserUI;
import xupt.se.ttms.view.tmpl.Basic;
import xupt.se.ttms.view.tmpl.TTNavigationController;
@SuppressWarnings("serial")
public class marge_login extends JPanel {

	
	    JButton sale = new JButton("用户登录");
	    JButton coll = new JButton("管理员登录");

	    public marge_login() {

	        JPanel q1 = new JPanel();
	        q1.setLayout(null);
	        this.setLayout(new GridLayout(3,1));
	        JLabel label = new JLabel("唐人",SwingConstants.CENTER);

	        label.setBounds(0,0,50,50);
	        label.setFont(new Font("楷体", Font.BOLD, 30));

	        sale.setBackground(new Color(250,240,230));
	        sale.setBounds(200, 20, 100, 100);
	        q1.add(sale);


	        coll.setBackground(new Color(240,128,128));
	        coll.setBounds(480, 20, 100, 100);
	        q1.add(coll);

	        this.add(label);
	        this.add(q1);


	        sale.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	            	LoginedUserUI login = new LoginedUserUI();
	            	login.setBackground(Color.WHITE);
	            	login.setBounds(0, Basic.HeadHeight(), Basic.Width(), Basic.Height() - Basic.HeadHeight());
	            	
	        		TTNavigationController navigation = TTNavigationController
					.getInstance();
	        		navigation.pushViewController(login, true);
	        		login.setVisible(true);
	            }

	        });



	        coll.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	            }

	        });

	    }

	    
	}



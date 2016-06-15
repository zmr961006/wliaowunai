package xupt.se.ttms.view.system;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import xupt.se.ttms.view.system.LoginedUserUI;
import xupt.se.ttms.view.tmpl.Basic;
import xupt.se.ttms.view.tmpl.TTNavigationController;


@SuppressWarnings("serial")
public class LoginedMainUI extends JPanel {
    private static  JButton sale = new JButton("用户登录");
    private static JButton coll = new JButton("管理员登录");

    public void init() {

        JLabel label = new JLabel("唐人");

        label.setBounds(0,0,50,50);
        label.setFont(new Font("楷体", Font.BOLD, 30));
        add(label);

        sale.setBackground(new Color(250,240,230));
        sale.setBounds(200, 20, 100, 100);
        add(sale);


        coll.setBackground(new Color(240,128,128));
        coll.setBounds(480, 20, 100, 100);
        add(coll);

        setBackground(Color.blue);

        sale.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	System.out.println("222222");
            	LoginedUserUI login = new LoginedUserUI();
            	login.setBackground(Color.WHITE);
            	//login.init();
            	
				TTNavigationController navigation = TTNavigationController.getInstance();
				navigation.pushViewController(login, true);
            }

        });

        coll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	System.out.println("11111");
        		AdminModUI moviePanel = new AdminModUI();
        		moviePanel.setBackground(Color.WHITE);
        		moviePanel.setBounds(0, 0, Basic.Width(),
        				Basic.Height());
        
        		TTNavigationController navigation = TTNavigationController
        				.getInstance();
        		navigation.pushViewController(moviePanel, true);
            	
            }

        });

    }
}

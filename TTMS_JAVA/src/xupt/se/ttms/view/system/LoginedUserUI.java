package xupt.se.ttms.view.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import xupt.se.ttms.view.tmpl.*;

@SuppressWarnings("serial")
public class LoginedUserUI extends JPanel {
	 private static JButton sale = new JButton();
	    private static JButton coll = new JButton();

	    public void init() {
	    	setLayout(null);
	        CircleButton button=new CircleButton(null, new Color(216, 216, 216));
	        button.setEnabled(false);
	        button.setBounds(378, 95, 54, 54);
	        add(button);
	        
	        ImageIcon saleIcon = new ImageIcon("resource/image/changePass.png");
			sale.setIcon(saleIcon);
			sale.setBorderPainted(false);
			sale.setContentAreaFilled(false);
			sale.setBounds(409 - 74, 1500 - 1152, 139, 31);
			add(sale);
			
			ImageIcon collIcon = new ImageIcon("resource/image/collLogin.png");
			coll.setIcon(collIcon);
			coll.setBorderPainted(false);
			coll.setContentAreaFilled(false);
			coll.setBounds(409 - 74, 1545 - 1152, 139, 31);
			add(coll);

	        JLabel yh = new JLabel("用户名:");
	        yh.setFont(new Font("Kaiti SC", 1, 13));
	        yh.setBounds(351 - 74, 1355 - 1152, 50, 18);
	        yh.setForeground(new Color(162, 157, 157));
	        add(yh);
	        
	        final RoundJTextField name = new RoundJTextField(17);
	        name.setBounds(409 - 74, 1349 - 1152, 141, 24);
	        name.setForeground(new Color(216, 216, 216));
	        add(name);
	        
	        JLabel mm = new JLabel("密码:");
	        mm.setFont(new Font("Kaiti SC", 1, 13));
	        mm.setBounds(364 - 74, 1393 - 1152, 50, 18);
	        mm.setForeground(new Color(162, 157, 157));
	        add(mm);
	        
	        final RoundPassTextField password = new RoundPassTextField(17);
	        password.setBounds(409 - 74, 1387 - 1152, 141, 24);
	        password.setForeground(new Color(216, 216, 216));
	        add(password);
	        
	    /*    sale.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String names = name.getText();
	                String npassword = String.valueOf(password.getPassword());
	                if (users.equals(name)) {
	                    int num = 3;
	                    if (users.equals(password)) {


	                    } else {
	                        num--;
	                        if (num > 0) {
	                            JOptionPane.showMessageDialog(Login.this, "瀵�������璇�!杩����" + num + "娆℃�轰��");
	                            password.setText("");
	                        } else if (num == 0) {
	                            JOptionPane.showMessageDialog(Login.this, "��诲��3娆″け璐ョ��搴���抽��锛�");
	                            System.exit(0);
	                        }
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(Login.this, "涓�瀛���ㄨ�ョ�ㄦ�峰��");
	                    name.setText("");
	                    password.setText("");
	                }

	            }
	        });
	        coll.addActionListener(new ActionListener()//��诲�����������
	        {
	            public void actionPerformed(ActionEvent e) {
	                String names = name.getText();
	                String npassword = String.valueOf(password.getPassword());
	                if (message.containsKey(name)) {
	                    int num = 3;
	                    if (message.get(name).equals(password)) {

	                    } else {
	                        num--;
	                        if (num > 0) {
	                            JOptionPane.showMessageDialog(Login.this, "瀵�������璇�!杩����" + num + "娆℃�轰��");
	                            password.setText("");
	                        } else if (num == 0) {
	                            JOptionPane.showMessageDialog(Login.this, "��诲��3娆″け璐ョ��搴���抽��锛�");
	                            System.exit(0);
	                        }
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(Login.this, "涓�瀛���ㄨ�ョ�ㄦ�峰��");
	                    name.setText("");
	                    password.setText("");
	                }

	            }
	        });*/
	        
	    }
	    
	    public static JButton getUserLogin() {
	    	return sale;
	    }
	    
	    public static JButton getManageLogin() {
	    	return coll;
	    }
}

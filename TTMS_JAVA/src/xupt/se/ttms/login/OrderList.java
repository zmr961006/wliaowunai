package xupt.se.ttms.login;
/*配合购票，名字需要重置，暂定*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import xupt.se.ttms.view.tmpl.*;

public class OrderList extends JPanel{
	JPanel p1 = new JPanel();	
	JScrollPane jsp = new JScrollPane(p1);
	
	public OrderList(){
		setBackground(Color.white);
		setBounds(0, Basic.HeadHeight(), Basic.Width(),
				Basic.Height() - Basic.HeadHeight());
		setLayout(null);
		
		p1.setBackground(Color.white);
		p1.setLayout(null);
		p1.setPreferredSize(new Dimension(Basic.Width(),1000));
		
		jsp.setBackground(Color.white);
		jsp.setBounds(0, 0, Basic.Width(),
				Basic.Height() - Basic.HeadHeight());
//		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		

		class OrderPanel extends JPanel{
		
		JPanel pa = new JPanel();
		OrderPanel(){
		
		ImageIcon buttonIcon = new ImageIcon(
				"resource/image/tuipiao.png");
		
		pa.setBounds(0,0,Basic.Width(),121);
		pa.setBackground(Color.white);
		pa.setLayout(null);
		pa.setBorder(new LineBorder(Color.gray,1));
		JLabel movieName1 = new JLabel("超人");
		JLabel movieType1 = new JLabel("英语3D");
		JLabel cinemaName1 = new JLabel("长安奥斯卡国际影城");
		JLabel seatNumnber1 = new JLabel("5排3号  5排4号");
		JLabel time1 = new JLabel("2016年6月25日  13:30");
		JLabel price1 = new JLabel("50元");
		
		Color hui = new Color(162, 157, 157);
		Color hong = new Color(243,170,170);
		Font labelFont = new Font("Kaiti SC", 1, 15);
		Font priceFont = new Font("Kaiti SC", 1, 30);
		
		movieName1.setFont(labelFont);
		movieName1.setForeground(hui);
		movieName1.setBounds(30,20,150,20);
		movieType1.setFont(labelFont);
		movieType1.setForeground(hui);
		movieType1.setBounds(210,20,100,20);
		cinemaName1.setFont(labelFont);
		cinemaName1.setForeground(hui);
		cinemaName1.setBounds(30,50,150,20);
		seatNumnber1.setFont(labelFont);
		seatNumnber1.setForeground(hui);
		seatNumnber1.setBounds(210,50,150,20);
		time1.setFont(labelFont);
		time1.setForeground(hui);
		time1.setBounds(30,80,150,20);
		price1.setFont(priceFont);
		price1.setForeground(hong);
		price1.setBounds(550,50,150,30);
		JButton jbttui1 = new JButton();
		jbttui1.setIcon(buttonIcon);
		jbttui1.setContentAreaFilled(false);
		jbttui1.setBorderPainted(false);
		jbttui1.setBounds(690,45,90,30);
		
		pa.add(movieName1);
		pa.add(movieType1);
		pa.add(cinemaName1);
		pa.add(seatNumnber1);
		pa.add(time1);
		pa.add(price1);
		pa.add(jbttui1);
				
		}
		}				
		
		OrderPanel p2 = new OrderPanel();
		OrderPanel p3 = new OrderPanel();
		p3.pa.setBounds(0,122,Basic.Width(),121);
		OrderPanel p4 = new OrderPanel();
		p4.pa.setBounds(0,244,Basic.Width(),121);
		OrderPanel p5 = new OrderPanel();
		p5.pa.setBounds(0,366,Basic.Width(),121);
		OrderPanel p6 = new OrderPanel();
		p6.pa.setBounds(0,488,Basic.Width(),121);
		
		p1.add(p2.pa);
		p1.add(p3.pa);
		p1.add(p4.pa);
		p1.add(p5.pa);
		p1.add(p6.pa);
		
		add(jsp);
	}

	
}
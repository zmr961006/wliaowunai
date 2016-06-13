package xupt.se.ttms.view.tmpl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import xupt.se.ttms.view.sellticket.SellTicketUI;

/**
 * 该类提供了对图片进行滑动展示的功能
 * 
 * @author Tangtang
 * 
 */
@SuppressWarnings("serial")
public class ImageScrollView extends JPanel implements ActionListener {
	private ArrayList<String> imagePathArray;
	private JButton left;
	private JButton Right;
	private JScrollPane sp;
	private JButton preButton;

	/**
	 * 通过传入图片的路径 初始化改控件
	 * 
	 * @param imagePaths
	 *            图片路径数组
	 */
	public ImageScrollView(ArrayList<String> imagePaths) {
		setLayout(new BorderLayout());
		setBackground(new Color(133, 133, 133));
		this.imagePathArray = imagePaths;
		this.createSomeThing();
	}

	/**
	 * 创建一些必要的组件方法
	 */
	private void createSomeThing() {
		ImageIcon leftIcon = new ImageIcon("resource/image/Left.png");
		left = new JButton();
		left.setIcon(leftIcon);
		left.setBorderPainted(false);
		left.setContentAreaFilled(false);
		left.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		left.addActionListener(this);
		add(left, BorderLayout.WEST);

		ImageIcon RightIcon = new ImageIcon("resource/image/Right.png");
		Right = new JButton();
		Right.setIcon(RightIcon);
		Right.setBorderPainted(false);
		Right.setContentAreaFilled(false);
		Right.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Right.addActionListener(this);
		add(Right, BorderLayout.EAST);

		// 设置滑动panel
		JPanel conPanel = new JPanel();
		conPanel.setBackground(new Color(133, 133, 133));
		conPanel.setLayout(new BoxLayout(conPanel, BoxLayout.X_AXIS));
		if (imagePathArray != null) {
			for (int i = 0; i < imagePathArray.size(); i++) {
				conPanel.add(Box.createHorizontalStrut(20));
				ImageIcon buttonIcon = new ImageIcon(imagePathArray.get(i));
				JButton icon = new JButton();
				icon.setIcon(buttonIcon);
				icon.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
				icon.setContentAreaFilled(false);
				icon.setBorderPainted(false);
				icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				conPanel.add(icon);
				conPanel.add(Box.createHorizontalStrut(20));
				if (i == 0) {
					preButton = icon;
					preButton.setBorder(BorderFactory.createLineBorder(
							new Color(129, 222, 253), 2));
					preButton.setBorderPainted(true);
				}
				icon.addActionListener(new SellTicketUI());
				icon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						preButton.setBorderPainted(false);
						preButton.setBorder(BorderFactory.createLineBorder(
								Color.WHITE, 3));
						JButton nowButton = (JButton) e.getSource();
						preButton = nowButton;
						nowButton.setBorderPainted(true);
						nowButton.setBorder(BorderFactory.createLineBorder(
								new Color(129, 222, 253), 3));
					}
				});
			}
		}

		sp = new JScrollPane(conPanel);
		sp.setBackground(new Color(216, 216, 216));
		// 去掉边框
		sp.setBorder(null);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(sp, BorderLayout.CENTER);
		
	}
	
	public void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		@SuppressWarnings("static-access")
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == left) {
			int jspValue = sp.getHorizontalScrollBar().getValue();
			sp.getHorizontalScrollBar().setValue(jspValue -= 180);
		} else if (e.getSource() == Right) {
			int jspValue = sp.getHorizontalScrollBar().getValue();
			sp.getHorizontalScrollBar().setValue(jspValue += 180);
		}

	}

}

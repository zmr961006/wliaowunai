package xupt.se.ttms.view.system;

import xupt.se.ttms.view.tmpl.Basic;
import xupt.se.ttms.view.tmpl.CircleButton;
import xupt.se.ttms.view.tmpl.EditMoviePanel;
import xupt.se.ttms.view.tmpl.TTNavigationController;
import xupt.se.ttms.dao.PlayDAO;
import xupt.se.ttms.model.Play;
import xupt.se.ttms.view.studio.StudioMgrUI;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class AdminModUI extends JPanel implements ActionListener {
	private static JScrollPane scrollPanel;
	private static JPanel conPanel;
	private static ArrayList<MovieButton> movieArray;
	private CircleButton preButton;
	private CircleButton nextButton;
	private CircleButton addButton2;
	private PlayDAO play = new PlayDAO();
	private Play ply = new Play();

	public AdminModUI() {
		setLayout(null);
		initStack();

		conPanel = new JPanel();
		conPanel.setBackground(Color.WHITE);
		conPanel.setLayout(null);
		// 设置该属性，滚动条才可滚动
		conPanel.setPreferredSize(new Dimension(Basic.Width(),
				Basic.Height() - Basic.HeadHeight() - 50));

		scrollPanel = new JScrollPane(conPanel);
		scrollPanel.setBackground(Color.WHITE);
		scrollPanel.setBounds(0, Basic.HeadHeight() - 1,
				Basic.Width(), Basic.Height()
						- Basic.HeadHeight() - 50);
		scrollPanel.setSize(Basic.Width(), Basic.Height()
				- Basic.HeadHeight() - 50);
		// 去掉边框
		scrollPanel.setBorder(new LineBorder(new Color(198, 193, 193)));

		scrollPanel
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPanel
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPanel);

		listMovie();

		ImageIcon leftIcon = new ImageIcon(
				"resource/image/fa-plus.png");
		CircleButton addButton = new CircleButton(null, Color.WHITE);
		addButton.setIcon(leftIcon);
		addButton.setBounds(Basic.Width() / 2 - 15,
				Basic.Height() - 40, 29, 29);
		add(addButton);
		
		ImageIcon Icon = new ImageIcon(
				"resource/image/fa-plus.png");
		addButton2 = new CircleButton(null, Color.WHITE);
		addButton2.setIcon(Icon);
		addButton2.setBounds(Basic.Width() / 2 + 55,
				Basic.Height() - 40, 29, 29);
		addButton2.addActionListener(this);
		add(addButton2);

		ImageIcon preIcon = new ImageIcon(
				"resource/image/circleLeft.png");
		preButton = new CircleButton(null, Color.WHITE);
		preButton.setIcon(preIcon);
		preButton.setBounds(Basic.Width() - 100,
				Basic.Height() - 43, 35, 35);
		preButton.addActionListener(this);
		add(preButton);

		ImageIcon nextIcon = new ImageIcon(
				"resource/image/circleRight.png");
		nextButton = new CircleButton(null, Color.WHITE);
		nextButton.setIcon(nextIcon);
		nextButton.setBounds(Basic.Width() - 55,
				Basic.Height() - 43, 35, 35);
		nextButton.addActionListener(this);
		add(nextButton);

		addButton.addActionListener(this);

	}

	private static void initStack() {
		movieArray = new ArrayList<MovieButton>();
	}

	public static void listMovie() {
		conPanel.removeAll();

		for (int i = 0; i < movieArray.size(); i++) {
			MovieButton jbutton = (MovieButton) movieArray.get(i);
			jbutton.setBounds(0, (Basic.HeadHeight()) * i,
					Basic.Width() - 2, Basic.HeadHeight());
			conPanel.add(jbutton);
		}
		int height = Basic.HeadHeight() * movieArray.size();
		if (height > Basic.Height() - Basic.HeadHeight() - 50) {
			conPanel.setPreferredSize(new Dimension(Basic.Width(),
					height));
		} else {
			conPanel.setPreferredSize(new Dimension(Basic.Width(),
					Basic.Height() - Basic.HeadHeight() - 50));
		}

		conPanel.repaint();
	}

	public static ArrayList<MovieButton> getArray() {
		return movieArray;
	}

	public static JPanel getConPane() {
		return conPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == preButton) {
			int jspValue = scrollPanel.getVerticalScrollBar().getValue();
			scrollPanel.getVerticalScrollBar().setValue(
					jspValue -= 2 * Basic.HeadHeight());
		} else if (arg0.getSource() == nextButton) {
			int jspValue = scrollPanel.getVerticalScrollBar().getValue();
			scrollPanel.getVerticalScrollBar().setValue(
					jspValue += 2 * Basic.HeadHeight());
		} else if (arg0.getSource() == addButton2) {
			System.out.println("1111");
			StudioMgrUI frmStuMgr = new StudioMgrUI();
			frmStuMgr.setVisible(true);
			
		} else {
			String sa = JOptionPane.showInputDialog(null, "请输入电影名称:");
			if (sa == null) {
				return;
			} else {
				if (sa != null && sa.length() != 0 && !sa.endsWith(" ")) {
					ply.setname(sa);
					play.insert(ply);
					System.out.println("asdf");
					MovieButton movieButton = new MovieButton(sa);
					movieButton.setBackground(Color.WHITE);
					movieButton.setBorder(BorderFactory.createLineBorder(new Color(
							216, 216, 216), 1));
					movieArray.add(movieButton);
					listMovie();
				} else if (sa.length() == 0 || sa.endsWith(" ")) {
					JOptionPane.showConfirmDialog(this, "电影名称不能为空!", "Option",
							JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
				}
			}
		}
	}
}

/**
 * 电影列表按钮 不可选
 * 
 * @author Tangtang
 * 
 */
@SuppressWarnings("serial")
class MovieButton extends JPanel implements ActionListener {
	private JLabel titleLabel;
	private JButton angleButton;
	private JButton deleteButton;
	public boolean tag;
	public EditMoviePanel editPanel;

	public EditMoviePanel getEditPanel() {
		return editPanel;
	}

	public void setEditPanel(EditMoviePanel editPanel) {
		this.editPanel = editPanel;
	}

	public MovieButton(String titleString) {
		setLayout(null);

		tag = true;
		titleLabel = new JLabel(titleString);
		titleLabel.setForeground(new Color(162, 157, 157));
		titleLabel.setFont(new Font("Kaiti SC", 1, 15));
		titleLabel.setBounds(50, 15, Basic.Width() / 2, 30);
		add(titleLabel);

		ImageIcon leftIcon = new ImageIcon(
				"resource/image/changeLeft.png");
		angleButton = new JButton();
		angleButton.setIcon(leftIcon);
		angleButton.setBorderPainted(false);
		angleButton.setContentAreaFilled(false);
		angleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		angleButton.setBounds(Basic.Width() - 80,
				Basic.HeadHeight() / 2 - 9, 10, 18);
		angleButton.addActionListener(this);
		add(angleButton);

		ImageIcon deleIcon = new ImageIcon(
				"resource/image/deleteButton.png");
		deleteButton = new JButton();
		deleteButton.setIcon(deleIcon);
		deleteButton.setBorderPainted(false);
		deleteButton.setContentAreaFilled(false);
		deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton.setBounds(Basic.Width() - 50,
				Basic.HeadHeight() / 2 - 10, 20, 20);
		deleteButton.addActionListener(this);
		add(deleteButton);
		
		editPanel = new EditMoviePanel();
		editPanel.setBackground(new Color(216, 216, 216));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == angleButton) {
			if (tag) {
				ImageIcon leftIcon = new ImageIcon(
						"resource/image/down.png");
				angleButton.setIcon(leftIcon);
				angleButton.setBounds(Basic.Width() - 85,
						Basic.HeadHeight() / 2 - 5, 20, 10);
				tag = false;

				ArrayList<?> array = AdminModUI.getArray();
				
				JPanel conPanel = AdminModUI.getConPane();
				editPanel.setBounds(0,
						this.getY() + Basic.HeadHeight(),
						Basic.Width(), 275);
				conPanel.add(editPanel);

				int height = Basic.HeadHeight() * array.size()
						+ editPanel.getHeight();
				if (height > Basic.Height()
						- Basic.HeadHeight() - 50) {
					conPanel.setPreferredSize(new Dimension(Basic
							.Width(), height));
				} else {
					conPanel.setPreferredSize(new Dimension(Basic
							.Width(), Basic.Height()
							- Basic.HeadHeight() - 50));
				}

				int index = array.indexOf(this);
				int number = array.size() - index > 6 ? 6 : array.size()
						- index;

				if (array.size() > 1 && index != array.size() - 1) {
					for (int i = index + 1; i < index + number; i++) {
						MovieButton movie = (MovieButton) array.get(i);
						movie.titleLabel.setVisible(false);
						movie.angleButton.setVisible(false);
						movie.deleteButton.setVisible(false);
						movie.setVisible(false);
					}
				}

				conPanel.repaint();

			} else {
				ImageIcon leftIcon = new ImageIcon(
						"resource/image/changeLeft.png");
				angleButton.setIcon(leftIcon);
				angleButton.setBounds(Basic.Width() - 80,
						Basic.HeadHeight() / 2 - 9, 10, 18);
				tag = true;
				JPanel conPanel = AdminModUI.getConPane();
				conPanel.remove(editPanel);
				ArrayList<?> array = AdminModUI.getArray();
				int index = array.indexOf(this);

				int number = array.size() - index > 6 ? 6 : array.size()
						- index;
				if (array.size() > 1 && index != array.size() - 1) {
					for (int i = index + 1; i < index + number; i++) {
						MovieButton movie = (MovieButton) array.get(i);
						movie.titleLabel.setVisible(true);
						movie.angleButton.setVisible(true);
						movie.deleteButton.setVisible(true);
						movie.setVisible(true);
					}
				}

				conPanel.repaint();
			}

		} else {
			TTNavigationController navigation = TTNavigationController
					.getInstance();
			int value = JOptionPane.showConfirmDialog(navigation, "是否删除?",
					"Option", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
			switch (value) {
			case JOptionPane.YES_OPTION:
				ArrayList<?> array = AdminModUI.getArray();
				int index = array.indexOf(this);
				if (index != -1) {
					array.remove(index);
					AdminModUI.listMovie();
				}
				break;
			case JOptionPane.NO_OPTION:
				break;
			default:
				break;
			}
		}
	}
}
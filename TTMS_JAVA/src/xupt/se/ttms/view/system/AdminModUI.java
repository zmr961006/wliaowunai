package xupt.se.ttms.view.system;

import xupt.se.ttms.view.tmpl.Basic;
import xupt.se.ttms.view.tmpl.CircleButton;
import xupt.se.ttms.view.tmpl.EditMoviePanel;
import xupt.se.ttms.view.tmpl.RoundJTextField;
import xupt.se.ttms.view.tmpl.TTNavigationController;
import xupt.se.ttms.model.Play;
import xupt.se.ttms.service.PlaySrv;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class AdminModUI extends JPanel implements ActionListener {
	private static JScrollPane scrollPanel;
	private static JPanel conPanel;
	private static ArrayList<MovieButton> movieArray;
	private CircleButton preButton;
	private CircleButton nextButton;
	private static int Height = 168;
	
	private Play play = new Play();
	private PlaySrv pser = new PlaySrv();

	public AdminModUI() {
		setLayout(null);
		initStack();

		conPanel = new JPanel();
		conPanel.setBackground(Color.WHITE);
		conPanel.setLayout(null);
		// 设置该属性，滚动条才可滚动
		conPanel.setPreferredSize(new Dimension(Basic.Width(), Basic.Height() - Basic.HeadHeight() - 50));

		scrollPanel = new JScrollPane(conPanel);
		scrollPanel.setBackground(Color.WHITE);
		scrollPanel.setBounds(0, Basic.HeadHeight() - 1, Basic.Width(), Basic.Height() - Basic.HeadHeight() - 50);
		scrollPanel.setSize(Basic.Width(), Basic.Height() - Basic.HeadHeight() - 50);
		// 去掉边框
		scrollPanel.setBorder(new LineBorder(new Color(198, 193, 193)));

		scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPanel);

		ImageIcon leftIcon = new ImageIcon("resource/image/fa-plus.png");
		CircleButton addButton = new CircleButton(null, Color.WHITE);
		addButton.setIcon(leftIcon);
		addButton.setBounds(Basic.Width() / 2 - 15, Basic.Height() - 40, 29, 29);
		add(addButton);

		ImageIcon preIcon = new ImageIcon("resource/image/circleLeft.png");
		preButton = new CircleButton(null, Color.WHITE);
		preButton.setIcon(preIcon);
		preButton.setBounds(Basic.Width() - 100, Basic.Height() - 43, 35, 35);
		preButton.addActionListener(this);
		add(preButton);

		ImageIcon nextIcon = new ImageIcon("resource/image/circleRight.png");
		nextButton = new CircleButton(null, Color.WHITE);
		nextButton.setIcon(nextIcon);
		nextButton.setBounds(Basic.Width() - 55, Basic.Height() - 43, 35, 35);
		nextButton.addActionListener(this);
		add(nextButton);

		addButton.addActionListener(this);
		
		List<Play> list = pser.FetchAll();
		for (Play play : list) {
			System.out.println(play.getimage());
			MovieButton button = new MovieButton(play.getname(), play.getlength() + "", 
					play.getprice() + "", play.getIntroduction(), play.getimage());
			button.setBackground(Color.WHITE);
			button.setBorder(BorderFactory.createLineBorder(new Color(216, 216, 216), 1));
			movieArray.add(button);
		}
		
		listMovie();
		

	}

	private static void initStack() {
		movieArray = new ArrayList<MovieButton>();
	}

	public static void listMovie() {
		conPanel.removeAll();

		for (int i = 0; i < movieArray.size(); i++) {
			MovieButton jbutton = (MovieButton) movieArray.get(i);
			jbutton.setBounds(0, Height * i, Basic.Width() - 2, Height);
			conPanel.add(jbutton);
		}
		int height = Height * movieArray.size();
		if (height > Basic.Height() - Basic.HeadHeight() - 50) {
			conPanel.setPreferredSize(new Dimension(Basic.Width(), height));
		} else {
			conPanel.setPreferredSize(new Dimension(Basic.Width(), Basic.Height() - Basic.HeadHeight() - 50));
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
			scrollPanel.getVerticalScrollBar().setValue(jspValue -= 2 * Height);
		} else if (arg0.getSource() == nextButton) {
			int jspValue = scrollPanel.getVerticalScrollBar().getValue();
			scrollPanel.getVerticalScrollBar().setValue(jspValue += 2 * Height);
		} else {
			String sa = JOptionPane.showInputDialog(null, "请输入电影名称:");
			if (sa == null) {
				return;
			} else {
				if (sa != null && sa.length() != 0 && !sa.endsWith(" ")) {
					MovieButton movieButton = new MovieButton(sa, "影片时长", "影片价格", "影片简介", "resource/image/addPhoto.png");
					movieButton.setBackground(Color.WHITE);
					movieButton.setBorder(BorderFactory.createLineBorder(new Color(216, 216, 216), 1));
					movieArray.add(movieButton);
					play.setname(sa);
					pser.add(play);
					listMovie();
				} else if (sa.length() == 0 || sa.endsWith(" ")) {
					JOptionPane.showConfirmDialog(this, "电影名称不能为空!", "Option", JOptionPane.YES_OPTION,
							JOptionPane.NO_OPTION);
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
	private RoundJTextField titleLabel;
	private RoundJTextField movieLength;
	private RoundJTextField moviePrice;
	private RoundJTextField movieUpTime;
	private RoundJTextField movieIntro;
	private JButton angleButton;
	private JButton deleteButton;
	private JButton addPhotoButton;
	private JFileChooser fileChooser = new JFileChooser();

	private String imagePath = new String();

	private Play play = new Play();
	private PlaySrv pser = new PlaySrv();

	public EditMoviePanel editPanel;
	private JButton editButton;

	public boolean tag;
	private boolean isEdit = false;
	private static int Height = 168;

	public EditMoviePanel getEditPanel() {
		return editPanel;
	}

	public void setEditPanel(EditMoviePanel editPanel) {
		this.editPanel = editPanel;
	}

	public MovieButton(String titleString, String length, String price, String info, String imPath) {
		setLayout(null);

//		ImageIcon photoIcon = new ImageIcon(imPath);
		addPhotoButton = new JButton();
//		addPhotoButton.setIcon(photoIcon);
		addPhotoButton.setBorderPainted(false);
		addPhotoButton.setContentAreaFilled(false);
		addPhotoButton.setBounds(15, 20, 83, 123);
		addPhotoButton.addActionListener(this);
		setIcon(imPath, addPhotoButton);
		add(addPhotoButton);

		tag = true;
		titleLabel = new RoundJTextField(10);
		titleLabel.setText(titleString);
		titleLabel.setForeground(Color.LIGHT_GRAY);
		titleLabel.setFont(new Font("Kaiti SC", 1, 13));
		titleLabel.setBounds(120, 20, 120, 25);
		titleLabel.setEnabled(false);
		add(titleLabel);

		movieLength = new RoundJTextField(10);
		movieLength.setBounds(120, 50, 60, 22);
		movieLength.setForeground(Color.LIGHT_GRAY);
		movieLength.setText(length);
		movieLength.setFont(new Font("Kaiti SC", 1, 11));
		movieLength.setEnabled(false);
		add(movieLength);

		moviePrice = new RoundJTextField(10);
		moviePrice.setBounds(120, 80, 60, 22);
		moviePrice.setForeground(Color.LIGHT_GRAY);
		moviePrice.setText(price);
		moviePrice.setFont(new Font("Kaiti SC", 1, 11));
		moviePrice.setEnabled(false);
		add(moviePrice);

		movieIntro = new RoundJTextField(10);
		movieIntro.setBounds(120, 110, Basic.Width() / 5 * 3, 22);
		movieIntro.setForeground(Color.LIGHT_GRAY);
		movieIntro.setText(info);
		movieIntro.setFont(new Font("Kaiti SC", 1, 11));
		movieIntro.setEnabled(false);
		add(movieIntro);

		movieUpTime = new RoundJTextField(10);
		movieUpTime.setBounds(250, 50, 60, 22);
		movieUpTime.setForeground(Color.LIGHT_GRAY);
		movieUpTime.setText("上映时间");
		movieUpTime.setFont(new Font("Kaiti SC", 1, 11));
		movieUpTime.setEnabled(false);
		add(movieUpTime);

		ImageIcon editIcon = new ImageIcon("resource/image/EditButton.png");
		editButton = new JButton();
		editButton.setIcon(editIcon);
		editButton.setBorderPainted(false);
		editButton.setContentAreaFilled(false);
		editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editButton.setBounds(Basic.Width() - 150, Height / 2 - 11, 54, 23);
		editButton.addActionListener(this);
		add(editButton);

		ImageIcon leftIcon = new ImageIcon("resource/image/changeLeft.png");
		angleButton = new JButton();
		angleButton.setIcon(leftIcon);
		angleButton.setBorderPainted(false);
		angleButton.setContentAreaFilled(false);
		angleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		angleButton.setBounds(Basic.Width() - 80, Height / 2 - 9, 10, 18);
		angleButton.addActionListener(this);
		add(angleButton);

		ImageIcon deleIcon = new ImageIcon("resource/image/deleteButton.png");
		deleteButton = new JButton();
		deleteButton.setIcon(deleIcon);
		deleteButton.setBorderPainted(false);
		deleteButton.setContentAreaFilled(false);
		deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton.setBounds(Basic.Width() - 50, Height / 2 - 10, 20, 20);
		deleteButton.addActionListener(this);
		add(deleteButton);

		editPanel = new EditMoviePanel();
		editPanel.setBackground(new Color(216, 216, 216));
		play.setname(titleString);
	}

	public void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		@SuppressWarnings("static-access")
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(), iconButton.getHeight(),
				icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == angleButton) {
			if (tag) {
				ImageIcon leftIcon = new ImageIcon("resource/image/down.png");
				angleButton.setIcon(leftIcon);
				angleButton.setBounds(Basic.Width() - 85, Height / 2 - 5, 20, 10);
				tag = false;

				ArrayList<MovieButton> array = AdminModUI.getArray();

				JPanel conPanel = AdminModUI.getConPane();
				editPanel.setBounds(0, this.getY() + Height, Basic.Width(), 275);
				conPanel.add(editPanel);

				int height = Height * array.size() + editPanel.getHeight();
				if (height > Basic.Height() - Basic.HeadHeight() - 50) {
					conPanel.setPreferredSize(new Dimension(Basic.Width(), height));
				} else {
					conPanel.setPreferredSize(new Dimension(Basic.Width(), Basic.Height() - Basic.HeadHeight() - 50));
				}

				int index = array.indexOf(this);

				if (array.size() > 1 && index != array.size() - 1) {
					for (int i = index + 1; i <= index + 3 && i < array.size(); i++) {
						MovieButton movie = array.get(i);
						movie.addPhotoButton.setVisible(false);
						movie.titleLabel.setVisible(false);
						movie.angleButton.setVisible(false);
						movie.deleteButton.setVisible(false);
						movie.setVisible(false);
					}
				}

				conPanel.repaint();

			} else {
				ImageIcon leftIcon = new ImageIcon("resource/image/changeLeft.png");
				angleButton.setIcon(leftIcon);
				angleButton.setBounds(Basic.Width() - 80, Height / 2 - 9, 10, 18);
				tag = true;
				JPanel conPanel = AdminModUI.getConPane();
				conPanel.remove(editPanel);
				ArrayList<MovieButton> array = AdminModUI.getArray();
				int height = Height * array.size();
				if (height > Basic.Height() - Basic.HeadHeight() - 50) {
					conPanel.setPreferredSize(new Dimension(Basic.Width(), height));
				} else {
					conPanel.setPreferredSize(new Dimension(Basic.Width(), Basic.Height() - Basic.HeadHeight() - 50));
				}

				int index = array.indexOf(this);

				if (array.size() > 1 && index != array.size() - 1) {
					for (int i = index + 1; i <= index + 3 && i < array.size(); i++) {
						MovieButton movie = array.get(i);
						movie.addPhotoButton.setVisible(true);
						movie.titleLabel.setVisible(true);
						movie.angleButton.setVisible(true);
						movie.deleteButton.setVisible(true);
						movie.setVisible(true);
					}
				}

				conPanel.repaint();
			}

		} else if (e.getSource() == addPhotoButton) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Allowed File", "jpg", "png");
			fileChooser.setFileFilter(filter);
			if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				setIcon(fileChooser.getSelectedFile().getAbsolutePath().toString(), addPhotoButton);
				imagePath = fileChooser.getSelectedFile().getAbsolutePath().toString();
			}

		} else if (e.getSource() == editButton) {
			if (isEdit == false) {
				ImageIcon editIcon = new ImageIcon("resource/image/OverButton.png");
				editButton.setIcon(editIcon);
				titleLabel.setEnabled(true);
				movieLength.setEnabled(true);
				moviePrice.setEnabled(true);
				movieIntro.setEnabled(true);
				movieUpTime.setEnabled(true);
				isEdit = true;
			} else {
				ImageIcon editIcon = new ImageIcon("resource/image/EditButton.png");
				editButton.setIcon(editIcon);
				titleLabel.setEnabled(false);
				movieLength.setEnabled(false);
				moviePrice.setEnabled(false);
				movieIntro.setEnabled(false);
				movieUpTime.setEnabled(false);
				isEdit = false;
				play.setname(titleLabel.getText());
				play.setlength(Integer.valueOf(movieLength.getText()));
				play.setprice(Double.valueOf(moviePrice.getText()));
				play.setIntroduction(movieIntro.getText());
				play.setimage(imagePath);
				play.setID(pser.getId(play));
				pser.modify(play);
			}
		} else {
			TTNavigationController navigation = TTNavigationController.getInstance();
			int value = JOptionPane.showConfirmDialog(navigation, "是否删除?", "Option", JOptionPane.YES_OPTION,
					JOptionPane.NO_OPTION);
			switch (value) {
			case JOptionPane.YES_OPTION:
				ArrayList<MovieButton> array = AdminModUI.getArray();
				int index = array.indexOf(this);
				if (index != -1) {
					pser.delete(pser.getId(play));
					
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
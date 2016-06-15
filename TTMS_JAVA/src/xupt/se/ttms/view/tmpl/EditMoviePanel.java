package xupt.se.ttms.view.tmpl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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

import xupt.se.ttms.view.tmpl.Basic;
@SuppressWarnings("serial")
public class EditMoviePanel extends JPanel implements ActionListener {
	private CircleButton preButton;
	private CircleButton nextButton;
	private JScrollPane ediScrollPanel;
	private JPanel ediConPanel;
	private ArrayList<EditMovieButton> editMovieArray;

	public EditMoviePanel() {
		setLayout(null);

		editMovieArray = new ArrayList<EditMovieButton>();

		initButton();
		initScrollPanel();
	}

	private void initButton() {

		ImageIcon addIcon = new ImageIcon(
				"resource/image/plus.png");
		CircleButton addMovieButton = new CircleButton(null, new Color(216,
				216, 216));
		addMovieButton.setIcon(addIcon);
		addMovieButton.setBounds(Basic.Width() / 2 - 15, 275 - 35, 29,
				29);
		addMovieButton.addActionListener(this);
		add(addMovieButton);

	}

	private void initScrollPanel() {
		ediConPanel = new JPanel();
		ediConPanel.setBackground(new Color(216, 216, 216));
		ediConPanel.setLayout(null);
		// 设置该属性，滚动条才可滚动
		ediConPanel.setPreferredSize(new Dimension(Basic.Width(),
				275 - 40));

		ediScrollPanel = new JScrollPane(ediConPanel);
		ediScrollPanel.setBackground(new Color(216, 216, 216));
		ediScrollPanel.setBounds(0, 0, Basic.Width(), 275 - 40);
		// 去掉边框
		ediScrollPanel.setBorder(new LineBorder(new Color(198, 193, 193)));

		ediScrollPanel
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		ediScrollPanel
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(ediScrollPanel);

		listMovie();

		ImageIcon preIcon = new ImageIcon(
				"resource/image/leftIcon.png");
		preButton = new CircleButton(null, new Color(216, 216, 216));
		preButton.setIcon(preIcon);
		preButton.setBounds(Basic.Width() - 100, 275 - 35, 30, 30);
		preButton.addActionListener(this);
		add(preButton);

		ImageIcon nextIcon = new ImageIcon(
				"resource/image/nextIcon.png");
		nextButton = new CircleButton(null, new Color(216, 216, 216));
		nextButton.setIcon(nextIcon);
		nextButton.setBounds(Basic.Width() - 55, 275 - 35, 30, 30);
		nextButton.addActionListener(this);
		add(nextButton);
	}

	public void listMovie() {
		ediConPanel.removeAll();

		for (int i = 0; i < editMovieArray.size(); i++) {
			EditMovieButton ediButton = editMovieArray.get(i);
			ediButton.setBounds(0, 51 * i, Basic.Width(), 51);
			ediConPanel.add(ediButton);
		}
		int height = 51 * editMovieArray.size();
		if (height > 275 - 40) {
			ediConPanel.setPreferredSize(new Dimension(Basic.Width(),
					height));
		} else {
			ediConPanel.setPreferredSize(new Dimension(Basic.Width(),
					275 - 40));
		}

		ediConPanel.repaint();
	}

	public ArrayList<EditMovieButton> getMovieArray() {
		return editMovieArray;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == preButton) {
			int jValue = ediScrollPanel.getVerticalScrollBar().getValue();
			ediScrollPanel.getVerticalScrollBar().setValue(jValue -= 55);
		} else if (arg0.getSource() == nextButton) {
			int jValue = ediScrollPanel.getVerticalScrollBar().getValue();
			ediScrollPanel.getVerticalScrollBar().setValue(jValue += 55);
		} else {
			EditMovieButton movieButton = new EditMovieButton(this);
			movieButton.setBackground(Color.WHITE);
			movieButton.setBorder(BorderFactory.createLineBorder(new Color(216,
					216, 216), 1));
			editMovieArray.add(movieButton);
			listMovie();
		}
	}

	public void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		@SuppressWarnings("static-access")
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
}

@SuppressWarnings("serial")
class EditMovieButton extends JPanel implements ActionListener {
	private JButton editButton;
	private JButton deleteButton;
	private boolean tag = false;
	private RoundJTextField timer;
	private RoundJTextField type;
	private RoundJTextField room;
	private JLabel overTime;
	private EditMoviePanel mainPanel;

	public EditMovieButton(EditMoviePanel mainPanel) {
		setLayout(null);

		this.mainPanel = mainPanel;

		ImageIcon editIcon = new ImageIcon(
				"resource/image/EditButton.png");
		editButton = new JButton();
		editButton.setIcon(editIcon);
		editButton.setBorderPainted(false);
		editButton.setContentAreaFilled(false);
		editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editButton.setBounds(Basic.Width() - 130, 51 / 2 - 11, 54, 23);
		editButton.addActionListener(this);
		add(editButton);

		ImageIcon deleIcon = new ImageIcon(
				"resource/image/deleteButton.png");
		deleteButton = new JButton();
		deleteButton.setIcon(deleIcon);
		deleteButton.setBorderPainted(false);
		deleteButton.setContentAreaFilled(false);
		deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton
				.setBounds(Basic.Width() - 40, 51 / 2 - 10, 20, 20);
		deleteButton.addActionListener(this);
		add(deleteButton);

		timer = new RoundJTextField(10);
		timer.setBounds(20, 51 / 2 - 11, 55, 22);
		timer.setForeground(Color.LIGHT_GRAY);
		timer.setText("开始时间");
		timer.setFont(new Font("Kaiti SC", 1, 10));
		timer.setEnabled(false);
		add(timer);

		overTime = new JLabel("结束时间");
		overTime.setBounds(100, 51 / 2 - 11, 55, 22);
		overTime.setForeground(Color.GRAY);
		overTime.setFont(new Font("Kaiti SC", 1, 10));
		add(overTime);

		type = new RoundJTextField(10);
		type.setBounds(190, 51 / 2 - 11, 60, 22);
		type.setForeground(Color.LIGHT_GRAY);
		type.setText("电影类型");
		type.setFont(new Font("Kaiti SC", 1, 10));
		type.setEnabled(false);
		add(type);

		room = new RoundJTextField(10);
		room.setBounds(270, 51 / 2 - 11, 55, 22);
		room.setForeground(Color.LIGHT_GRAY);
		room.setText("电影厅");
		room.setFont(new Font("Kaiti SC", 1, 10));
		room.setEnabled(false);
		add(room);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == deleteButton) {
			TTNavigationController navigation = TTNavigationController
					.getInstance();
			int value = JOptionPane.showConfirmDialog(navigation, "是否删除?",
					"Option", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
			switch (value) {
			case JOptionPane.YES_OPTION:
				ArrayList<EditMovieButton> array = this.mainPanel
						.getMovieArray();
				int index = array.indexOf(this);
				if (index != -1) {
					array.remove(index);
					this.mainPanel.listMovie();
				}
				break;
			case JOptionPane.NO_OPTION:
				break;
			default:
				break;
			}
		} else if (arg0.getSource() == editButton) {
			if (tag == false) {
				ImageIcon editIcon = new ImageIcon(
						"resource/image/OverButton.png");
				editButton.setIcon(editIcon);
				timer.setEnabled(true);
				type.setEnabled(true);
				room.setEnabled(true);
				tag = true;
			} else {
				ImageIcon editIcon = new ImageIcon(
						"resource/image/EditButton.png");
				editButton.setIcon(editIcon);
				timer.setEnabled(false);
				type.setEnabled(false);
				room.setEnabled(false);
				tag = false;
			}
		}
	}
}
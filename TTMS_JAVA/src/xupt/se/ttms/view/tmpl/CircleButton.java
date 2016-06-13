package xupt.se.ttms.view.tmpl;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class CircleButton extends JButton {
	Shape shape;
	Color bgColor = SystemColor.control;

	public CircleButton() {
		this("未命名", null);
	}

	public CircleButton(String label) {
		this(label, null);
	}

	public CircleButton(String label, Color bgColor) {
		super(label); // 调用父类构造方法
		if (bgColor != null) {
			this.bgColor = bgColor;
		}
		Dimension size = this.getPreferredSize();
		this.setPreferredSize(size); // 设置宽高等距
		this.setContentAreaFilled(false); // 不绘制内容区域
		this.setBorderPainted(false); // 不绘制边框
		this.setFocusPainted(false); // 不绘制焦点状态
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// 如果鼠标按下，isArmed()方法返回true
		if (this.getModel().isArmed()) {
			g2d.setColor(this.bgColor);
		} else {
			g2d.setColor(this.bgColor);
			g.setColor(this.bgColor); // 设置背景颜色
		}
		g2d.fillOval(0, 0, this.getWidth(), this.getHeight()); // 绘制圆形背景区域
//		g2d.setColor(Color.GRAY); // 设置边框颜色
//		g2d.drawOval(0, 0, this.getWidth() - 1 , this.getHeight() - 1); // 绘制边框线
		super.paintComponent(g2d);
	}

	public boolean contains(int x, int y) {
		if ((shape == null) || (!shape.getBounds().equals(this.getBounds()))) {
			this.shape = new Ellipse2D.Float(0, 0, this.getWidth(),
					this.getHeight());
		}
		return shape.contains(x, y);
	}
}
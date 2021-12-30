package hw;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreGraph extends JFrame {

	private JTextField text1;
	private JTextField text2;
	private JTextField text3;

	private DrawingCanvas canvas;

	public ScoreGraph() {
		super("���� ����ǥ");

		buildGUI();

		setLocation(500, 200);
		setSize(400, 350);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void buildGUI() {
		canvas = new DrawingCanvas();
		add(canvas);

		add(createBtnPanel(), BorderLayout.SOUTH);
	}

	private JPanel createBtnPanel() {
		JPanel panel = new JPanel();
		text1 = new JTextField(3);
		text2 = new JTextField(3);
		text3 = new JTextField(3);

		panel.add(new JLabel("����"));
		panel.add(text1);

		panel.add(new JLabel("����"));
		panel.add(text2);

		panel.add(new JLabel("����"));
		panel.add(text3);

		JButton button = new JButton("�׷��� �׸���");
		panel.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int korean = Integer.parseInt(text1.getText());
					int english = Integer.parseInt(text2.getText());
					int math = Integer.parseInt(text3.getText());

					// �׷��� ĵ������ ���� ����
					canvas.setScores(korean, english, math);
					// �׷��� ĵ���� ����
					canvas.repaint();
				}
				catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(ScoreGraph.this, "�߸��� ���� �����Դϴ�,", "���� �޽���", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		return panel;

	}

	public static void main(String[] args) {
		new ScoreGraph();
	}

}

class DrawingCanvas extends JComponent {

	private final int BLANK = 40;
	private int width, height;
	private int newW, newH;
	private int distanceH, distanceW;
	private int originX, originY;
	int korean, english, math;

	public void paint(Graphics g) {
		// ȭ�� �����
		this.removeAll();

		// ��ǥ �׸���
		width = this.getWidth();
		height = this.getHeight();
		
		newW = width - BLANK * 2;
		newH = height - BLANK * 2;
		
		distanceW = newW / 4;
		distanceH = newH / 11;

		originX = BLANK;
		originY = height - BLANK;
		
		g.setColor(Color.BLACK);
		g.drawLine(originX, originY, originX, originY - newH);
		g.drawLine(originX, originY, originX + newW, originY);
		g.drawString("����", originX + distanceW, originY + 25);
		g.drawString("����", originX + distanceW * 2, originY + 25);
		g.drawString("����", originX + distanceW * 3, originY + 25);
		
		for(int i = 0; i < 10; i++) {
			g.drawString(String.valueOf((i + 1) * 10), originX - 25, originY - distanceH);
			g.drawLine(originX, originY - distanceH, originX + newW, originY - distanceH);
			originY -= distanceH;
		}

		// �� ������ ����׷��� �׸���
		g.setColor(Color.RED);
		g.fillRect(originX + distanceW, originY + (newH - korean / 10 * distanceH) - 25, 20, korean / 10 * distanceH);
		g.fillRect(originX + distanceW * 2, originY + (newH - english / 10 * distanceH) - 25, 20, english / 10 * distanceH);
		g.fillRect(originX + distanceW * 3, originY + (newH - math / 10 * distanceH) - 25, 20, math / 10 * distanceH);
		
	}

	void setScores(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
}

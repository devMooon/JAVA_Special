import javax.swing.*;
import java.awt.*;

public class ToolBarEx extends JFrame {

	ToolBarEx() {
		super("���� ����� ����");

		createToolBar();

		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void createToolBar() {
		// ���� ����
		JToolBar toolBar = new JToolBar("My ToolBar");
		toolBar.setBackground(Color.ORANGE);

		// ���ٿ� �޴��� ����� ������Ʈ�� ����
		JButton btn = new JButton("New");
		btn.setToolTipText("Test");

		JComboBox combo = new JComboBox();
		combo.addItem("Java");
		combo.addItem("C");
		combo.addItem("C++");
		
		toolBar.add(btn);
		toolBar.addSeparator();
		toolBar.add(new JLabel("search"));
		toolBar.add(new JTextField());
		toolBar.add(combo);

		// ���ٸ� ����Ʈ���� NORTH�� �����Ѵ�.
		this.add(toolBar, BorderLayout.NORTH);
	}

	public static void main(String [] args) {
		new ToolBarEx();
	}
}

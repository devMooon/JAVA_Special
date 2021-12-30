package hw;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class PhoneBookFrame extends JFrame {
	private JLabel numOfData;
	private JTable mTable;
	private JButton b_del, b_befoer, b_after;
	
	
	private JToggleButton generalButton, universityButton, companyButton;
	private JButton inputButton, resetButton;
	private JTextField nameField, phoneNumField, birthDayField;
	private JTextField majorField, gradeField;
	private JTextField companyField;
	
	private JPanel additionalFormPanel;
	private CardLayout cardLayout;

	public PhoneBookFrame(PhoneBookModel pbModel) {
		super("PhoneBook");
		
		buildGUI();
		registerEvent();
		
		this.setSize(670, 420);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		this.setLayout(new BorderLayout());
		
		numOfData = new JLabel("Test");
		this.add(getCenterPanel(), BorderLayout.CENTER);
		this.add(numOfData, BorderLayout.SOUTH);
	}
	
	private JPanel getCenterPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(getInfoPanel(), BorderLayout.WEST);
		panel.add(getTablePanel(), BorderLayout.CENTER);
		
		return panel;
	}

	private JPanel getInfoPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(createTopButtonPanel(), BorderLayout.NORTH);
		panel.add(createCenterPanel(), BorderLayout.CENTER);
		panel.add(createBottomButtonPanel(), BorderLayout.SOUTH);
		
		return panel;
	}
	
	private JPanel createTopButtonPanel() {
		JPanel panel = new JPanel();
		
		generalButton = new JToggleButton("�Ϲ�");
		generalButton.setSelected(true);
		universityButton = new JToggleButton("����");
		companyButton = new JToggleButton("ȸ��");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(generalButton);
		buttonGroup.add(universityButton);
		buttonGroup.add(companyButton);
		
		panel.add(generalButton);
		panel.add(universityButton);
		panel.add(companyButton);
		
		return panel;
	}
	
	private JPanel createCenterPanel() {
		JPanel panel = new JPanel();
		
		panel.add(createForm());
		
		return panel;
	}
	
	private JPanel createBottomButtonPanel() {
		JPanel panel = new JPanel();
		
		inputButton = new JButton("�Է�");
		resetButton = new JButton("�ʱ�ȭ");
		
		panel.add(inputButton);
		panel.add(resetButton);
		
		return panel;
	}
	
	private JPanel createForm() {
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(createDefaultForm(), BorderLayout.CENTER);
		panel.add(createAdditionalForm(), BorderLayout.SOUTH);
		
		return panel;
		
	}
	
	private JPanel createDefaultForm() {
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		JPanel p_name = new JPanel();
		JPanel p_phoneNum = new JPanel();
		JPanel p_birthDay = new JPanel();
		
		nameField = new JTextField(10);
		phoneNumField = new JTextField(10);
		birthDayField = new JTextField(10);
		
		p_name.add(new JLabel("��        ��"));
		p_name.add(nameField);
		
		p_phoneNum.add(new JLabel("��ȭ��ȣ"));
		p_phoneNum.add(phoneNumField);
		
		p_birthDay.add(new JLabel("�������"));
		p_birthDay.add(birthDayField);
		
		panel.add(p_name);
		panel.add(p_phoneNum);
		panel.add(p_birthDay);
		
		return panel;
	}
	
	private JPanel createAdditionalForm() {
		cardLayout = new CardLayout();
		
		additionalFormPanel = new JPanel();
		additionalFormPanel.setLayout(cardLayout);
		
		JPanel p_general = new JPanel(new GridLayout(0, 1));
		JPanel p_university = new JPanel(new GridLayout(0, 1));
		JPanel p_company = new JPanel(new GridLayout(0, 1));
		
		JPanel p_p_university_1 = new JPanel();
		JPanel p_p_university_2 = new JPanel();
		JPanel p_p_company = new JPanel();
		
		majorField = new JTextField(10);
		gradeField = new JTextField(10);
		
		companyField = new JTextField(10);
		
		
		p_p_university_1.add(new JLabel("��        ��"));
		p_p_university_1.add(majorField);
		p_p_university_2.add(new JLabel("��        ��"));
		p_p_university_2.add(gradeField);
		
		p_p_company.add(new JLabel("ȸ        ��"));
		p_p_company.add(companyField);

		p_university.add(p_p_university_1);
		p_university.add(p_p_university_2);
		p_company.add(p_p_company);
		
		additionalFormPanel.add("�Ϲ�", p_general);
		additionalFormPanel.add("����", p_university);
		additionalFormPanel.add("ȸ��", p_company);
		
		//Default�� ���� ���� �߰��� "general"�� ó���� ����.
		//cardLayout.show(additionalFormPanel, "general");
		
		return additionalFormPanel;
	}
	
	private void registerEvent() {
		ActionListener handler = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(additionalFormPanel, e.getActionCommand());
				
			}
			
		};
		
		generalButton.addActionListener(handler);
		universityButton.addActionListener(handler);
		companyButton.addActionListener(handler);
		
		inputButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(additionalFormPanel, "�Ϲ�");
				generalButton.setSelected(true);
				
				nameField.setText("");
				phoneNumField.setText("");
				birthDayField.setText("");				
				
			}
		});
	}
	
	private JPanel getTablePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel btnPanel = new JPanel(new FlowLayout());
		
		b_befoer = new JButton("<<");
		b_del = new JButton("����");
		b_after = new JButton(">>");
		
		btnPanel.add(b_befoer);
		btnPanel.add(b_del);
		btnPanel.add(b_after);
		
		String[] columnNames = { "�̸�", "�������", "��ȭ��ȣ", "���" };
		
		Object[][] data = {
				{ "ȫ�浿", 1990, "010-1234-1234", "" },
				{ "ȫ�浿", 1990, "010-1234-1234", "" },
				{ "ȫ�浿", 1990, "010-1234-1234", "" },
		};
		
		mTable = new JTable(data, columnNames);
		mTable.setRowHeight(30);
		
		panel.add(btnPanel, BorderLayout.NORTH);
		panel.add(new JScrollPane(mTable), BorderLayout.CENTER);
		
		return panel;
	}
}



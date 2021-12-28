package hw;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class PhoneBookFrame extends JFrame {
	private JToggleButton generalButton, universityButton, companyButton;
	
	private JButton inputButton, resetButton;
	
	private JTextField nameField, phoneNumField, birthDayField;
	
	private JTextField majorField, gradeField;

	private JTextField companyField;
	
	private JPanel additionalFormPanel;
	private CardLayout cardLayout;
	

	public PhoneBookFrame() 
	{
		super("PhoneBook");
		
		buildGUI();
		registerEvent();
		
		this.setSize(250, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	private void buildGUI() 
	{
		this.add(getInfoPanel());
	}


	private JPanel getInfoPanel()
	{
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(createTopButtonPanel(), BorderLayout.NORTH);
		panel.add(createCenterPanel(), BorderLayout.CENTER);
		panel.add(createBottomButtonPanel(), BorderLayout.SOUTH);
		
		return panel;
	}
	
	
	private JPanel createTopButtonPanel()
	{
		JPanel panel = new JPanel();
		
		generalButton = new JToggleButton("일반");
		generalButton.setSelected(true);
		universityButton = new JToggleButton("대학");
		companyButton = new JToggleButton("회사");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(generalButton);
		buttonGroup.add(universityButton);
		buttonGroup.add(companyButton);
		
		panel.add(generalButton);
		panel.add(universityButton);
		panel.add(companyButton);
		
		return panel;
	}
	private JPanel createCenterPanel()
	{
		JPanel panel = new JPanel();
		
		panel.add(createForm());
		
		return panel;
	}
	private JPanel createBottomButtonPanel()
	{
		JPanel panel = new JPanel();
		
		inputButton = new JButton("입력");
		resetButton = new JButton("초기화");
		
		panel.add(inputButton);
		panel.add(resetButton);
		
		return panel;
	}
	
	
	private JPanel createForm()
	{
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(createDefaultForm(), BorderLayout.CENTER);
		panel.add(createAdditionalForm(), BorderLayout.SOUTH);
		
		return panel;
		
	}
	private JPanel createDefaultForm()
	{
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		JPanel p_name = new JPanel();
		JPanel p_phoneNum = new JPanel();
		JPanel p_birthDay = new JPanel();
		
		nameField = new JTextField(10);
		phoneNumField = new JTextField(10);
		birthDayField = new JTextField(10);
		
		p_name.add(new JLabel("이        름"));
		p_name.add(nameField);
		
		p_phoneNum.add(new JLabel("전화번호"));
		p_phoneNum.add(phoneNumField);
		
		p_birthDay.add(new JLabel("생년월일"));
		p_birthDay.add(birthDayField);
		
		panel.add(p_name);
		panel.add(p_phoneNum);
		panel.add(p_birthDay);
		
		return panel;
	}
	private JPanel createAdditionalForm()
	{
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
		
		
		p_p_university_1.add(new JLabel("전        공"));
		p_p_university_1.add(majorField);
		p_p_university_2.add(new JLabel("학        년"));
		p_p_university_2.add(gradeField);
		
		p_p_company.add(new JLabel("회        사"));
		p_p_company.add(companyField);

		p_university.add(p_p_university_1);
		p_university.add(p_p_university_2);
		p_company.add(p_p_company);
		
		additionalFormPanel.add("일반", p_general);
		additionalFormPanel.add("대학", p_university);
		additionalFormPanel.add("회사", p_company);
		
		//Default로 제일 먼저 추가한 "general"이 처음에 보임.
		//cardLayout.show(additionalFormPanel, "general");
		
		return additionalFormPanel;
	}
	
	
	private void registerEvent()
	{
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
				cardLayout.show(additionalFormPanel, "일반");
				generalButton.setSelected(true);
				
				nameField.setText("");
				phoneNumField.setText("");
				birthDayField.setText("");				
				
			}
		});
	}
}

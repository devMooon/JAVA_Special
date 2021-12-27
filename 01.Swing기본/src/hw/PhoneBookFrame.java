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
	//JToggleButton
	private JToggleButton generalButton;
	private JToggleButton universityButton;
	private JToggleButton companyButton;
	
	//JButton
	private JButton inputButton;
	private JButton resetButton;
	
	//JTextField
	private JTextField nameField;
	private JTextField phoneNumField;
	private JTextField birthDayField;
	
	//Additional JTextField
	private JTextField majorField;
	private JTextField gradeField;
	
	private JTextField companyField;
	
	//CardLayout
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
		this.setLayout(new BorderLayout());
		
		this.add(createTopButtonPanel(), BorderLayout.NORTH);
		this.add(createCenterPanel(), BorderLayout.CENTER);
		this.add(createBottomButtonPanel(), BorderLayout.SOUTH);
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
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
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
		JPanel panel = new JPanel(new GridLayout(3, 1));
		
		panel.add(createNameForm());
		panel.add(createPhoneNumForm());
		panel.add(createBirthDayForm());
		
		return panel;
	}
	private JPanel createAdditionalForm()
	{
		cardLayout = new CardLayout();
		
		additionalFormPanel = new JPanel();
		additionalFormPanel.setLayout(cardLayout);
		
		additionalFormPanel.add("general", generalPanel());
		additionalFormPanel.add("university", universityPanel());
		additionalFormPanel.add("company", companyPanel());
		
		cardLayout.show(additionalFormPanel, "general");
		
		return additionalFormPanel;
	}
	
	
	
	private JPanel createNameForm()
	{
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("이        름");
		nameField = new JTextField(10);
		
		panel.add(label);
		panel.add(nameField);
		
		return panel;
	}
	private JPanel createPhoneNumForm()
	{
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("전화번호");
		phoneNumField = new JTextField(10);
		
		panel.add(label);
		panel.add(phoneNumField);
		
		return panel;
	}
	private JPanel createBirthDayForm()
	{
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("생년월일");
		birthDayField = new JTextField(10);
		
		panel.add(label);
		panel.add(birthDayField);
		
		return panel;
	}
	
	
	
	private JPanel generalPanel()
	{
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
		return panel;
	}
	private JPanel universityPanel()
	{
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
		panel.add(createMajorForm());
		panel.add(createGradeForm());
		
		return panel;
	}
	private JPanel companyPanel()
	{
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
		panel.add(createCompanyForm());
		
		return panel;
	}
	
	
	
	private JPanel createMajorForm()
	{
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("전        공");
		majorField = new JTextField(10);
		
		panel.add(label);
		panel.add(majorField);
		
		return panel;
	}
	private JPanel createGradeForm()
	{
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("학        년");
		gradeField = new JTextField(10);
		
		panel.add(label);
		panel.add(gradeField);
		
		return panel;
	}
	private JPanel createCompanyForm()
	{
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("회        사");
		companyField = new JTextField(10);
		
		panel.add(label);
		panel.add(companyField);
		
		return panel;
	}
	
	private void registerEvent()
	{
		generalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(additionalFormPanel, "general");
				
			}
		});
		universityButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(additionalFormPanel, "university");
				
			}
		});
		companyButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(additionalFormPanel, "company");
				
			}
		});
		
		inputButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(additionalFormPanel, "general");
				generalButton.setSelected(true);
				
				nameField.setText("");
				phoneNumField.setText("");
				birthDayField.setText("");				
				
			}
		});
	}
}

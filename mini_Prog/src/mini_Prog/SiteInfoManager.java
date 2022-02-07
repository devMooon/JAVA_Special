package mini_Prog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class SiteInfoManager extends JFrame {
	SiteInfoList infoList;
	SiteCategoryList categoryList;
	
	JMenuItem getExcelMenu = new JMenuItem("���� ���Ͽ��� ��������(I)");
	JMenuItem setExcelMenu = new JMenuItem("���� ���Ϸ� ��������(E)");
	JMenuItem saveMenu = new JMenuItem("����(S)");
	JMenuItem logOutMenu = new JMenuItem("�α׾ƿ�(O)");
	JMenuItem exitMenu = new JMenuItem("����(X)");
	
	JMenuItem userMenu = new JMenuItem("�����(U)");
	JMenuItem siteMenu = new JMenuItem("����Ʈ �з�(C)");
	
	JCheckBoxMenuItem autoLoginMenu = new JCheckBoxMenuItem("�ڵ� �α���(L)");
	JCheckBoxMenuItem rememberMenu = new JCheckBoxMenuItem("�������� ���� ���� ����ϱ�(V)");
	
	Vector<String> classification = new Vector<String>();
	Vector<String> preference = new Vector<String>();
	
	public SiteInfoManager(){
		super("�����̰� ���� ���ͳ� ��������");
		
		SettingMenu();
		this.setJMenuBar(createMenu());
		this.add(createInputModifyPanel(), BorderLayout.WEST);
		
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void SettingMenu() {
		getExcelMenu.setEnabled(false);
		setExcelMenu.setEnabled(false);
		userMenu.setEnabled(false);
		
		//�̺�Ʈ ������ �߰�
	}
	private JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("����(F)");
		JMenu managementMenu = new JMenu("����(M)");
		JMenu settingMenu = new JMenu("����(S)");

		fileMenu.add(getExcelMenu);
		fileMenu.add(setExcelMenu);
		fileMenu.add(saveMenu);
		fileMenu.addSeparator();
		fileMenu.add(logOutMenu);
		fileMenu.add(exitMenu);
		
		managementMenu.add(userMenu);
		managementMenu.add(siteMenu);
		
		settingMenu.add(autoLoginMenu);
		settingMenu.add(rememberMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(managementMenu);
		menuBar.add(settingMenu);
		
		return menuBar;
	}
	private JPanel createInputModifyPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 1));
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("�Է�/����");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		panel.add(createBasicInformation());
		panel.add(createAddInformation());
		return panel;
		
	}
	private JPanel createBasicInformation() {
		JPanel panel = new JPanel(new GridLayout(4, 1));
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("�⺻ ����");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		panel.add(createFlowLayoutPanel("����Ʈ��", new JTextField(20)));
		JTextField textField = new JTextField(14);
		textField.setEditable(false);
		panel.add(createFlowLayoutPanel("�ּ�(URL)  http://", textField));
		panel.add(createFlowLayoutPanel("��  ��  ��", new JTextField(10)));
		panel.add(createFlowLayoutPanel("��й�ȣ", new JTextField(10)));
	
		return panel;
	}
	private JPanel createAddInformation() {
		JPanel panel = new JPanel(new GridLayout(4, 1));
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("�⺻ ����");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		classification.add("�Ϲ�");
		classification.add("�з�");
		preference.add("�١١١١�");
		preference.add("�١١١�");
		preference.add("�١١�");
		preference.add("�١�");
		preference.add("��");
		
		panel.add(createFlowLayoutPanel("��        ��", new JComboBox<String>(classification)));
		panel.add(createFlowLayoutPanel("��  ȣ  ��", new JComboBox<String>(preference)));
		panel.add(createFlowLayoutPanel("��        ��", new JTextArea(1, 20)));
	
		return panel;
	}
	private JPanel createFlowLayoutPanel(String string, Component component) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(new JLabel(string));
		panel.add(component);
		
		return panel;
	}
}

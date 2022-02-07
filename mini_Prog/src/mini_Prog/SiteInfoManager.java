package mini_Prog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
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
	
	Vector<String> searchClassification = new Vector<String>();
	
	Vector<String> sortClassification = new Vector<String>();
	Vector<String> sortURL = new Vector<String>();
	
	String tableHeader[] = {"�з�", "��ȣ��", "����Ʈ �̸�", "����Ʈ �ּ�"};
	String tableContents[][] = {
			{"�Ϲ�", "�١١١١�", "�������", "sarammani.com"},
			{"�б�", "�١�", "�������ڴ��б�", "www.duksungac.kr"}
	};
	
	public SiteInfoManager(){
		super("�����̰� ���� ���ͳ� ��������");
		
		SettingMenu();
		this.setJMenuBar(createMenu());
		this.add(createInputModifyPanel(), BorderLayout.WEST);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		panel.add(new JLabel("2���� ����Ʈ�� ��ϵǾ� �ֽ��ϴ�."));
		this.add(panel, BorderLayout.SOUTH);
		
		this.add(createTabbedPane());
		
		this.setSize(800, 600);
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
		panel.add(createButtons());
		
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
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("�߰� ����");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		JPanel panel2 = new JPanel(new GridLayout(2, 1));
		
		classification.add("�Ϲ�");
		classification.add("�з�");
		preference.add("�١١١١�");
		preference.add("�١١١�");
		preference.add("�١١�");
		preference.add("�١�");
		preference.add("��");
		
		panel2.add(createFlowLayoutPanel("��        ��", new JComboBox<String>(classification)));
		panel2.add(createFlowLayoutPanel("��  ȣ  ��", new JComboBox<String>(preference)));
		
		panel.add(panel2);
		panel.add(createFlowLayoutPanel("��        ��", new JTextArea(3, 20)));
	
		return panel;
	}
	private JPanel createFlowLayoutPanel(String string, Component component) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(new JLabel(string));
		panel.add(component);
		
		return panel;
	}
	private JPanel createButtons() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton newButton = new JButton("���� �ۼ�(N)");
		JButton editButton = new JButton("����(E)");
		
		newButton.setEnabled(false);
		
		panel.add(newButton);
		panel.add(editButton);
		
		return panel;
	}
	private JTabbedPane createTabbedPane() {
		JPanel panel = new JPanel();
		
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("����Ʈ ���", sitelist());
		pane.addTab("�����Ȳ", sitelist());
		
		return pane;
	}
	private JPanel sitelist() {
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel panel2 = new JPanel(new BorderLayout());
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("�˻�/����");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel2.setBorder(borderFactory);
		
		panel2.add(createSearchSort(), BorderLayout.NORTH);
		panel2.add(createTable());
		
		panel.add(panel2);
		panel.add(createSouth(), BorderLayout.SOUTH);
		
		return panel;
	}
	private JPanel createSearchSort() {
		JPanel panel = new JPanel(new FlowLayout());
		
		panel.add(createSearch());
		panel.add(createSort());
		
		return panel;
	}
	private JPanel createSearch() {
		JPanel panel = new JPanel(new FlowLayout());
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("�˻�");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		searchClassification.add("��ü");
		searchClassification.addAll(classification);
		
		panel.add(new JComboBox<String>(searchClassification));
		panel.add(new JLabel(" ����: "));
		panel.add(new JTextField(5));
		
		return panel;
	}
	private JPanel createSort() {
		JPanel panel = new JPanel(new FlowLayout());
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("����");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		sortClassification.add("�з�");
		sortClassification.addAll(classification);
		sortURL.add("����Ʈ �̸�");
		
		//�з���� ������ �޺��ڽ��� ��������
		//�޺��ڽ� ũ�� ����
		panel.add(new JComboBox<String>(sortClassification));
		panel.add(new JComboBox<String>(sortURL));
		panel.add(new JButton("����"));
		panel.add(new JButton("�⺻"));
		
		return panel;
	}
	private JPanel createTable() {
		JPanel panel = new JPanel();
		
		//�� ������ ����
		//�з��� ����
		//�˻�, ���İ� ������...
		
		JTable table = new JTable(tableContents, tableHeader);
		panel.add(new JScrollPane(table));
		
		return panel;
	}
	private JPanel createSouth() {
		JPanel panel = new JPanel();
		
		JCheckBox checkBox = new JCheckBox("�������� ����");
		JTextField id = new JTextField(10);
		JTextField pw = new JTextField(10);
		
		id.setEditable(false);
		pw.setEditable(false);
		
		panel.add(checkBox);
		panel.add(new JLabel("���̵�"));
		panel.add(id);
		panel.add(new JLabel("��й�ȣ"));
		panel.add(pw);
		
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel2.add(new JButton("����"));
		
		panel.add(panel2);
		
		return panel;
	}
}

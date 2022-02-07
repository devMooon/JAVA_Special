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
	
	JMenuItem getExcelMenu = new JMenuItem("엑셀 파일에서 가져오기(I)");
	JMenuItem setExcelMenu = new JMenuItem("엑셀 파일로 내보내기(E)");
	JMenuItem saveMenu = new JMenuItem("저장(S)");
	JMenuItem logOutMenu = new JMenuItem("로그아웃(O)");
	JMenuItem exitMenu = new JMenuItem("종료(X)");
	
	JMenuItem userMenu = new JMenuItem("사용자(U)");
	JMenuItem siteMenu = new JMenuItem("사이트 분류(C)");
	
	JCheckBoxMenuItem autoLoginMenu = new JCheckBoxMenuItem("자동 로그인(L)");
	JCheckBoxMenuItem rememberMenu = new JCheckBoxMenuItem("계정정보 보기 상태 기억하기(V)");
	
	Vector<String> classification = new Vector<String>();
	Vector<String> preference = new Vector<String>();
	
	public SiteInfoManager(){
		super("서연이가 만든 인터넷 계정관리");
		
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
		
		//이벤트 리스너 추가
	}
	private JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("파일(F)");
		JMenu managementMenu = new JMenu("관리(M)");
		JMenu settingMenu = new JMenu("설정(S)");

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
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("입력/수정");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		panel.add(createBasicInformation());
		panel.add(createAddInformation());
		return panel;
		
	}
	private JPanel createBasicInformation() {
		JPanel panel = new JPanel(new GridLayout(4, 1));
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("기본 정보");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		panel.add(createFlowLayoutPanel("사이트명", new JTextField(20)));
		JTextField textField = new JTextField(14);
		textField.setEditable(false);
		panel.add(createFlowLayoutPanel("주소(URL)  http://", textField));
		panel.add(createFlowLayoutPanel("아  이  디", new JTextField(10)));
		panel.add(createFlowLayoutPanel("비밀번호", new JTextField(10)));
	
		return panel;
	}
	private JPanel createAddInformation() {
		JPanel panel = new JPanel(new GridLayout(4, 1));
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("기본 정보");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		classification.add("일반");
		classification.add("분류");
		preference.add("☆☆☆☆☆");
		preference.add("☆☆☆☆");
		preference.add("☆☆☆");
		preference.add("☆☆");
		preference.add("☆");
		
		panel.add(createFlowLayoutPanel("분        류", new JComboBox<String>(classification)));
		panel.add(createFlowLayoutPanel("선  호  도", new JComboBox<String>(preference)));
		panel.add(createFlowLayoutPanel("메        모", new JTextArea(1, 20)));
	
		return panel;
	}
	private JPanel createFlowLayoutPanel(String string, Component component) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(new JLabel(string));
		panel.add(component);
		
		return panel;
	}
}

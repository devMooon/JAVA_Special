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
	
	Vector<String> searchClassification = new Vector<String>();
	
	Vector<String> sortClassification = new Vector<String>();
	Vector<String> sortURL = new Vector<String>();
	
	String tableHeader[] = {"분류", "선호도", "사이트 이름", "사이트 주소"};
	String tableContents[][] = {
			{"일반", "☆☆☆☆☆", "사람만이", "sarammani.com"},
			{"학교", "☆☆", "덕성여자대학교", "www.duksungac.kr"}
	};
	
	public SiteInfoManager(){
		super("서연이가 만든 인터넷 계정관리");
		
		SettingMenu();
		this.setJMenuBar(createMenu());
		this.add(createInputModifyPanel(), BorderLayout.WEST);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		panel.add(new JLabel("2개의 사이트가 등록되어 있습니다."));
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
		panel.add(createButtons());
		
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
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("추가 정보");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		JPanel panel2 = new JPanel(new GridLayout(2, 1));
		
		classification.add("일반");
		classification.add("분류");
		preference.add("☆☆☆☆☆");
		preference.add("☆☆☆☆");
		preference.add("☆☆☆");
		preference.add("☆☆");
		preference.add("☆");
		
		panel2.add(createFlowLayoutPanel("분        류", new JComboBox<String>(classification)));
		panel2.add(createFlowLayoutPanel("선  호  도", new JComboBox<String>(preference)));
		
		panel.add(panel2);
		panel.add(createFlowLayoutPanel("메        모", new JTextArea(3, 20)));
	
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
		
		JButton newButton = new JButton("새로 작성(N)");
		JButton editButton = new JButton("수정(E)");
		
		newButton.setEnabled(false);
		
		panel.add(newButton);
		panel.add(editButton);
		
		return panel;
	}
	private JTabbedPane createTabbedPane() {
		JPanel panel = new JPanel();
		
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("사이트 목록", sitelist());
		pane.addTab("등록현황", sitelist());
		
		return pane;
	}
	private JPanel sitelist() {
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel panel2 = new JPanel(new BorderLayout());
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("검색/정렬");
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
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("검색");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		searchClassification.add("전체");
		searchClassification.addAll(classification);
		
		panel.add(new JComboBox<String>(searchClassification));
		panel.add(new JLabel(" 필터: "));
		panel.add(new JTextField(5));
		
		return panel;
	}
	private JPanel createSort() {
		JPanel panel = new JPanel(new FlowLayout());
		
		TitledBorder borderFactory = BorderFactory.createTitledBorder("정렬");
		borderFactory.setBorder(BorderFactory.createEtchedBorder());
		panel.setBorder(borderFactory);
		
		sortClassification.add("분류");
		sortClassification.addAll(classification);
		sortURL.add("사이트 이름");
		
		//분류라는 제목을 콤보박스의 제목으로
		//콤보박스 크기 조정
		panel.add(new JComboBox<String>(sortClassification));
		panel.add(new JComboBox<String>(sortURL));
		panel.add(new JButton("정렬"));
		panel.add(new JButton("기본"));
		
		return panel;
	}
	private JPanel createTable() {
		JPanel panel = new JPanel();
		
		//셀 사이즈 조정
		//분류에 세모
		//검색, 정렬과 사이즈...
		
		JTable table = new JTable(tableContents, tableHeader);
		panel.add(new JScrollPane(table));
		
		return panel;
	}
	private JPanel createSouth() {
		JPanel panel = new JPanel();
		
		JCheckBox checkBox = new JCheckBox("계정정보 보기");
		JTextField id = new JTextField(10);
		JTextField pw = new JTextField(10);
		
		id.setEditable(false);
		pw.setEditable(false);
		
		panel.add(checkBox);
		panel.add(new JLabel("아이디"));
		panel.add(id);
		panel.add(new JLabel("비밀번호"));
		panel.add(pw);
		
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel2.add(new JButton("삭제"));
		
		panel.add(panel2);
		
		return panel;
	}
}

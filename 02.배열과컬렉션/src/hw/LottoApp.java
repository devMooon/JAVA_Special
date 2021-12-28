package hw;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LottoApp extends JFrame {
	private JRadioButton radioBt_create, radioBt_confirm;
	private JButton bt_create, bt_confirm, bt_reset, bt_exit;
	private CardLayout card;
	private JPanel cardPanel;
	
	final private int SIZE = Lotto.SIZE;
	
	private Lotto lotto;
	
	private JPanel[] pArray_create;
	private JPanel[] pArray_confirm;
	
	private JTextField[] tf_create;
	private JCheckBox[] checkBoxs;
	private int seletedIndex;
	
	private JTextField[] tf_confirm;
	
	
	public LottoApp() {
		super("로또 번호 생성/검사기");
		
		createData();
		buildGUI();
		registerEvent();
		
		this.setSize(500, 150);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}
	private void createData() {
		tf_create = new JTextField[SIZE];
		checkBoxs = new JCheckBox[SIZE];
		seletedIndex = 0;
		
		tf_confirm = new JTextField[SIZE];
		
		lotto = new Lotto();
		
		for(int i = 0; i < SIZE; i++) {
			tf_create[i] = new JTextField();
			tf_create[i].setEnabled(false);
			checkBoxs[i] = new JCheckBox();
			
			tf_confirm[i] = new JTextField();
		}
	}
	private void buildGUI() {
		this.setLayout(new BorderLayout());
		
		card = new CardLayout();
		cardPanel = new JPanel(card);
		setCardPanel();
		
		this.add(createNorthPanel(), BorderLayout.NORTH);
		this.add(cardPanel, BorderLayout.CENTER);
		this.add(createSouthPanel(), BorderLayout.SOUTH);
	}
	private void registerEvent() {
		ActionListener cardHandler = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(cardPanel, e.getActionCommand());
				
				if(e.getSource() == radioBt_create) {
					for(int i = 0; i < SIZE; i++) {
						tf_create[i].setText("");
						tf_create[i].setEnabled(false);
						checkBoxs[i].setSelected(false);
					}

					bt_create.setEnabled(true);
					bt_confirm.setEnabled(false);
					bt_reset.setEnabled(false);
				}
				else {
					for(int i = 0; i < SIZE; i++) {
						bt_create.setEnabled(false);
						bt_confirm.setEnabled(true);
						bt_reset.setEnabled(false);
					}
				}
				
				for(int i = 0; i < SIZE; i++) {
					
				}
			}
			
		};
		radioBt_create.addActionListener(cardHandler);
		radioBt_confirm.addActionListener(cardHandler);
		
		ItemListener checkBoxsHandler = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				//체크박스는 앞에서부터만 순차적으로 선택된다 가정하여 인덱스를 알아낼 필요 없음
				/*
				int index = 0;
				JCheckBox cBox =  (JCheckBox)e.getItem();
				for(int i = 0; i < SIZE; i++) {
					if(checkBoxs[i] == cBox) {
						index = i;
						break;
					}
				}
				*/
				
				if(e.getStateChange() == ItemEvent.SELECTED) {
					tf_create[seletedIndex].setEnabled(true);
					seletedIndex++;
				}
				else {
					tf_create[seletedIndex].setEnabled(false);
					seletedIndex--;
				}
			}
		};
		
		for(int i = 0; i < SIZE; i++) {
			checkBoxs[i].addItemListener(checkBoxsHandler);
		}
		
		bt_create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < seletedIndex; i++) {
					lotto.setNumber(Integer.parseInt(tf_create[i].getText()));
				}
				
				lotto.generate();
				
				for(int i = 0; i < SIZE; i++) {
					tf_create[i].setText(String.valueOf(lotto.getNumbers()[i]));
				}
				
				bt_reset.setEnabled(true);
			}
		});
		bt_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lotto.reset();
				
				for(int i = 0; i < SIZE; i++) {
					try {
						if(!lotto.setNumber(Integer.parseInt(tf_confirm[i].getText()))) {
							JOptionPane.showMessageDialog(LottoApp.this, (i+1) + "번째 값은 유효하지 않습니다.", "오류", JOptionPane.WARNING_MESSAGE);
						}
						
						bt_reset.setEnabled(true);
					} catch (NumberFormatException exception) {
						JOptionPane.showMessageDialog(LottoApp.this, "빈칸 없이 정수만 입력 해주세요.", "오류", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				
			}
		});
		bt_reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < SIZE; i++) {
					tf_create[i].setText("");
					tf_confirm[i].setText("");
					tf_create[i].setEnabled(false);
					checkBoxs[i].setSelected(false);
				}
				
				lotto.reset();
				bt_reset.setEnabled(false);
			}
		});
		bt_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(LottoApp.this, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) System.exit(0);
			}
		});
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(LottoApp.this, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) System.exit(0);
			}
			
		});
	}
	
	
	private JPanel createNorthPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ButtonGroup btnGroup = new ButtonGroup();
		
		radioBt_create = new JRadioButton("자동생성", true);
		radioBt_confirm = new JRadioButton("유효성 검사");
		
		btnGroup.add(radioBt_create);
		btnGroup.add(radioBt_confirm);
		
		panel.add(radioBt_create);
		panel.add(radioBt_confirm);
		
		return panel;
	}
	private void setCardPanel() {
		JPanel p_create = new JPanel(new GridLayout(1, 0));
		JPanel p_confirm = new JPanel(new GridLayout(1, 0));
		
		pArray_create = new JPanel[SIZE];
		pArray_confirm = new JPanel[SIZE];
		
		//p_create
		for(int i = 0; i < SIZE; i++) {
			pArray_create[i] = new JPanel(new BorderLayout());
			
			pArray_create[i].add(tf_create[i]);
			pArray_create[i].add(checkBoxs[i], BorderLayout.SOUTH);
			
			p_create.add(pArray_create[i]);
		}
		
		//p_confirm
		for(int i = 0; i < SIZE; i++) {
			pArray_confirm[i] = new JPanel(new BorderLayout());
			//pArray_confirm[i].add(tf_create[i], BorderLayout.NORTH);
			pArray_confirm[i].add(tf_confirm[i], BorderLayout.NORTH);
			p_confirm.add(pArray_confirm[i]);
		}
		
		cardPanel.add("자동생성", p_create);
		cardPanel.add("유효성 검사", p_confirm);
	}
	private JPanel createSouthPanel() {
		JPanel panel = new JPanel(new GridLayout(1, 0));
		
		bt_create = new JButton("생성");
		bt_confirm = new JButton("검사");
		bt_reset = new JButton("초기화");
		bt_exit = new JButton("종료");
		
		bt_confirm.setEnabled(false);
		bt_reset.setEnabled(false);
		
		panel.add(bt_create);
		panel.add(bt_confirm);
		panel.add(bt_reset);
		panel.add(bt_exit);
		
		return panel;
	}
}

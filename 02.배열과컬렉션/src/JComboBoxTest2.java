import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore.PrivateKeyEntry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JComboBoxTest2 extends JFrame {
	private JTextField textField;
	private JButton bt_add, bt_del;
	private String[] fruit;
	private int size;
	private JComboBox<String> comboBox;
	
	public JComboBoxTest2() {
		super("JComboBoxTest2");
		
		createData();
		buildGUI();
		registerEvent();
		
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void createData() {
		fruit = new String[3];
		fruit[0] = "apple";
		fruit[1] = "banana";
		fruit[2] = "cherry";
		
		size = 3;
		comboBox = new JComboBox<String>(fruit);
	}
	private void buildGUI(){
		this.setLayout(new FlowLayout());
		
		textField = new JTextField(15);
		bt_add = new JButton("추가");
		bt_del = new JButton("삭제");
		bt_del.setEnabled(false);
		
		this.add(textField);
		this.add(bt_add);
		this.add(bt_del);
		this.add(comboBox);
		
	}
	private void registerEvent(){
		bt_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox.addItem(textField.getText());
				
				textField.setText("");
			}
		});
		bt_del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//fruit[comboBox.getSelectedIndex()];
			}
		});
	}
	
	public static void main(String[] args) {
		new JComboBoxTest2();
	}

}

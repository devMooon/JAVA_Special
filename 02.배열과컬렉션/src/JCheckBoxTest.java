import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.NoRouteToHostException;
import java.security.KeyStore.PrivateKeyEntry;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JCheckBoxTest extends JFrame {
	private JCheckBox[] cb_list;
	private JTextArea t_display;
	
	public JCheckBoxTest() {
		super("JCheckBox 예제");
		
		buildGUI();
		registerEvent();
		
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	private void buildGUI(){
		t_display = new JTextArea();
		
		this.setLayout(new BorderLayout());
		
		this.add(north(), BorderLayout.NORTH);
		this.add(t_display);
		
		
	}
	private JPanel north(){
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		cb_list = new JCheckBox[5];
		
		for(int i = 0; i < cb_list.length; i++) {
			cb_list[i] = new JCheckBox("항목" + (i + 1));
			panel.add(cb_list[i]);
		}
		
		return panel;
	}
	private void registerEvent(){
		
	}
	
	public static void main(String[] args) {
		new JCheckBoxTest();
	}

}

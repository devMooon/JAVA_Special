
// 1. 배열 인수(자동 표 모델)
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;

public class SimpleTableEx extends JFrame {
	
	private JTable mTable;
	
	public SimpleTableEx() {
		super("테이블 테스트1");

		buildGUI();
		
		setSize(450, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void buildGUI() {
		JButton button = new JButton("출력");
		button.addActionListener(mHandler);
		
		add(createTablePanel(), BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
	}
	
	private JPanel createTablePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		String[] columnNames = { "이  름", "나이", "성별" };
		Object[][] data = { { "고주몽", 22, "남" },
							{ "소서노", 20, "여" } };
		
		// mTable = JTable 객체 생성
		mTable = new JTable(data, columnNames);
		// panel에 mTable 부착
		panel.add(new JScrollPane(mTable));
		
		mTable.setRowHeight(30);

		return panel;
	}
	
	private ActionListener mHandler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			// 표로부터 정보얻어와 출력하기
			//*/
			TableModel model = mTable.getModel();
			
			int rowNum = model.getRowCount();
			int colNum = model.getColumnCount();
			
			for(int c = 0; c < colNum; c++) {
				System.out.print(model.getColumnName(c) + "\t");
			}
			System.out.println();
			
			for(int r = 0; r < rowNum; r++) {
				for(int c = 0; c < colNum; c++){
					System.out.print(model.getValueAt(r, c) + "\t");
				}
				System.out.println();
			}
			System.out.println();

			
			/*/
			int rowNum = mTable.getRowCount();
			int colNum = mTable.getColumnCount();
			
			for(int c = 0; c < colNum; c++) {
				System.out.print(mTable.getColumnName(c) + "\t");
			}
			System.out.println();
			
			for(int r = 0; r < rowNum; r++) {
				for(int c = 0; c < colNum; c++){
					System.out.print(mTable.getValueAt(r, c) + "\t");
				}
				System.out.println();
			}
			System.out.println();
			//*/
			
			
		}
		
	};
	
	public static void main(String[] args) {
		new SimpleTableEx();
	}

}

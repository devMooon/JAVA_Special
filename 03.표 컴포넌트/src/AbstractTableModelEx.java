
// 3. 사용자 표 모델 이용
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AbstractTableModelEx extends JFrame {
	
	private JTable mTable;
	
	public AbstractTableModelEx() {
		super("테이블 테스트3");

		buildGUI();
		
		setSize(300,200);
		
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
		
		// model = 사용자정의 테이블모델 MyTableModel 객체 생성
		//테이블로부터 model을 언제든지 얻어올 수 있기 때문에 지역적으로 선언해도 됨
		MyTableModel model = new MyTableModel();
		// table = model과 연관된 JTable 객체 생성
		mTable = new JTable(model)
;
		mTable.setRowHeight(30);
		
		// panel에 table 부착
		panel.add(new JScrollPane(mTable));

		return panel;
	}
	
	private ActionListener mHandler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//TableModel model = mTable.getModel();
			/*/
			int rowNum = mTable.getRowCount();
			int colNum = mTable.getColumnCount();
			
			for ( int c = 0; c < colNum; c++ ) {
				String colName = mTable.getColumnName(c);
				System.out.print(colName + "\t");
			}
			System.out.println();
			
			for ( int r = 0; r < rowNum; r++ ) {
				for ( int c = 0; c < colNum; c++ ) {
					Object cell = mTable.getValueAt(r, c);
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
			System.out.println();
			
			//*/
			TableModel model = mTable.getModel();

			int rowNum = model.getRowCount();
			int colNum = model.getColumnCount();
			
			for ( int c = 0; c < colNum; c++ ) {
				String colName = model.getColumnName(c);
				System.out.print(colName + "\t");
			}
			System.out.println();
			
			for ( int r = 0; r < rowNum; r++ ) {
				for ( int c = 0; c < colNum; c++ ) {
					Object cell = model.getValueAt(r, c);
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
			System.out.println();
			//*/
		}
		
	};
	
	public static void main(String[] args) {
		new AbstractTableModelEx();
	}

}

/*/
class MyTableModel extends AbstractTableModel {
	private String[] columnNames = { "이  름", "나이", "성별" };
	
	private Object[][] data = { 
			{ "고주몽", 22, "남" },
			{ "소서노", 20, "여" } 
		};
	
	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length; //data[0].length
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		this.data[rowIndex][columnIndex] = aValue;
	}

	@Override
	public String getColumnName(int column) {
		return this.columnNames[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return (columnIndex != 0) ? true : false;
	}

}

/*/
class MyTableModel extends AbstractTableModel {
	private String[] columnNames = { "이  름", "나이", "성별" };
	
	private Object[][] data = { 
			{ "고주몽", "소서노" }, //0 col
			{ 22, 20 }, //1 col
			{ "남", "여" } //2 col
		};
	
	@Override
	public int getRowCount() {
		return data[0].length; //data[1].length //data[2].length
	}

	@Override
	public int getColumnCount() {
		return columnNames.length; //data.length
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[columnIndex][rowIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		this.data[columnIndex][rowIndex] = aValue;
	}

	@Override
	public String getColumnName(int column) {
		return this.columnNames[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return (columnIndex != 0) ? true : false;
	}

}
//*/


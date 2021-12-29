
// 3. ����� ǥ �� �̿�
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
		super("���̺� �׽�Ʈ3");

		buildGUI();
		
		setSize(300,200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void buildGUI() {
		JButton button = new JButton("���");
		
		button.addActionListener(mHandler);
		
		add(createTablePanel(), BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
	}
	
	private JPanel createTablePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		// model = ��������� ���̺�� MyTableModel ��ü ����
		//���̺�κ��� model�� �������� ���� �� �ֱ� ������ ���������� �����ص� ��
		MyTableModel model = new MyTableModel();
		// table = model�� ������ JTable ��ü ����
		mTable = new JTable(model)
;
		mTable.setRowHeight(30);
		
		// panel�� table ����
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
	private String[] columnNames = { "��  ��", "����", "����" };
	
	private Object[][] data = { 
			{ "���ָ�", 22, "��" },
			{ "�Ҽ���", 20, "��" } 
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
	private String[] columnNames = { "��  ��", "����", "����" };
	
	private Object[][] data = { 
			{ "���ָ�", "�Ҽ���" }, //0 col
			{ 22, 20 }, //1 col
			{ "��", "��" } //2 col
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


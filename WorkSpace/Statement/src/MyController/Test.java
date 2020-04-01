package MyController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import MyModel.Model;
import MyView.SinhVien;

public class Test {
	private SinhVien view;
	private Model model;

	public Test(SinhVien view, Model model) {
		super();
		this.view = view;
		this.model = model;
		eventHandling();
	}

	public void eventHandling() {
		// hiển thị danh sách sinh viên
		try {
			// String databasePath =
			// "C:\\Users\\welcome\\workspace\\Bai29_Statement\\SinhVien.accdb";
			String databasePath = "csdl/SinhVien.accdb";
			String strConnection = "jdbc:ucanaccess://" + databasePath;
			view.conn = DriverManager.getConnection(strConnection);
			if (view.conn != null) {
				System.out.println("Kết nối thành công");
				Statement statement = view.conn.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM SINHVIEN");
				view.dtm.setRowCount(0); // xoa du lieu cu di
				while (result.next()) { // trong khi dang con du lieu
					String ma = result.getString("Ma");
					String ten = result.getString("Ten");
					int tuoi = result.getInt("Tuoi");
					String diaChi = result.getString("DiaChi");
					Vector vec = new Vector<>();
					vec.add(ma);
					vec.add(ten);
					vec.add(tuoi);
					vec.add(diaChi);
					view.dtm.addRow(vec);

				}
			} else {
				System.out.println("Kết nối thất bại");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// 
		view.tblSinhhVien.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				int row = view.tblSinhhVien.getSelectedRow();
				int col = view.tblSinhhVien.getSelectedColumn();
				view.tblSinhhVien.getCellEditor(row, col).cancelCellEditing();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public static void main(String[] args) {
		SinhVien view = new SinhVien();
		Model model = new Model();
		new Test(view, model);
	}

}

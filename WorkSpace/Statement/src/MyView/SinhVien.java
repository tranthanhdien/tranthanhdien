package MyView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SinhVien extends JFrame {
	public DefaultTableModel dtm;
	public JTable tblSinhhVien;
	public Connection conn;
	public SinhVien() {
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		dtm = new DefaultTableModel();
		dtm.addColumn("Mã Sinh Viên");
		dtm.addColumn("Tên Sinh Viên");
		dtm.addColumn("Tuổi Sinh Viên");
		dtm.addColumn("Địa chỉ");
		tblSinhhVien = new JTable(dtm);
		JScrollPane sc = new JScrollPane(tblSinhhVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		con.add(sc, BorderLayout.CENTER);

		this.setTitle("Statement-truy vấn dữ liệu");
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	

}

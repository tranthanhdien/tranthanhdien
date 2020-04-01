package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import topica.edu.vn.connect.CoQuanService;
import topica.edu.vn.connect.CongVanService;
import topica.edu.vn.connect.LoaiCongVanService;
import topica.edu.vn.model.CoQuan;
import topica.edu.vn.model.CongVan;
import topica.edu.vn.model.LoaiCongVan;

public class QuanLyCongVanUI extends JFrame {
	
	DefaultTableModel dtmCongVan;
	JTable tblCongVan;
	
	JTextField txtCoQuan;
	JTextField txtLoaiCongVan;
	JTextArea txtGhiChu;
	
	ArrayList<CongVan>dsCv;
	
	JButton btnLuu,btnXoa;
	
	public QuanLyCongVanUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		
		hienThiCongVan();
	}

	private void hienThiCongVan() {
		dsCv=CongVanService
				.layDanhSachCongVanTheoNguoiDung(DangNhapUI.login.getId());
		dtmCongVan.setRowCount(0);
		
		for(CongVan cv : dsCv)
		{
			Vector<Object>vec=new Vector<Object>();
			vec.add(cv.getId());
			vec.add(cv.getCoQuanId());
			vec.add(cv.getNgayVanBan());
			dtmCongVan.addRow(vec);
		}
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		tblCongVan.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row=tblCongVan.getSelectedRow();
				if(row==-1)return;
				CongVan cv=dsCv.get(row);
				hienThiChiTietCongVan(cv);
			}
		});
	}

	protected void hienThiChiTietCongVan(CongVan cv) {
		txtGhiChu.setLineWrap(true);
		txtGhiChu.setWrapStyleWord(true);
		txtGhiChu.setText(cv.getGhiChu());
		CoQuan cq=CoQuanService.layThongTinChiTiet(cv.getCoQuanId());
		txtCoQuan.setText(cq.getMaCoQuan()+" "+cq.getTenCoQuan());
		LoaiCongVan lcv=LoaiCongVanService.layThongTinChiTiet(cv.getLoaiCongVanId());
		txtLoaiCongVan.setText(lcv.getTenLoai());
	}

	private void addControls() {
		Container con=getContentPane();
		con.setLayout(new  BorderLayout());
		JPanel pnLeft=new JPanel();
		JPanel pnRight=new JPanel();
		JSplitPane spMain=new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT, 
				pnLeft, pnRight);
		pnLeft.setPreferredSize(new Dimension(400, 0));
		con.add(spMain,BorderLayout.CENTER);
		
		dtmCongVan=new DefaultTableModel();
		dtmCongVan.addColumn("Mã Công Văn");
		dtmCongVan.addColumn("Cơ quan");
		dtmCongVan.addColumn("Ngày văn bản");
		tblCongVan=new JTable(dtmCongVan);
		JScrollPane scTable=new 
				JScrollPane(tblCongVan, 
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
						JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.setLayout(new BorderLayout());
		pnLeft.add(scTable,BorderLayout.CENTER);
		
		pnRight.setLayout(new  BorderLayout());
		JPanel pnTopOfRight=new  JPanel();
		pnTopOfRight.setPreferredSize(new Dimension(0,300));
		JPanel pnBottomOfRight=new  JPanel();
		JSplitPane spRight=new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				pnTopOfRight,pnBottomOfRight);
		pnRight.add(spRight,BorderLayout.CENTER);
		
		
		pnTopOfRight.setLayout(new BoxLayout(pnTopOfRight, BoxLayout.Y_AXIS));
		
		JPanel pnCoQuan=new JPanel();
		pnCoQuan.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblCoQuan=new JLabel("Cơ Quan:");
		txtCoQuan=new JTextField(20);
		pnCoQuan.add(lblCoQuan);
		pnCoQuan.add(txtCoQuan);
		pnTopOfRight.add(pnCoQuan);
		
		JPanel pnLoaiCongVan=new JPanel();
		pnLoaiCongVan.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblLoaiCongVan=new JLabel("Loại Công văn:");
		txtLoaiCongVan=new JTextField(20);
		pnLoaiCongVan.add(lblLoaiCongVan);
		pnLoaiCongVan.add(txtLoaiCongVan);
		pnTopOfRight.add(pnLoaiCongVan);
		
		JPanel pnGhiChu=new JPanel();
		pnGhiChu.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGhiChu=new JLabel("ghi Chú:");
		txtGhiChu=new JTextArea(5,20);
		JScrollPane scGhiChu=new JScrollPane(txtGhiChu,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JPanel pnGhiChuCenter=new JPanel();
		pnGhiChuCenter.setLayout(new BorderLayout());
		pnGhiChuCenter.add(scGhiChu,BorderLayout.CENTER);
		
		pnGhiChu.add(lblGhiChu);
		pnGhiChu.add(pnGhiChuCenter);
		pnTopOfRight.add(pnGhiChu);
		
		lblCoQuan.setPreferredSize(lblLoaiCongVan.getPreferredSize());
		lblGhiChu.setPreferredSize(lblLoaiCongVan.getPreferredSize());
		
		JPanel pnButtonOfToOfRight=new JPanel();
		pnButtonOfToOfRight.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnLuu=new JButton("Lưu");
		btnXoa=new JButton("Xóa");
		pnButtonOfToOfRight.add(btnLuu);
		pnButtonOfToOfRight.add(btnXoa);
		pnTopOfRight.add(pnButtonOfToOfRight);
	}
	public void showWindow()
	{
		this.setSize(1000, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);;
	}
	
}

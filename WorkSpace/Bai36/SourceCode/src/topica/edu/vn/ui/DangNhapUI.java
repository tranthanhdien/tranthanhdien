package topica.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import topica.edu.vn.connect.MSAccessConnection;
import topica.edu.vn.connect.NguoiDungService;
import topica.edu.vn.model.NguoiDung;

public class DangNhapUI extends JFrame {
	JTextField txtUser;
	JPasswordField txtPassword;
	JButton btnLogin,btnExit;
	public static NguoiDung login=null;
	public DangNhapUI(String title)
	{
		super(title);
		addControls();
		addEvents();		
	}

	private void addEvents() {
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyDangNhap();
			}
		}  );
	}
	protected void xuLyDangNhap() {
		login=NguoiDungService.dangNhap(txtUser.getText(), txtPassword.getText());
		if(login==null)
		{
			JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
			this.dispose();
			QuanLyCongVanUI ui=new QuanLyCongVanUI("Màn hình quản lý công văn");
			ui.showWindow();
		}
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		con.add(pnMain);
		pnMain.setLayout(new  BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel pnTitle=new JPanel();
		JLabel lblTitle=new JLabel("Đăng nhập hệ thống quản lý Công Văn");
		lblTitle.setForeground(Color.BLUE);
		Font fontTitle=new Font("cambria",Font.BOLD,20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);
		
		JPanel pnDangNhap=new JPanel();
		pnDangNhap.setLayout(new BoxLayout(pnDangNhap, BoxLayout.Y_AXIS));
		pnMain.add(pnDangNhap);
		JPanel pnUser=new JPanel();
		JLabel lblUser=new JLabel("User Name:");
		txtUser=new JTextField(15);
		pnUser.add(lblUser);
		pnUser.add(txtUser);
		pnDangNhap.add(pnUser);
		JPanel pnPassword=new JPanel();
		JLabel lblPassword=new JLabel("Password:");
		txtPassword=new JPasswordField(15);
		pnPassword.add(lblPassword);
		pnPassword.add(txtPassword);
		pnDangNhap.add(pnPassword);
		
		JPanel pnButton=new JPanel();
		btnExit=new JButton("Thoát");
		btnLogin=new JButton("Đăng nhập");
		pnButton.add(btnLogin);
		pnButton.add(btnExit);
		pnDangNhap.add(pnButton);
		
		TitledBorder border=new TitledBorder(
				BorderFactory.createLineBorder(Color.RED),
				"Thông tin đăng nhập:");
		pnDangNhap.setBorder(border);
		
		lblPassword.setPreferredSize(lblUser.getPreferredSize());
	}
	public void showWindow()
	{
		this.setSize(400, 250);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

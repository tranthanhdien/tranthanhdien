package topica.edu.vn.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import topica.edu.vn.model.NguoiDung;

public class NguoiDungService  {
	public static Connection connection=MSAccessConnection.getConnection();
	public static NguoiDung dangNhap(String userName,String password)
	{
		NguoiDung nd=null;
		try
		{
			String sql="select * from nguoidung where username=? and password=?";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setString(1, userName);
			pre.setString(2, password);
			ResultSet result=pre.executeQuery();
			if(result.next())
			{
				nd=new NguoiDung();
				nd.setId(result.getInt("id"));
				nd.setUserName(result.getString("username"));
				nd.setPassWord(result.getString("password"));
				nd.setHoTen(result.getString("hoten"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return nd;
	}
	public static ArrayList<NguoiDung> layToanBoNguoiDung()
	{
		ArrayList<NguoiDung>dsNguoiDung=new ArrayList<NguoiDung>();
		try
		{
			String sql="select * from nguoidung";
			PreparedStatement preStatement=connection.prepareStatement(sql);
			ResultSet result=preStatement.executeQuery();
			while(result.next())
			{
				NguoiDung nd=new NguoiDung();
				nd.setId(result.getInt("id"));
				nd.setUserName(result.getString("username"));
				nd.setPassWord(result.getString("password"));
				nd.setHoTen(result.getString("hoten"));
				
				dsNguoiDung.add(nd);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsNguoiDung;
	}
}

package topica.edu.vn.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import topica.edu.vn.model.CongVan;

public class CongVanService {
	public static Connection connection=MSAccessConnection.getConnection();
	public static ArrayList<CongVan>layDanhSachCongVanTheoNguoiDung(int maNd)
	{
		ArrayList<CongVan> dsCv=new 
				ArrayList<CongVan>();
		try
		{
			String sql="select * from CongVan where NguoiNhanId=?";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setInt(1, maNd);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				CongVan cv=new CongVan();
				cv.setId(result.getInt("Id"));
				cv.setLoaiCongVanId(result.getInt("loaiCongVanId"));
				cv.setNguoiNhanId(result.getInt("nguoiNhanId"));
				cv.setCoQuanId(result.getInt("coQuanId"));
				cv.setNgayThangVaoSo(result.getDate("ngayThangVaoSo"));
				cv.setSoVanBan(result.getString("soVanBan"));
				cv.setNgayVanBan(result.getDate("ngayVanBan"));
				cv.setGhiChu(result.getString("ghiChu"));
				dsCv.add(cv);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsCv;
	}
}

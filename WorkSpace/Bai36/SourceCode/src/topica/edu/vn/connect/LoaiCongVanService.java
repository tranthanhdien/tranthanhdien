package topica.edu.vn.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import topica.edu.vn.model.CoQuan;
import topica.edu.vn.model.LoaiCongVan;

public class LoaiCongVanService {
	public static Connection connection=MSAccessConnection.getConnection();
	public static LoaiCongVan layThongTinChiTiet(int idLoaiCv)
	{
		LoaiCongVan lcv=null;
		try
		{
			String sql="select * from LoaiCongVan where id=?";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setInt(1, idLoaiCv);
			ResultSet result=pre.executeQuery();
			if(result.next())
			{
				lcv=new LoaiCongVan();
				lcv.setId(result.getInt("id"));
				lcv.setMaLoai(result.getString("maloaicongvan"));
				lcv.setTenLoai(result.getString("tencongvan"));
				return lcv;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return lcv;
	}
}

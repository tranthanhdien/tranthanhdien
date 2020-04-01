package topica.edu.vn.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import topica.edu.vn.model.CoQuan;

public class CoQuanService {
	public static Connection connection=MSAccessConnection.getConnection();
	public static CoQuan layThongTinChiTiet(int idCoQuan)
	{
		CoQuan cq=null;
		try
		{
			String sql="select * from coquanbanhanh where id=?";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setInt(1, idCoQuan);
			ResultSet result=pre.executeQuery();
			if(result.next())
			{
				cq=new CoQuan();
				cq.setId(result.getInt("id"));
				cq.setMaCoQuan(result.getString("macoquan"));
				cq.setTenCoQuan(result.getString("tencoquan"));
				return cq;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return cq;
	}
}

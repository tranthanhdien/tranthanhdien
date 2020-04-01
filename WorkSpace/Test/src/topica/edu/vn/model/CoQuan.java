package topica.edu.vn.model;

import java.io.Serializable;

public class CoQuan implements Serializable {
	private int id;
	private String maCoQuan;
	private String tenCoQuan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaCoQuan() {
		return maCoQuan;
	}
	public void setMaCoQuan(String maCoQuan) {
		this.maCoQuan = maCoQuan;
	}
	public String getTenCoQuan() {
		return tenCoQuan;
	}
	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
	}
	
}

package topica.edu.vn.model;

import java.io.Serializable;
import java.sql.Date;

public class CongVan implements Serializable{
	private int id;
	private int loaiCongVanId;
	private int nguoiNhanId;
	private int coQuanId;
	private Date ngayThangVaoSo;
	private String soVanBan;
	private Date ngayVanBan;
	private String ghiChu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLoaiCongVanId() {
		return loaiCongVanId;
	}
	public void setLoaiCongVanId(int loaiCongVanId) {
		this.loaiCongVanId = loaiCongVanId;
	}
	public int getNguoiNhanId() {
		return nguoiNhanId;
	}
	public void setNguoiNhanId(int nguoiNhanId) {
		this.nguoiNhanId = nguoiNhanId;
	}
	public int getCoQuanId() {
		return coQuanId;
	}
	public void setCoQuanId(int coQuanId) {
		this.coQuanId = coQuanId;
	}
	public Date getNgayThangVaoSo() {
		return ngayThangVaoSo;
	}
	public void setNgayThangVaoSo(Date ngayThangVaoSo) {
		this.ngayThangVaoSo = ngayThangVaoSo;
	}
	public String getSoVanBan() {
		return soVanBan;
	}
	public void setSoVanBan(String soVanBan) {
		this.soVanBan = soVanBan;
	}
	public Date getNgayVanBan() {
		return ngayVanBan;
	}
	public void setNgayVanBan(Date ngayVanBan) {
		this.ngayVanBan = ngayVanBan;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public CongVan() {
		super();
	}
	
}

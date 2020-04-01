package de22;

public class Student {
	private String mssv;
	private String ten;
	private int tuoi;
	private double diemTB;

	public Student(String mssv, String ten, int tuoi, double diemTB) {
		super();
		this.mssv = mssv;
		this.ten = ten;
		this.tuoi = tuoi;
		this.diemTB = diemTB;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	@Override
	public String toString() {
		return mssv + "\t" + ten + "\t" + tuoi + "\t" + diemTB + "\n";
	}

}

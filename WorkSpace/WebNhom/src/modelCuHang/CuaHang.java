package modelCuHang;

public class CuaHang {
	private int id;
	private String name;
	private String tinh;

	public CuaHang(int id, String name, String tinh) {
		super();
		this.id = id;
		this.name = name;
		this.tinh = tinh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

}

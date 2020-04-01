package DAO;

public class People {
	private int id, phone, cmnd;
	private String name, gender, address, job, birthday, avatar;

	public People(int id, String name, String gender, String birthday, int cmnd, String address, String job, int phone,
			String avatar) {
		super();
		this.id = id;
		this.phone = phone;
		this.cmnd = cmnd;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.job = job;
		this.birthday = birthday;
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public int getPhone() {
		return phone;
	}

	public int getCmnd() {
		return cmnd;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getJob() {
		return job;
	}

	public String getDay() {
		return birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", phone=" + phone + ", cmnd=" + cmnd + ", name=" + name + ", gender=" + gender
				+ ", address=" + address + ", job=" + job + ", birthday=" + birthday + ", avatar=" + avatar + "]";
	}

}

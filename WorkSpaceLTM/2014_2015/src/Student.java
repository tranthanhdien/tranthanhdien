
public class Student {
	private String mssv;
	private String name;
	private int age;
	private double score;

	public Student(String mssv, String name, int age, double score) {
		super();
		this.mssv = mssv;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getMssv() {
		return mssv;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getScore() {
		return score;
	}

	@Override
	public String toString() {
		return mssv + "\t" + name + "\t" + age + "\t" + score + "\n";
	}

}

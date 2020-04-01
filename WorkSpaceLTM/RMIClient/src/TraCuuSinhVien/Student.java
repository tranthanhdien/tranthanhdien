package TraCuuSinhVien;


public class Student{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
	private double score;

	public Student(int id, String name, int age, double score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public int getId() {
		return id;
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
		return id + "\t" + name + "\t" + age + "\t" + score;
	}

}

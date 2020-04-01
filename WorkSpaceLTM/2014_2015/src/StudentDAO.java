import java.util.ArrayList;

public class StudentDAO {
	static ArrayList<Student> list = new ArrayList<>();
	static {
		list.add(new Student("111", "dien", 20, 10));
		list.add(new Student("222", "truong", 19, 9));
		list.add(new Student("333", "hien", 25, 8));
		list.add(new Student("444", "an", 18, 8.5));
		list.add(new Student("555", "ti", 23, 7.5));
		list.add(new Student("666", "dan", 19, 7));

	}

	public static ArrayList<Student> findById(String id) {
		ArrayList<Student> li = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMssv().equalsIgnoreCase(id)) {
				li.add(list.get(i));
			}
		}
		return li;
	}

	public static ArrayList<Student> findByName(String name) {
		ArrayList<Student> li = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equalsIgnoreCase(name)) {
				li.add(list.get(i));
			}
		}
		return li;
	}

	public static ArrayList<Student> findByAge(int age) {
		ArrayList<Student> li = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAge() == age) {
				li.add(list.get(i));
			}
		}
		return li;
	}

	public static ArrayList<Student> findByScore(double score) {
		ArrayList<Student> li = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getScore() == score) {
				li.add(list.get(i));
			}
		}
		return li;
	}
	
}

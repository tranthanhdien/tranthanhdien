package lt.socket;

import java.util.ArrayList;

public class Server {
	private static ArrayList<Student> listStudents = new ArrayList<>();

	public static ArrayList<Student> generateListStudent() {
		if (listStudents == null) {
			listStudents = new ArrayList<Student>();
		} else {
			listStudents.add(new Student(1, "dien", 20, 9.5));
			listStudents.add(new Student(2, "da", 15, 10));
			listStudents.add(new Student(3, "binh", 17, 8));
			listStudents.add(new Student(4, "nghi", 22, 7.5));
			listStudents.add(new Student(5, "lua", 18, 8));
			listStudents.add(new Student(6, "tung", 22, 8.5));
			listStudents.add(new Student(7, "an", 23, 8.5));
			listStudents.add(new Student(8, "son", 19, 9));
		}
		return listStudents;
	}

	public static String findByName(String name) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getName().equalsIgnoreCase(name)) {
				result += s + "\n";

			}
		}
		return result;
	}

	public static String findByAge(int age) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() == age) {
				result += s + "n";
			}
		}
		return result;
	}

	public static String findByUpperAge(int age) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() >= age) {
				result += s + "n";
			}
		}
		return result;
	}

	public static String findByUnderAge(int age) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() <= age) {
				result += s + "n";
			}
		}
		return result;
	}

	public static String findByScore(double score) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() == score) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static String findByUpperScore(double score) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() >= score) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static String findByUnderScore(double score) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() <= score) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}
}

package TraCuuSinhVien;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StudentImp extends UnicastRemoteObject implements IStudent {

	static ArrayList<Student> listStudents = new ArrayList<>();

	protected StudentImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String findList() throws RemoteException {
		String result = "";
		for (Student st : listStudents) {
			result += st.getId() + "\t" + st.getName() + "\t" + st.getAge() + "\t" + st.getScore();
		}
		return result;
	}

	@Override
	public void createList() throws RemoteException {
		listStudents.add(new Student(1, "nguyen van a", 20, 8.5));
		listStudents.add(new Student(2, "nguyen van b", 21, 9.5));
		listStudents.add(new Student(3, "nguyen van c", 19, 8));
		listStudents.add(new Student(4, "nguyen van d", 18, 7));
		listStudents.add(new Student(5, "nguyen van e", 22, 8));
		listStudents.add(new Student(6, "nguyen van f", 25, 9.5));
	}

	@Override
	public String findByName(String name) throws RemoteException {
		String result = "";
		for (Student st : listStudents) {
			if (st.getName().equalsIgnoreCase(name)) {
				result += st.toString();
			}
		}
		return result;
	}

	@Override
	public String findByAge(int age) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByUnderAge(int age) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByUpperAge(int age) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByScore(double score) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByUpperScore(double score) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByUnderScore(double score) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}

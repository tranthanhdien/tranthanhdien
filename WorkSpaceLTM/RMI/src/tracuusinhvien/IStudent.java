package tracuusinhvien;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IStudent extends Remote {
	public ArrayList<Student> findById(String mssv) throws RemoteException;
	public ArrayList<Student> findByName(String name) throws RemoteException;
	public ArrayList<Student> findByAge(int age) throws RemoteException;
	public ArrayList<Student> findByScore(double score) throws RemoteException;

}

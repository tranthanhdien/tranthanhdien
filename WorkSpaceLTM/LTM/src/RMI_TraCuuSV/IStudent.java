package RMI_TraCuuSV;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IStudent extends Remote {
	public String findList() throws RemoteException;

	public void createList() throws RemoteException;

	// tên
	public String findByName(String name) throws RemoteException;

	// tuổi
	public String findByAge(int age) throws RemoteException;

	public String findByUnderAge(int age) throws RemoteException;

	public String findByUpperAge(int age) throws RemoteException;

	// điểm
	public String findByScore(double score) throws RemoteException;

	public String findByUpperScore(double score) throws RemoteException;

	public String findByUnderScore(double score) throws RemoteException;

}

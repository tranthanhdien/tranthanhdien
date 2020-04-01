package ttdien.rmi.file;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ttdien.rmi.model.Product;

public interface IFile extends Remote {
	public boolean checkName(String name) throws RemoteException;

	public boolean checkPass(String pass) throws RemoteException;

	// add
	public boolean add(String id, String name, int count, double price) throws RemoteException;

	// remove
	public boolean remove(String id) throws RemoteException;

	// edit
	public boolean edit(String id, String name, int count, double price) throws RemoteException;

	// view(tìm kiếm)
	public ArrayList<Product> find(String name) throws RemoteException;
	// quit

}
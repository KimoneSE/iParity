package com.ip.dfs.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FileHandler extends Remote{
	
	String view(String id) 
			throws RemoteException;
	
	boolean save(String id, String file) 
			throws RemoteException;
	
	boolean delete(String id) 
			throws RemoteException;
	
	boolean replace(String id, String file) 
			throws RemoteException;
	
	List<String> listfiles() 
			throws RemoteException;
	
	boolean rebankup(String id, String file) 
			throws RemoteException;
}

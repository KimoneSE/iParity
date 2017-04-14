package com.ip.dfs.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DFSService extends Remote{
	
	String view(String id) 
			throws RemoteException;
	
	String save(String file) 
			throws RemoteException;
	
	boolean delete(String id) 
			throws RemoteException;
	
	boolean replace(String id, String file) 
			throws RemoteException;
	
	boolean recovery() 
			throws RemoteException;
	
}

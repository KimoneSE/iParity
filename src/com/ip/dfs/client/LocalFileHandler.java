package com.ip.dfs.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;

import com.ip.dfs.client.file.FileUpdater;
import com.ip.dfs.client.file.FileViewer;
import com.ip.dfs.common.FileHandler;

public class LocalFileHandler extends UnicastRemoteObject 
			implements FileHandler{

	

	public LocalFileHandler() throws RemoteException {
	}

	private static final long serialVersionUID = -3859020810756809252L;

	

	@Override
	public String view(String id) throws RemoteException {
		return FileViewer.view(id);
	}

	@Override
	public boolean save(String id, String file) throws RemoteException {
		return FileUpdater.create(id, file);
	}

	@Override
	public boolean delete(String id) throws RemoteException {
		return FileUpdater.delete(id);
	}

	@Override
	public boolean replace(String id, String file) throws RemoteException {
		return FileUpdater.rewrite(id, file);
	}

	@Override
	public List<String> listfiles() throws RemoteException {
		String[] array = FileViewer.getList();
		return Arrays.asList(array);
	}

	@Override
	public boolean rebankup(String id, String file) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

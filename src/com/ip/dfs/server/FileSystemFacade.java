package com.ip.dfs.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.ip.dfs.bankup.BankupStrategy;
import com.ip.dfs.common.ConfigureParameter;
import com.ip.dfs.common.FileHandler;
import com.ip.dfs.common.Node;
import com.ip.dfs.hash.ConsistentHashing;
import com.ip.dfs.service.DFSService;

public class FileSystemFacade extends UnicastRemoteObject
		implements DFSService{

	
	private static final long serialVersionUID = -6171017319653590499L;

	private ConfigureParameter configureParameter;
	
	private FileHandlerFactory factory;
	
	private ConsistentHashing hash;
	
	private BankupStrategy bankup;
	
	public FileSystemFacade() throws RemoteException {
		super();
		configureParameter = ConfigureParameter.getInstance();
		factory = new FileHandlerFactory();
		hash = configureParameter.getHashStrategy();
		bankup = configureParameter.getBankupStrategy();
	}

	@Override
	public String view(String id) throws RemoteException {
		FileHandler fileHandler = _getFileHandler(id);
		return fileHandler.view(id);
	}

	private String _generateId() {
		
		return Thread.currentThread().getId()
				+new Random().nextLong()
				+UUID.randomUUID().toString();
	}
	
	private FileHandler _getFileHandler(String id) {
		Node dataNode = hash.hash(id);
		FileHandler fileHandler = factory.getHandler(dataNode);
		return fileHandler;
	}
	
	@Override
	public String save(String file) throws RemoteException {
		String id = _generateId();
		FileHandler fileHandler = _getFileHandler(id);
		if( fileHandler.save(id, file)) {
			List<Node> nodes = bankup.getBankupNodes(id);
			for (Node node: nodes) {
				factory.getHandler(node).save(id, file);
			}
			return id;
		}
		return null;
	}

	@Override
	public boolean delete(String id) throws RemoteException {
		FileHandler fileHandler = _getFileHandler(id);
		return fileHandler.delete(id);
	}

	@Override
	public boolean replace(String id, String file) throws RemoteException {
		FileHandler fileHandler = _getFileHandler(id);
		return fileHandler.replace(id, file);
	}

	@Override
	public boolean recovery() throws RemoteException {
		return false;
	}

}

package com.ip.dfs.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.ip.dfs.common.Constant;
import com.ip.dfs.common.Node;
import com.ip.dfs.common.FileHandler;

public class FileHandlerFactory {

	public FileHandler getHandler(Node node) {
		if (node.getFileHandler()!=null)
			return node.getFileHandler();
		
		try {
			FileHandler filehandler =(FileHandler) Naming.lookup(
					"rmi://"+node.getIp()+":"+node.getPort()+"/"+Constant.LOCAL_FILE_HANDLER);
			node.setFileHandler(filehandler);
			return filehandler;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		} 
		return null;
	}
}

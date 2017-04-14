package com.ip.dfs.client;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.ip.dfs.common.ConfigureParameter;
import com.ip.dfs.common.Constant;
import com.ip.dfs.common.FileHandler;
import com.ip.dfs.common.Node;

public class Client {
	
	public void register(Remote service,Node node, String name) {
		 try { 
	            LocateRegistry.createRegistry(node.getPort()); 
	            Naming.bind("rmi://"+node.getIp()+":"+node.getPort()+"/"+name, service); 
	        } catch (RemoteException e) { 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } 
	} 
	
	
	public void register() {
	 	try {
			FileHandler fileHandler = new LocalFileHandler();
			register(fileHandler, 
					ConfigureParameter.getInstance().getThisNode(), Constant.LOCAL_FILE_HANDLER);
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		new Client().register();
	}
}

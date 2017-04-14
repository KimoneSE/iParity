package com.ip.dfs.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.ip.dfs.common.ConfigureParameter;
import com.ip.dfs.common.Constant;
import com.ip.dfs.common.Node;
import com.ip.dfs.service.DFSService;

public class Server {

	public static void main(String[] args) {
		new Server().register();
	}
	
	public void register(Remote service,Node node, String name) {
		 try { 
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(node.getPort()); 
	            //把远程对象注册到RMI注册服务器上
	            Naming.bind("rmi://"+node.getIp()+":"+node.getPort()+"/"+name, service); 
	            System.out.println(">>>>>INFO:远程IHello对象绑定成功！"); 
	        } catch (RemoteException e) { 
	            System.out.println("创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        } 
	} 
	
	
	public void register() {
	 	try {
			DFSService service = new FileSystemFacade();
			register(service, 
					ConfigureParameter.getInstance().getFacadeServer(), 
					Constant.DFS_SERVICE_FACADE);
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
	}
}

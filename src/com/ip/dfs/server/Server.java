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
	            //���������ϵ�Զ�̶���ע���Registry��ʵ������ָ���˿�Ϊ8888����һ���ز����٣�JavaĬ�϶˿���1099�����ز���ȱ��һ����ȱ��ע����������޷��󶨶���Զ��ע����� 
	            LocateRegistry.createRegistry(node.getPort()); 
	            //��Զ�̶���ע�ᵽRMIע���������
	            Naming.bind("rmi://"+node.getIp()+":"+node.getPort()+"/"+name, service); 
	            System.out.println(">>>>>INFO:Զ��IHello����󶨳ɹ���"); 
	        } catch (RemoteException e) { 
	            System.out.println("����Զ�̶������쳣��"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("�����ظ��󶨶����쳣��"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("����URL�����쳣��"); 
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

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

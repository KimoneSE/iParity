package com.ip.dfs.tool;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import com.ip.dfs.common.Node;

public class Tool {

	public static void main(String[] args) {
	}
	
	public static Node getIP(List<Node> nodes) throws SocketException {
		
		Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		
		HashMap<String,Node> set = new HashMap<String,Node>();
		for(Node node: nodes) {
			set.put(node.getIp(), node);
		}
		
		while (allNetInterfaces.hasMoreElements())
		{
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
//			System.out.println(netInterface.getName());
			Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements())
			{
				ip = (InetAddress) addresses.nextElement();
				if (ip != null && ip instanceof Inet4Address)
				{
//						System.out.println("±¾»úµÄIP = " + ip.getHostAddress());
						Node node = set.get(ip.getHostAddress());
						if(node!=null)
							return node;
				} 
			}
		}
		
		throw new Error("no matched ip");

	}
}

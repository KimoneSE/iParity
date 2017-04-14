package com.ip.dfs.common;

public class Node {

	private String ip;

	private int port;
	
	private String path;
	
	private transient boolean isOn = true;
	
	private transient Node next;
	
	private transient FileHandler fileHandler;
	
	
	
	public FileHandler getFileHandler() {
		return fileHandler;
	}

	public void setFileHandler(FileHandler fileHandler) {
		this.fileHandler = fileHandler;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Object){
			Node node = (Node)o;
			return this.ip.equals(node.ip) && this.port==node.port;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Node [ip=" + ip + ", port=" + port + ", path=" + path + "]";
	}
	
	
}

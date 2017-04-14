package com.ip.dfs.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ip.dfs.bankup.BankupStrategy;
import com.ip.dfs.bankup.DefaultBankupStrategy;
import com.ip.dfs.hash.ConsistentHashing;
import com.ip.dfs.hash.DefaultConsistentHashing;
import com.ip.dfs.tool.Tool;

public class ConfigureParameter {
	
	private List<Node> fileServers;
	
	private Node facadeServer;
	
	private Node thisNode;
	
	private transient BankupStrategy bankupStrategy;
	
	private transient ConsistentHashing hashStrategy;
	
	private transient static volatile ConfigureParameter instance;
	
	private transient static String CONFIG_PATH = "config.json";
	
	private ConfigureParameter() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonNode = 
					objectMapper.readTree(new File(CONFIG_PATH));
//			System.out.println(jsonNode);
//			System.out.println(jsonNode.get("fileServers"));
			
			facadeServer = objectMapper.readValue(jsonNode.get("facadeServer").toString(), Node.class);
			
			fileServers = objectMapper.readValue(
					jsonNode.get("fileServers").toString(), 
					 new TypeReference<List<Node>>(){}
					);
			/**Á´**/
			for(int i=0; i<fileServers.size()-1; i++) 
				fileServers.get(i).setNext(fileServers.get(i+1));
			fileServers.get(fileServers.size()-1).setNext(fileServers.get(0));
			
			thisNode = Tool.getIP(fileServers);
			
			bankupStrategy = new DefaultBankupStrategy(this);
			hashStrategy = new DefaultConsistentHashing(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Node getThisNode() {
		return thisNode;
	}

	public void setThisNode(Node thisNode) {
		this.thisNode = thisNode;
	}

	public Node getFacadeServer() {
		return facadeServer;
	}

	public void setFacadeServer(Node facadeServer) {
		this.facadeServer = facadeServer;
	}

	public List<Node> getFileServers() {
		return fileServers;
	}

	public void setFileServers(List<Node> fileServers) {
		this.fileServers = fileServers;
	}

	public BankupStrategy getBankupStrategy() {
		return bankupStrategy;
	}

	public void setBankupStrategy(BankupStrategy bankupStrategy) {
		this.bankupStrategy = bankupStrategy;
	}

	public ConsistentHashing getHashStrategy() {
		return hashStrategy;
	}

	public void setHashStrategy(ConsistentHashing hashStrategy) {
		this.hashStrategy = hashStrategy;
	}

	public static ConfigureParameter getInstance() {
		
		if (instance==null) {
			instance = new ConfigureParameter();
		}
		return instance;
	}

	public static void setInstance(ConfigureParameter instance) {
		ConfigureParameter.instance = instance;
	}
	
	
}

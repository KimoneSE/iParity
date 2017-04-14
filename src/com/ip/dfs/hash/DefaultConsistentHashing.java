package com.ip.dfs.hash;

import com.ip.dfs.common.ConfigureParameter;
import com.ip.dfs.common.Node;

public class DefaultConsistentHashing implements ConsistentHashing{

	private ConfigureParameter config;
	
	
	public DefaultConsistentHashing(ConfigureParameter configureParameter) {
		config = configureParameter;
	}

	@Override
	public Node hash(String id) {
		int index = (config.getFileServers().size()-1) & id.hashCode();
		Node node = config.getFileServers().get(index);
		while(!node.isOn()) node = node.getNext();
		if(!node.isOn()) throw new Error("no workable datanode!");
		return node;
	}
}

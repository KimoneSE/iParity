package com.ip.dfs.bankup;

import java.util.ArrayList;
import java.util.List;

import com.ip.dfs.common.ConfigureParameter;
import com.ip.dfs.common.Node;

public class DefaultBankupStrategy implements BankupStrategy{

	private ConfigureParameter config ;
	
	public DefaultBankupStrategy(ConfigureParameter config) {
		this.config = config;
	}
	
	@Override
	public List<Node> getBankupNodes(String id) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		int hash = id.hashCode();
		int saveIndex = (config.getFileServers().size()-1)&hash;
		int bankupIndex = saveIndex;
		int maxloop = 10;
		while (bankupIndex==saveIndex){ 
			bankupIndex = (config.getFileServers().size()-1) & (hash = hash>>>1);
			if(--maxloop<1) return nodes;
		}
		Node bankupNode = config.getFileServers().get(bankupIndex);
		nodes.add(bankupNode);
		return nodes;
	}

}

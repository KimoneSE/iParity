package com.ip.dfs.bankup;

import java.util.List;

import com.ip.dfs.common.Node;

public interface BankupStrategy {
	
	List<Node> getBankupNodes(String id);
}

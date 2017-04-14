package com.ip.dfs.hash;

import com.ip.dfs.common.Node;

public interface ConsistentHashing {
	
	Node hash(String id);
}

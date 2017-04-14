package com.ip.dfs.client.file;

import com.ip.dfs.common.ConfigureParameter;

public class FileTool {

	private static String dirString ;
	static {
		dirString = ConfigureParameter.getInstance().getThisNode().getPath();
		if(!dirString.endsWith("/")&&!dirString.endsWith("\\")) {
			dirString = dirString+"/";
		}
	}
		
	
	public static String getPath(String id) {
		return dirString+id;
	}
	
	public static String getDir() {
		return dirString;
	}
}

package com.ip.dfs.client.file;

import java.io.File;
import java.io.FileReader;

public class FileViewer {

	public static String[] getList() {
		String dirString = FileTool.getDir();
		File f = new File(dirString);
		if(f.isDirectory()) {
			return f.list();
		}
		throw new Error("no dir named: "+dirString);
	}
	
	public static String view(String id) {
		String path = FileTool.getPath(id);
		StringBuilder stringBuilder = new StringBuilder("");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(path);
			
			char[] buf = new char[1024];
			int len ;
			while( (len = fileReader.read(buf)) != -1) {
				stringBuilder.append(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (fileReader!=null) {
					fileReader.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return stringBuilder==null? null : stringBuilder.toString();
	}
	
}

package com.ip.dfs.client.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUpdater {

	public static boolean delete(String id) {
		String path = FileTool.getPath(id);
		File f = new File(path);
		if(f.isFile())
			return f.delete();
		return false;
	}
	
	public static boolean create(String id, String file) {
		String path = FileTool.getPath(id);
		File f = new File(path);
		if (f.exists()){
			return false;
		}
		
		return _write(f, file);
	}
	
	public static boolean rewrite(String id, String file) {
		String path = FileTool.getPath(id);
		File f = new File(path);
		if (!f.exists()){
			return false;
		}
		return _write(f, file);
	}
	
	public static boolean write(String id, String file) {
		String path = FileTool.getPath(id);
		File f = new File(path);
		if (!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return _write(f, file);
	}
	
	private static boolean _write(File f, String file) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(f));
			bufferedWriter.write(file);
			f.createNewFile();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

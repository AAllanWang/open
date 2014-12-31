package com.wangwl.myfileexplorer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {
	public static void copy(File srcFile, File dstFile) throws IOException {
		if (srcFile.isFile()) {
			if (dstFile.isFile()) {
				FileInputStream input = new FileInputStream(srcFile);
				FileOutputStream output = new FileOutputStream(dstFile);
				byte[] buffer = new byte[4096];
				int n = 0;
				while (-1 != (n = input.read(buffer))) {  
					output.write(buffer, 0, n);
					}
				output.close();
				input.close();
			} else if (dstFile.isDirectory()) {
				File newDstFile = new File(dstFile.getAbsolutePath()+File.separator+srcFile.getName());
				newDstFile.createNewFile();
				copy(srcFile,newDstFile);
			}
		} else if (srcFile.isDirectory()) {
			if(dstFile.isDirectory()){
				File newDstFile = new File(dstFile,srcFile.getName());
				newDstFile.mkdirs();
				File[] srcAllFiles = srcFile.listFiles();
				for(int i = 0;i<srcAllFiles.length;i++){
					copy(srcAllFiles[i],newDstFile);
				}
			}
		}
	}
	
	public static void delete(File file){
		if(file.isFile()){
			file.delete();
		}else if(file.isDirectory()){
			File[] files = file.listFiles();
			for(int i = 0;i<files.length;i++){
				delete(files[i]);
			}
			file.delete();
		}
	}
}

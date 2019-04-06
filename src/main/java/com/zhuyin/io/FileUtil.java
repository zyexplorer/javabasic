package com.zhuyin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <p>Title: FileUtil.java</p>
 * <p>Description: 文件工具类，提供文件读取和写入的方法</p>
 * <p>Company: </p>
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2018年4月30日  上午10:22:47 
 * @version v1.0
 */
public class FileUtil {
	
	/**
	 * <p>Description：指定文件，读取内容到StringBuilder对象中</p>  
	 * @param file
	 * @return
	 */
	public static String readFileContent(File file){
		BufferedReader bufferedReader = null;
		StringBuilder sb = new StringBuilder();
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = bufferedReader.readLine();
			while(line != null){
				sb.append(line + "\r\n");
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeAll(bufferedReader);
		}
		return sb.toString();
	}
	
	/**
	 * <p>Description：从源文本文件拷贝内容写到目标文件中</p>  
	 * @param source
	 * @param target
	 * @return true:成功   false:失败
	 */
	public static boolean copy(File source,File target){
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		StringBuilder sb = new StringBuilder();
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target)));
			String line = bufferedReader.readLine();
			while(line != null){
				String newLine = line + "\r\n";
				sb.append(newLine);
				bufferedWriter.write(newLine.toCharArray(),0,newLine.toCharArray().length);
				line = bufferedReader.readLine();
			}
			bufferedWriter.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeAll(bufferedWriter,bufferedReader);
		}
	}
	
	
	
	
	
	
	
	/**
	 * <p>Description：可变参数的关闭资源方法</p>  
	 * @param closeables
	 */
	private static void closeAll(Closeable... closeables) {
		for (Closeable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}

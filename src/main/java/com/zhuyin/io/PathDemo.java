package com.zhuyin.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>Title: PathDemo.java</p>
 * <p>Description: javaweb工程文件路径问题</p>
 * <p>Company: </p>
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2018-4-30  下午12:07:12 
 * @version v1.0
 */
public class PathDemo {
	
	public static void main(String[] args) throws IOException {
		String path1 = PathDemo.class.getResource("/").getPath();
		System.out.println(path1);
		
		InputStream inputStream = PathDemo.class.getClassLoader().getResourceAsStream("files/a.txt");
		OutputStream outputStream = new FileOutputStream(new File("src/main/resources/files/e.txt"));
		
		copyFile(inputStream,outputStream);
		outputStream.flush();
		outputStream.close();
		inputStream.close();
		/*File file = new File("src/main/resources/files/a.txt");
		System.out.println(file.getAbsolutePath());
		
		System.out.println("=============");
		FileUtils.copyFile(file, new File("src/main/resources/files/c.txt"));
		
		try {
			FileUtils.copyFile(file, new File("src/main/resources/files/d.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}

	private static void copyFile(InputStream inputStream,OutputStream outputStream) throws IOException {
		byte[] bs = new byte[1024];
		while(inputStream.read(bs) != -1){
			outputStream.write(bs);
		}
	}
}

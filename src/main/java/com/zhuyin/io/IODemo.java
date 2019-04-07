package com.zhuyin.io;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Test;

public class IODemo {
	
	public static void main(String[] args) {
		
	}

	
	/**
	 * <p>Description：接收从键盘录入的字符串</p>  
	 */
	@Test
	public void getStrFromKeyboard(){
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入一串字符：");
		try {
			String line = bufferedReader.readLine();
			System.out.println("读取到的字符串为：" + line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Description：从指定文件中读取一行</p>  
	 */
	@Test
	public void getLineFromFile(){
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("a.txt"))));
			String line = bufferedReader.readLine();
			System.out.println("读取到的字符串为：" + line);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeAll(bufferedReader);
		}
	}
	
	
	/**
	 * <p>Description：从指定文件中读取所有行</p>  
	 */
	@Test
	public void getStrFromFile(){
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("a.txt"))));
			StringBuilder sb = new StringBuilder();
			String line = bufferedReader.readLine();
			while(line != null){
				sb.append(line + "\r\n");
				line = bufferedReader.readLine();
			}
			System.out.printf("文件内容为:\n %s" , sb);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeAll(bufferedReader);
		}
	}
	
	
	/**
	 * <p>Description：往指定文件中写入数据</p>
	 */
	@Test
	public void testWriteToFile() {
		OutputStream outputStream = null;
		try {
			// 1.创建输入流对着指定文件
			outputStream = new FileOutputStream("a.txt");
			// 2.将字符串变成字节数组写入
			String str = "你好123";
			outputStream.write(str.getBytes(), 0, str.getBytes().length);
			// 3.关闭流
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(outputStream);
		}
	}

	/**
	 * <p>Description：读取一个A文件中的数据写入到另一个B文件中</p>
	 * 
	 * @throws IOException
	 */
	@Test
	public void testWriteAtoB() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream("a.txt");
			byte[] bs = new byte[1024];
			int len;
			outputStream = new FileOutputStream(new File("b.txt"));
			while ((len = inputStream.read(bs, 0, bs.length)) != -1) {
				outputStream.write(bs, 0, len);
			}
			outputStream.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(outputStream, inputStream);
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

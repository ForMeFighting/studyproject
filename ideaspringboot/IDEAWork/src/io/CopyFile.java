package io;

import java.io.*;

/**
 * @Auther: 柴俊杰
 * @Description: 文件的拷贝
 * @Date: 2019/11/14 11:19
 */
public class CopyFile {
	public static void main(String[] args) {
		File source = new File("E:" + File.separator + "my.log");
		File dest = new File("E:" + File.separator + "my1.log");
		BufferedInputStream input = null;
		BufferedOutputStream output = null;
		try {
			input = new BufferedInputStream(new FileInputStream(source));
			output = new BufferedOutputStream(new FileOutputStream(dest));
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}

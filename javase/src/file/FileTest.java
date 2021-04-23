package file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: 柴俊杰
 * @Description: file类测试
 * @Date: 2021/4/21 16:03
 */
public class FileTest {
	public static void main(String[] args) {
		File file = new File("d:\\a.txt");
		try {
			boolean newFile = file.createNewFile();
			System.out.println(newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String name = file.getName();
		file.renameTo(new File("d:/bb.txt"));
		String property = System.getProperty("user.dir");
		System.out.println(property);
		boolean exists = file.exists();
		boolean directory = file.isDirectory();
		boolean file1 = file.isFile();
		String path = file.getPath();
		Date date = new Date(file.lastModified());
		file.mkdirs();
		File file2 = new File("d:/");
		fileTree(file2,0);
	}
	public static void fileTree(File file,int level){
		for (int i = 0; i < level; i++) {
			System.out.println("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (File temp:files) {
				fileTree(temp,level+1);
			}
		}

	}
}

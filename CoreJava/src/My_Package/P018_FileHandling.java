package My_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//FileInputStream -> to read data
//FileOutputStream - > to write data
//FileWriter
//FileReader
public class P018_FileHandling {
	public static void main(String[] args) throws IOException {
		String msg = "this msg will be stored in file";
		FileOutputStream fos = new FileOutputStream("t1.txt");
		byte b[] = msg.getBytes();
		fos.write(b);
		fos.flush();
		fos.close();
		System.out.println("Data written successfully");
		
		FileInputStream fis = new FileInputStream("t1.txt");
		int i;
		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
		}
		
	}
}

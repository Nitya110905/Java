package My_Package;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P019_Filewriter {
		public static void main(String[] args) throws IOException {
			String msg = "msg by file writer and reader class";
			FileWriter fw = new FileWriter("t2.txt");
			fw.write(msg);
			fw.flush();
			fw.close();
			System.out.println("done");
			
			FileReader fr =new FileReader("t2.txt");
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}

	}
}

package File;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class copie {
	public static void main(String[] args) {
		
		try {

			File inputFile = new File("C:\\Users\\marcl\\Documents\\Ecole\\Java\\TD5\\src\\in.txt");
			File outPutFile = new File("C:\\Users\\marcl\\Documents\\Ecole\\Java\\TD5\\src\\out.txt");
			
			FileReader in = new FileReader(inputFile);
			FileWriter out = new FileWriter(outPutFile);
			
			int c;
			while((c=in.read())!=-1) {
				out.write(c);
			}
			in.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

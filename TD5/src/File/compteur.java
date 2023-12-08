package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class compteur {

	public static void main(String[] args) {
		
		String filename = "C:\\\\Users\\\\marcl\\\\Documents\\\\Ecole\\\\Java\\\\TD5\\\\src\\\\in.txt";
		try {
			countMethod(filename);
		} catch (Exception e) {
			System.out.println("Impossible d'ouvrir le fichier " + filename);
		}
	}
	
	public static void countMethod(String filename) throws IOException{
		String line = "";
		int nbLines = 0;
		int nbWords = 0;
		int nbChar = 0;
		StringTokenizer st = null;
		BufferedReader br;
		br = new BufferedReader(new FileReader(filename));
		line = br.readLine();
		
		while(line != null) {
			st = new StringTokenizer(line);
			nbLines++;
			nbWords += st.countTokens();
			nbChar += line.length()+1;
			line = br.readLine();
		}
		br.close();
		System.out.println("Le nombre de lignes: " + nbLines);
		System.out.println("Le nombre de mots: " + nbWords);
		System.out.println("Le nombre de caractères: " + nbChar);
	}

}

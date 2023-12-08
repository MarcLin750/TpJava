package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class authent {

	public static void main(String[] args) {
		String ligne;
		BufferedReader br; // objet BufferedReader pour lire les lignes
		boolean test = false;
		
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\marcl\\Documents\\Ecole\\Java\\TD5\\src\\in.txt"));
			String login = lireMot("Entrez le login: ");
			String password = lireMot("Entrez votre mot de passe: ");
			ligne = br.readLine();
			
			while(ligne != null) {
				String[] mots = ligne.split(" ");
				if(mots[0].equals(login)&&mots[1].equals(password)) {
					test = true;
					break;
				} else {
					ligne = br.readLine();
				}
			}

			br.close();
			
			if(test == true) {
				System.out.println("Authentification réussie.");
			} else {
				System.out.println("PB Autjentification !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String lireMot(String msg)throws IOException {
		BufferedReader saisieUtilisateur;
		saisieUtilisateur = new BufferedReader(new InputStreamReader(System.in));		
		System.out.println(msg);
		return saisieUtilisateur.readLine();
	}

}

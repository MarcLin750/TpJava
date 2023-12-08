package File;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pageAuth extends Frame {

	Label titleLog = new Label("------------ Log In ------------");
	Label login = new Label("Login: ");
	Label passWord = new Label("Pass word: ");
	TextField txtLogin = new TextField(20);
	TextField txtPassWord = new TextField(20);
	Button auth = new Button("Log in");
	Button quitter = new Button("Leave");
	JLabel lblErreur = new JLabel("...");
	
	
	public pageAuth() {
		this.setLayout(new BorderLayout());
		
		JPanel jPanelTitle = new JPanel();
		jPanelTitle.setLayout(new FlowLayout());
		jPanelTitle.add(titleLog);
		this.add(jPanelTitle, BorderLayout.NORTH);
		
		JPanel jPanelLog = new JPanel();
		jPanelLog.setLayout(new FlowLayout());
		jPanelLog.add(login);
		jPanelLog.add(txtLogin);
		jPanelLog.add(passWord);
		jPanelLog.add(txtPassWord);
		jPanelLog.add(auth);
		jPanelLog.add(quitter);
		this.add(jPanelLog, BorderLayout.CENTER);
		
		this.add(lblErreur, BorderLayout.SOUTH);
		
		this.setBounds(20, 20, 260, 250);
		this.setVisible(true);
		
		auth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ligne;
				BufferedReader br; // objet BufferedReader pour lire les lignes
				boolean test = false;
				String login = txtLogin.getText();
				String password = txtPassWord.getText();
				
				try {
					br = new BufferedReader(new FileReader("C:\\Users\\marcl\\Documents\\Ecole\\Java\\TD5\\src\\in.txt"));
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
						lblErreur.setText("Authentification réussie.");
					} else {
						lblErreur.setText("PB Autjentification !");
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		pageAuth fenetre = new pageAuth();
	}
	
}

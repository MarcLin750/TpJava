package File;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application_Interface_Authentification extends Frame implements ActionListener {
	Label lbl1, lbl2, resultat, entete;
	Button btn1;
	TextField txt1, txt2;
	
	Application_Interface_Authentification(){
		super("Authentification");
		this.setLayout(new BorderLayout());
		Panel pnorth = new Panel();
		pnorth.setLayout(new FlowLayout());
		entete = new Label ("------Authentification------");
		pnorth.add(entete);
		this.add(pnorth, BorderLayout.NORTH);
		Panel pcenter = new Panel();
		pcenter.setLayout(new GridLayout(2,2));
		lbl1=new Label("Login"); pcenter.add(lbl1);
		txt1=new TextField(); pcenter.add(txt1);
		lbl2=new Label("Mot de passe"); pcenter.add(lbl2);
		txt2=new TextField(); pcenter.add(txt2);
		this.add(pcenter, BorderLayout.CENTER);
		Panel psouth = new Panel();
		psouth.setLayout(new GridLayout(2,1));
		btn1=new Button("Authentification"); psouth.add(resultat);
		btn1.addActionListener(this);
		resultat=new Label("------"); psouth.add(resultat);
		this.add(psouth,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setBounds(10,10,550,250);
		this.pack();
	}

	public static void main(String[] args) {
		new Application_Interface_Authentification();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

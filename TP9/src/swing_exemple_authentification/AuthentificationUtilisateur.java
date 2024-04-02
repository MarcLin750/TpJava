package swing_exemple_authentification;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AuthentificationUtilisateur extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JLabel label;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthentificationUtilisateur frame = new

							AuthentificationUtilisateur();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public AuthentificationUtilisateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1014, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		lblNewLabel.setBounds(350, 13, 350, 120);
		contentPane.add(lblNewLabel);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setBounds(350, 170, 281, 68);
		contentPane.add(textField);
		textField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(350, 286, 281, 68);
		contentPane.add(passwordField);
		JLabel lblUsername = new JLabel("identifiant");
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblUsername.setBounds(150, 166, 193, 52);
		contentPane.add(lblUsername);
		JLabel lblPassword = new JLabel("mot de passe");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblPassword.setBounds(150, 286, 193, 52);
		contentPane.add(lblPassword);
		btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.setBounds(400, 420, 162, 80);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String identifiant = textField.getText();
				String mdp = passwordField.getText();

				try {
					Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/tp9", "root", "");
					PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select nom, mdp from etudiant where nom=? and mdp=?");
									st.setString(1, identifiant);
									st.setString(2, mdp);
									ResultSet rs = st.executeQuery();
									if (rs.next()) {
										dispose();
										AccueilUtilisateur ah = new AccueilUtilisateur(identifiant);
										ah.setTitle("Bienvenue");
										ah.setVisible(true);
										JOptionPane.showMessageDialog(btnNewButton, " Vous vous êtes connecté avec succès");
									} else {
										JOptionPane.showMessageDialog(btnNewButton, "identifiant et mot de passe erronés");
									}
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		label = new JLabel("");
		label.setBounds(0, 0, 1008, 562);
		contentPane.add(label);
	}
}
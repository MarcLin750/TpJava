package Metier;

import java.util.List;

import java.sql.*;

public class MetierCatalogueImp implements IMetier {

	public void addCategorie(categorie c) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into categorie (nomCategorie) values (?)");
			ps.setString(1, c.getNomCategorie());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(produit p, int idCategorie) {
		
	}

	@Override
	public List<produit> getProduitParmotcle(String mc) {
		
		return null;
	}

	@Override
	public List<produit> getProduitParIdCategorie(int idCategorie) {
		
		return null;
	}

	@Override
	public List<categorie> getAllCategorie() {
		
		return null;
	}

	@Override
	public categorie getCategorie(int idCategorie) {
		
		return null;
	}

}

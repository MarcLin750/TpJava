package Metier;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class MetierCatalogueImp implements IMetier {

	public void addCategorie(categorie c) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO categorie (nomCategorie) VALUES (?)");
			ps.setString(1, c.getNomCategorie());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(produit p, int idCategorie) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO produit (idCategorie, designationProduit) VALUES (?, ?)");
			ps.setInt(1, idCategorie);
			ps.setString(2, p.getDesignationProduit()); 
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<produit> getProduitParMotCle(String mc) {
		Connection conn = SingletonConnection.getConnection();
		List<produit> Produits = new ArrayList<>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SECET * FROM produits WHERE nomProduit LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				produit pd = new produit();
				pd.setIdProduit(rs.getString("idProduit"));
				pd.setDesignationProduit(rs.getString("designationProduit"));
				pd.setPrix(rs.getDouble("prix"));
				pd.setQuantite(rs.getInt("quantite"));
				pd.setIdCategorie(rs.getInt("idCategorie"));
				Produits.add(pd);
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Produits;
    }
	
	@Override
	public List<categorie> getAllCategorie() {
		Connection conn = SingletonConnection.getConnection();
		List<categorie> Categories = new ArrayList<>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM categorie");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				categorie Categorie = new categorie();
				
				Categorie.setIdCategorie(rs.getInt("id"));
				Categorie.setNomCategorie(rs.getString("nom"));
				
				Categories.add(Categorie);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<produit> getProduitParIdCategorie(int idCategorie) {
		
		return null;
	}

	@Override
	public categorie getCategorie(int idCategorie) {
		
		return null;
	}

}

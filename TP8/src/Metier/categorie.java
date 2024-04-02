package Metier;
import java.util.ArrayList;
import java.util.List;

public class categorie {
	private int idCategorie;
	private String nomCategorie;
	private List<produit> produits;
	
	public categorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
		this.produits = new ArrayList<produit>();
	}

	public categorie() {
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public List<produit> getProduits() {
		return produits;
	}

	public void setProduits(List<produit> produits) {
		this.produits = produits;
	}
	
}


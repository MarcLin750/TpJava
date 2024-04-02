package Metier;

import java.util.List;

public interface IMetier {
	
	public void addCategorie(categorie c);
	
	public void addProduct(produit p, int idCategorie);
	
	public List<produit> getProduitParMotCle(String mc);

	public List<categorie> getAllCategorie();
	
	public List<produit> getProduitParIdCategorie(int idCategorie);
	
	public categorie getCategorie(int idCategorie);
	
}

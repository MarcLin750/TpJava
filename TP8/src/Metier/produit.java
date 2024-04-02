package Metier;

public class produit {
	private String idProduit;
	private String designationProduit;
	protected double prix;
	protected int quantite;
	protected int idCategorie;
	
	public produit(String idProduit, String designationProduit, double prix, int quantite, int idCategorie) {
		this.idProduit = idProduit;
		this.designationProduit = designationProduit;
		this.prix = prix;
		this.quantite = quantite;
		this.idCategorie = idCategorie;
	}
	
	public produit() {
		
	}
	
	public String getIdProduit() {
		return this.idProduit;
	}
	
	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}
	
	public String getDesignationProduit() {
		return this.designationProduit;
	}
	
	public void setDesignationProduit(String designationProduit) {
		this.designationProduit = designationProduit;
	}
	
	public double getPrix() {
		return this.prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public int getQuantite() {
		return this.quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public int getIdCategorie() {
		return idCategorie;
	}
	
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	
}

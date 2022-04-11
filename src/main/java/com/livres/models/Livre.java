package com.livres.models;



public class Livre {

	private Integer ISBN;
	private String  titre;
	private String description;
	private String  date_edition; 
	private String editeur;
	private Integer matricule;
	
	
	public Livre() {
		
	}



	public Integer getISBN() {
		return ISBN;
	}



	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getDate_edition() {
		return date_edition;
	}



	public void setDate_edition(String date_edition) {
		this.date_edition = date_edition;
	}



	public String getEditeur() {
		return editeur;
	}



	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}



	public Integer getMatricule() {
		return matricule;
	}



	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}
	
	

}

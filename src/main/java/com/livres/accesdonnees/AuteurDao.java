package com.livres.accesdonnees;

import java.util.List;

import com.livres.models.Auteur;


public interface AuteurDao {
	
	 void ajouterAuteur(Auteur auteur);
	  
	 List<Auteur> lister();
	 
	 void supprimerAuteur(int Matricule);
	 
	 Auteur RechercherAuteur(int Matricule);
	 
	 void modifierAuteur(Auteur auteur);
}

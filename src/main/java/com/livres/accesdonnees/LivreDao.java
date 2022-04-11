package com.livres.accesdonnees;

import java.util.List;

import com.livres.models.Livre;

public interface LivreDao {

	 void ajouterLivre(Livre livre);
	  
	 List<Livre> lister();
	 
	 void supprimerLivre(int Isbn);
	 
	 List<Livre> RechercherLivre(String titre);
	 
	 void modifierLivre(Livre Livre);
	

}

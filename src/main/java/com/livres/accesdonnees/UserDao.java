package com.livres.accesdonnees;

import java.util.List;


import com.livres.models.User;

public interface UserDao {

	 void ajouterUser(User user);
	  
	 List<User> lister();
	 
	 void supprimerUser(String Login);
	 
	 User RechercherUser(String Login);
	 
	 void modifierUser(User user);
}

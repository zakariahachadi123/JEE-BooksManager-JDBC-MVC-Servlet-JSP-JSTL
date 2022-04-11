package com.livres.accesdonnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.livres.models.Auteur;



public class AuteurDaoImp implements AuteurDao {

	private DaoFactory daoFactory;
    
    public AuteurDaoImp(DaoFactory daoFactory) {
            this.daoFactory=daoFactory;
    }

    @Override
    public List<Auteur> lister() {
        List<Auteur> Auteurs = new ArrayList<Auteur>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion =daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT Matricule,Prenom,Nom,genre FROM Livre;");
                
            while (resultat.next()) {
                String Matricule= resultat.getString("Matricule");
                String Prenom = resultat.getString("Prenom");
                String Nom = resultat.getString("Nom");
                String Genre = resultat.getString("genre");
           
                Auteur auteur = new Auteur();
                auteur.setMatricule(Integer.valueOf(Matricule));
                auteur.setNom(Nom);
                auteur.setPrenom(Prenom);
                auteur.setGenre(Genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Auteurs;
    }





	@Override
	public void modifierAuteur(Auteur auteur) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion=daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("Update Auteur set Prenom=? ,Nom=?, Genre=?, Matricule=? ");
          
            preparedStatement.setString(1, auteur.getPrenom());
            preparedStatement.setString(2, auteur.getNom());
            preparedStatement.setString(3, auteur.getGenre());
            preparedStatement.setString(4, auteur.getMatricule().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void ajouterAuteur(Auteur auteur) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion=daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO Auteur (Prenom,Nom,Genre,Matricule)VALUES(?, ?, ?, ?);");
            preparedStatement.setString(1, auteur.getPrenom());
            preparedStatement.setString(2, auteur.getNom());
            preparedStatement.setString(3, auteur.getGenre());
            preparedStatement.setString(4, auteur.getMatricule().toString());
    

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void supprimerAuteur(int Isbn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Auteur RechercherAuteur(int Matr) {
		 Connection connexion = null;
	     Statement statement = null;
	     ResultSet resultat = null;
	     Auteur auteur = new Auteur();

	        try {
	            connexion =daoFactory.getConnection();        
	            statement = connexion.createStatement();            
	            resultat = statement.executeQuery("SELECT Matricule,Prenom,Nom,genre FROM Livre where="+Matr+";"); 
	            auteur.setMatricule(resultat.getInt("Matricule"));
	            auteur.setPrenom(resultat.getString("Prenom"));
	            auteur.setNom(resultat.getString("Nom"));
	            auteur.setGenre(resultat.getString("Genre"));
	            
	        }catch(SQLException e){
	        	
	        }
	  return auteur;
	}

}

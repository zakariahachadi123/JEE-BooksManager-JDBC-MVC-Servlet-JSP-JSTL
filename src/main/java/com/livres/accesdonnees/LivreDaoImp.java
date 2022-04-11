package com.livres.accesdonnees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.livres.models.Livre;

public class LivreDaoImp implements LivreDao{
	    private DaoFactory daoFactory;
        
	    public LivreDaoImp(DaoFactory daoFactory) {
	            this.daoFactory=daoFactory;
	    }

	    @Override
	    public List<Livre> lister() {
	        List<Livre> Livres = new ArrayList<Livre>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion =daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT Isbn,titre,description,date_edition,editeur,matricule FROM Livre;");
                    
	            while (resultat.next()) {
	                String Isbn= resultat.getString("Isbn");
	                String titre = resultat.getString("titre");
	                String description = resultat.getString("description");
	                String date_edition = resultat.getString("date_edition");
	                String editeur = resultat.getString("editeur");
	                String matricule = resultat.getString("matricule");
	                Livre livre = new Livre();
	                livre.setISBN(Integer.valueOf(Isbn));
	                livre.setTitre(titre);
	                livre.setDescription(description);
	                livre.setEditeur(editeur);
	                livre.setDate_edition(date_edition);
	                livre.setMatricule(Integer.valueOf(matricule));
	              	Livres.add(livre);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Livres;
	    }

		@Override
		public void ajouterLivre(Livre livre) {
			Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion=daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO Livre(Isbn,titre,description,date_edition,editeur,matricule)VALUES(?, ?, ?, ?, ?, ?);");
	            preparedStatement.setString(1, livre.getISBN().toString());
	            preparedStatement.setString(2, livre.getTitre());
	            preparedStatement.setString(3, livre.getDescription());
	            preparedStatement.setString(4, livre.getDate_edition().toString());
	            preparedStatement.setString(5, livre.getEditeur());
	            preparedStatement.setString(6, livre.getMatricule().toString());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}

		@Override
		public void supprimerLivre(int Isbn) {
			Connection connexion =null;
			PreparedStatement preparedStatement=null;
			try {
				 connexion=daoFactory.getConnection();
				 preparedStatement=connexion.prepareStatement("Delete from Livre where Isbn ="+Isbn+";");
				 preparedStatement.execute();
				 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public List<Livre> RechercherLivre(String Titre) {
			 Connection connexion = null;
		     PreparedStatement preparedStatement;
		     ResultSet resultat = null;
		     List<Livre> livres = new ArrayList<Livre>();

		        try {
		        	
		            connexion =daoFactory.getConnection();        
		            preparedStatement= connexion.prepareStatement("SELECT Isbn,titre,description,date_edition,editeur,matricule FROM Livre where titre=?;");     
		            preparedStatement.setString(1,Titre);
		            resultat = preparedStatement.executeQuery(); 
		            while(resultat.next()) {
		            Livre livre = new Livre();
		            livre.setISBN(resultat.getInt("Isbn"));     
		            livre.setTitre(resultat.getString("titre"));          
		            livre.setMatricule(resultat.getInt("matricule"));          
		            livre.setEditeur(resultat.getString("editeur"));          
		            livre.setDescription(resultat.getString("description"));           
		            livre.setDate_edition(resultat.getString("date_edition"));
		            livres.add(livre);
		            }
		        }catch(SQLException e){
		        	
		        }
		  return livres;
		}

		@Override
		public void modifierLivre(Livre livre) {
			Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion=daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("Update Livre set Isbn=? ,titre=?, description=?, date_edition=? ,editeur=? , matricule=? where Isbn="+livre.getISBN()+";");
	            preparedStatement.setString(1, livre.getISBN().toString());
	            preparedStatement.setString(2, livre.getTitre());
	            preparedStatement.setString(3, livre.getDescription());
	            preparedStatement.setString(4, livre.getDate_edition().toString());
	            preparedStatement.setString(5, livre.getEditeur());
	            preparedStatement.setString(6, livre.getMatricule().toString());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}

	}

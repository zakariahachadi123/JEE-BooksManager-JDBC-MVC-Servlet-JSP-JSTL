package com.livres.accesdonnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.livres.models.User;

public class UserDaoImp  implements UserDao{
	private DaoFactory daoFactory;
    
    public UserDaoImp(DaoFactory daoFactory) {
            this.daoFactory=daoFactory;
    }

    @Override
    public List<User> lister() {
        List<User> users = new ArrayList<User>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion =daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("Select Login,password,role from User;");
                
            while (resultat.next()) {
                User user = new User(); 
                user.setLogin(resultat.getString("Login"));
                user.setPassword(resultat.getString("password"));
                user.setRole(resultat.getString("role"));
              	users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

	@Override
	public void ajouterUser(User user) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion=daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO User(Login,password,role)VALUES(?, ?, ?);");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
         
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void supprimerUser(String Login) {
		Connection connexion =null;
		PreparedStatement preparedStatement=null;
		try {
			 connexion=daoFactory.getConnection();
			 preparedStatement=connexion.prepareStatement("Delete from User where Login ="+Login+";");
			 preparedStatement.execute();
			 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User RechercherUser(String Login) {
		 Connection connexion = null;
	     ResultSet resultat = null;
	     PreparedStatement preparedStatement=null;
	     User user = new User();

	        try {
	            connexion =daoFactory.getConnection();            
	            preparedStatement=connexion.prepareStatement("select Login,password,role from User Where Login=?;");
	            preparedStatement.setString(1,Login);
	            resultat=preparedStatement.executeQuery();
	            if(resultat.next()) {
	            user.setLogin(resultat.getString("Login"));
	            user.setPassword(resultat.getString("password"));
	            user.setRole(resultat.getString("role"));
	            }
	        }catch(SQLException e){
	        	
	        }
	  return user;
	}

	@Override
	public void modifierUser(User user) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion=daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("Update User set Login=? ,password=?, role=? where role="+user.getLogin()+";");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
           

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}

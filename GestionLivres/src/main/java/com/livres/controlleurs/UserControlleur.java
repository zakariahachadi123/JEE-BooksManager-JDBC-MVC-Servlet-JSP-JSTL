package com.livres.controlleurs;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.livres.accesdonnees.DaoFactory;
import com.livres.accesdonnees.LivreDao;
import com.livres.accesdonnees.UserDao;
import com.livres.models.User;


/**
 * Servlet implementation class UserControlleur
 */
@WebServlet("/User")
public class UserControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private LivreDao livreDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControlleur() {
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	userDao=daoFactory.getUserDao();
    	livreDao=daoFactory.getLivreDao();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        request.setAttribute("username", username);
   
        User user;
        user=userDao.RechercherUser(username);
        System.out.println("Password ::::::::::::::::::"+user.getPassword()+" essssssssst : "+password+"lll"+userDao.RechercherUser(username).getPassword()+username);
        if(!user.equals(null)) {
          if(password.equals(user.getPassword())) {
           HttpSession session = request.getSession();
   		   session.setAttribute("User", user);
           HttpSession userSession =request.getSession();
           userSession.setAttribute("Livres", livreDao.lister());
	       if(user.getRole().equals("admin")) {
 		   request.getRequestDispatcher("FormLivre.jsp").forward(request, response);
 	       }
 	       else if(user.getRole().equals("visiteur")) {
 		   request.getRequestDispatcher("ListeLivres.jsp").forward(request, response);
 	      }
        	   
          }
          else {
		   request.getRequestDispatcher("ErrorPassword.jsp").forward(request, response);}
        }else
        {
 		   request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
       
		
		doGet(request, response);
	}

}

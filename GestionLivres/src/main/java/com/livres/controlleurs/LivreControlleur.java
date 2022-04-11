package com.livres.controlleurs;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livres.accesdonnees.DaoFactory;
import com.livres.accesdonnees.LivreDao;
import com.livres.models.Livre;


/**
 * Servlet implementation class LivreControlleur
 */
@WebServlet("/Livre")
public class LivreControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivreDao livreDao;
       
    /**
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public LivreControlleur() {
    	
       DaoFactory daoFactory = DaoFactory.getInstance();
       livreDao=daoFactory.getLivreDao();
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
	 
    
      if(request.getParameter("enregistrer").equals("Ajouter")) {
         Livre livre = new Livre();
	     livre.setISBN(Integer.valueOf(request.getParameter("Isbn")));
	     livre.setTitre(request.getParameter("titre"));  livre.setDescription(request.getParameter("description"));
	     livre.setDate_edition(request.getParameter("date_edition"));  livre.setEditeur(request.getParameter("editeur"));
	     livre.setMatricule(Integer.valueOf(request.getParameter("matricule")));
	     livreDao.ajouterLivre(livre);
	     request.setAttribute("Livres",livreDao.lister());
	     request.getRequestDispatcher("FormLivre.jsp").forward(request, response);
	     }
       else if(request.getParameter("enregistrer").equals("recherche")) {
        	 request.removeAttribute("Livres");
    		 String titre=request.getParameter("search1");
    		 if(!titre.equals("")) {
    		 request.setAttribute("Livres",livreDao.RechercherLivre(titre));
    		 
    		 request.getRequestDispatcher("ListeLivres.jsp").forward(request, response);
    		 }else {
    			 request.getRequestDispatcher("ListeLivres.jsp").forward(request, response);	 
    		 }
    		 
    	    }
       
    	 
    
      
		
	  
	}

}

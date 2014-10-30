/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author loic
 */

@WebServlet(name = "getPrisonersServlet", urlPatterns = {"/getPrisonersServlet"})

public class getPrisonersServlet extends HttpServlet {
    
    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        Collection prisoners;
        prisoners = null;
        javax.naming.Context jndi_context;
        try {
            jndi_context = new javax.naming.InitialContext();
            NYCP_Session.PrisonerSessionRemote prisoner = (NYCP_Session.PrisonerSessionRemote) jndi_context.lookup("ejb/Prisoner+");
            prisoners = prisoner.getAllPrisoner();
        } catch (NamingException ex) {
            Logger.getLogger(getPrisonersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "prisoners", prisoners );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/takeConvictionDecision.jsp" ).forward( request, response );
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Servlet;

import NYCP_Entities.Motive;
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

@WebServlet(name = "createMotiveServlet", urlPatterns = {"/createMotiveServlet"})

public class createMotiveServlet extends HttpServlet {
    
    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String motiveLabel = request.getParameter( "motiveLabel" );
        
        String message;
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( motiveLabel.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs<br> <a href=\"crateMotive.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un motif.";
        } else {
            message = "Motif créé avec succès !";
        }
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        
        
        javax.naming.Context jndi_context;
        try {
            jndi_context = new javax.naming.InitialContext();
            NYCP_Session.MotiveSessionRemote motiveSession = (NYCP_Session.MotiveSessionRemote) jndi_context.lookup("ejb/Motive+");
            int collectionSize;
            collectionSize = motiveSession.getAllMotive().size();
            motiveSession.insertMotive(Integer.toString(collectionSize+1), motiveLabel);
        } catch (NamingException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Motive motive = new Motive();
        motive.setMotiveLabel(motiveLabel);
        
        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "motive", motive );
        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/getMotiveServlet" ).forward( request, response );
    }
}

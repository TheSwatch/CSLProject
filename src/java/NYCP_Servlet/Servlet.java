/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Servlet;

import NYCP_Entities.Prisoner;
import java.io.IOException;
import java.util.GregorianCalendar;
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
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})

public class Servlet extends HttpServlet {
    

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String num = request.getParameter("fileNumber");
        String nom = request.getParameter( "nom" );
        String prenom = request.getParameter( "prenom" );
        String place = request.getParameter( "place" );

        String message;
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( nom.trim().isEmpty() || num.trim().isEmpty() || prenom.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"index.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
        } else {
            message = "Client créé avec succès !";
        }
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        Prisoner prisoner = new Prisoner();
        prisoner.setDateOfBirth(new GregorianCalendar().getTime());
        prisoner.setGivenName(nom);
        prisoner.setPlaceOfBirth(place);
        prisoner.setPrisonFileNumber(num);
        prisoner.setSurname(prenom);
        javax.naming.Context jndi_context;
        try {
            jndi_context = new javax.naming.InitialContext();
            NYCP_Session.PrisonerSessionRemote prisoner1 = (NYCP_Session.PrisonerSessionRemote) jndi_context.lookup("ejb/Prisoner+");
            prisoner1.insertPrisoner(num, nom, prenom, new GregorianCalendar().getTime(), place);
        } catch (NamingException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "prisoner", prisoner );
        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/afficherClient.jsp" ).forward( request, response );
    }
}
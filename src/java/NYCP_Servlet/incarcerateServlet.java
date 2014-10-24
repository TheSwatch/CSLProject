/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Servlet;

import NYCP_Session.MotiveSessionRemote;
import NYCP_Session.UseCaseSessionRemote;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author loic
 */
@WebServlet(name = "incarcerateServlet", urlPatterns = {"/incarcerateServlet"})

public class incarcerateServlet extends HttpServlet {

    @EJB
    private UseCaseSessionRemote useCaseIncarcerate;
    @EJB
    private MotiveSessionRemote motiveSession;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String fileNumber = request.getParameter( "fileNumber" );
        String name = request.getParameter( "name" );
        String firstName = request.getParameter( "firstName" );
        String dateOB = request.getParameter( "dateOB" );
        String placeOB = request.getParameter( "placeOB" );
        String dIncarceration = request.getParameter( "dIncarceration" );
        String motive = request.getParameter( "motive" );
        String criminalCN = request.getParameter( "criminalCN" );
        String dateOCC = request.getParameter( "dateOCC" );
        String jName = request.getParameter( "jName" );
                
        String message;
        
         /* Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( fileNumber.trim().isEmpty() || name.trim().isEmpty() || firstName.trim().isEmpty() || dateOB.trim().isEmpty() || placeOB.trim().isEmpty() || dIncarceration.trim().isEmpty() || motive.trim().isEmpty() || criminalCN.trim().isEmpty() || dateOCC.trim().isEmpty() || jName.trim().isEmpty()){
            message = "Error - Empty fields !";
        } else {
            useCaseIncarcerate.incarcerate(fileNumber, name, firstName, new Date(dateOB), placeOB, new Date(dIncarceration), motiveSession.find(motive), criminalCN, new Date(dateOCC), jName);
            message = "Successful !";
        }

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/getMotiveServlet" ).forward( request, response );
    }
}
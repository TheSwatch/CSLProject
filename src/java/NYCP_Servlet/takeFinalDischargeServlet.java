
package NYCP_Servlet;

import NYCP_Session.UseCaseSessionRemote;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Loïc Irles
 */
@WebServlet(name = "takeFinalDischargeSevlet", urlPatterns = {"/takeFinalDischargeSevlet"})

public class takeFinalDischargeServlet extends HttpServlet {

    @EJB
    UseCaseSessionRemote useCase;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String tempDateDecision = request.getParameter("dateODecision");
        String prisonerFileNumber = request.getParameter( "prisoner" );
        String tempDateOFD = request.getParameter( "dateOFD" );
        String decisionType = request.getParameter( "decisionType" );
                
        String message;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateODecision = null;
        Date dateOFD = null;
        try {
            dateODecision = sdf.parse(tempDateDecision);
            dateOFD = sdf.parse(tempDateOFD);
        } catch (ParseException ex) {
            Logger.getLogger(takeFinalDischargeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         /* Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if (prisonerFileNumber.trim().isEmpty() || decisionType.trim().isEmpty() || dateODecision == null || dateOFD == null){
            message = "Error - Empty fields !";
        } else {
            useCase.takeFinalDischargeDecision(decisionType, prisonerFileNumber, dateODecision, dateOFD);
            message = "Successful !";
        }

        /* Ajout du message à l'objet requête */
        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/takeFinalDischargeDecision.jsp" ).forward( request, response );
    }

}

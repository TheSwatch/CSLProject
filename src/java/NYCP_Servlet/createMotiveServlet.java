
package NYCP_Servlet;

import NYCP_Session.MotiveSessionRemote;
import java.io.IOException;
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

@WebServlet(name = "createMotiveServlet", urlPatterns = {"/createMotiveServlet"})

public class createMotiveServlet extends HttpServlet {

    @EJB
    private MotiveSessionRemote motiveSession;
    
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
            message = "Error - Empty fields !";
        } else {
            int collectionSize;
            collectionSize = motiveSession.getAllMotive().size();
            motiveSession.insertMotive(Integer.toString(collectionSize+1), motiveLabel);
            message = "Successful !";
        }
                
        /* Ajout du message à l'objet requête */

        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/createMotive.jsp" ).forward( request, response );
    }
}

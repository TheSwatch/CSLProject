
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
 * @author Loïc Irles
 */

@WebServlet(name = "getUnderRemandServlet", urlPatterns = {"/getUnderRemandServlet"})

public class getUnderRemandServlet extends HttpServlet {

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
            prisoners = prisoner.getUnderRemand();
        } catch (NamingException ex) {
            Logger.getLogger(getUnderRemandServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Ajout du bean à l'objet requête */
        request.setAttribute( "prisoners", prisoners );
    }
}

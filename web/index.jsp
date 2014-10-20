<%-- 
    Document   : index
    Created on : 9 oct. 2014, 23:15:53
    Author     : loic
--%>

<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="Servlet">
                <fieldset>
                    <legend>Informations client</legend>
    
                    <label for="fileNumber">Prison file number <span class="requis">*</span></label>
                    <input type="text" id="fileNumber" name="fileNumber" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="nom">Nom </label>
                    <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="prenom">Prenom<span class="requis">*</span></label>
                    <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="place">place</label>
                    <input type="text" id="place" name="place" value="" size="20" maxlength="60" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>
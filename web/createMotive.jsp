<%-- 
    Document   : createMotive
    Created on : 15 oct. 2014, 23:07:00
    Author     : loic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form method="get" action="createMotiveServlet">
                <fieldset>
                    <legend>Motive informations</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="motiveLabel">motiveLabel</label>
                            </td>
                            <td>
                                <input type="text" id="motiveLabel" name="motiveLabel" size="20" maxlength="20" />
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
                <a href="getMotiveServlet">Return</a>
            </form>
        </div>
    </body>
</html>

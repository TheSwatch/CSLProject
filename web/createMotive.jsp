<%-- 
    Document   : createMotive
    Created on : 15 oct. 2014, 23:07:00
    Author     : loic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create motive page</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <link rel="shortcut icon" href="images/favicon.ico">  
    </head>
    <body>
        <div>
            <form method="get" action="createMotiveServlet">
                <fieldset>
                    <legend>Motive informations</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="motiveLabel">Motive Label<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="text" id="motiveLabel" name="motiveLabel" placeholder="Ex: Crimes, Theft.." size="20" maxlength="20" />
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <input type="submit" value="Submit"  />
                <input type="reset" value="Reset" /> <br />
                <p class="info">${ message }</p><br />
                <a href="incarcerate.jsp">Return</a>
            </form>
        </div>
    </body>
</html>

<%-- 
    Author     : Loïc Irles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create motive page</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">  
    </head>
    <body>
        <div id="en_tete" align="center">
            <titre>NYCP</titre><br/>
            <titre>Penitentiary</titre>
        </div>
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
                <font size="5pt"><a href="incarcerate.jsp">Return</a></font>
            </form>
        </div>
    </body>
</html>

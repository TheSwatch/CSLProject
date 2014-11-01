<%-- 
    Document   : underRemand
    Created on : 30 oct. 2014, 22:41:41
    Author     : loic
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="getUnderRemandServlet"/>
<html>
    <head>
        <title>Under remand page</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div>
            <fieldset>
                <table border="2">
                    <tr>
                        <td>
                            <label for="prisoner">Prisoner number</label>
                        </td>
                        <td>
                            <label for="prisoner">Given name</label>
                        </td>
                        <td>
                            <label for="prisoner">Surname</label>
                        </td>
                    </tr>
                    <c:forEach items="${prisoners}" var="p">
                        <tr>
                            <td>
                                <c:out value = "${p.prisonFileNumber}" />                              
                            </td>
                            <td>
                                <c:out value = "${p.givenName}" />                              
                            </td>
                            <td>
                                <c:out value = "${p.surname}" />                              
                            </td>
                            
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
            <a href="home.jsp">Return</a>
        </div>
    </body>
</html>

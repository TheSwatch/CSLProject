<%-- 
    Author     : Loïc Irles
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="getUnderRemandServlet"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Under remand page</title>
        
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
            <fieldset>
                <table id="t01" style="width:100%">
                    <tr>
                        <th style="width:30%">
                            <label for="prisoner">Prisoner number</label>
                        </th>
                        <th style="width:30%">
                            <label for="prisoner">Given name</label>
                        </th>
                        <th style="width:30%">
                            <label for="prisoner">Surname</label>
                        </th>
                    </tr>
                </table>
                <table id="t02" style="width:100%">
                    <c:forEach items="${prisoners}" var="p">
                        <tr>
                            <td style="width:30%">
                                <c:out value = "${p.prisonFileNumber}" />                              
                            </td>
                            <td style="width:30%">
                                <c:out value = "${p.givenName}" />                              
                            </td>
                            <td style="width:30%">
                                <c:out value = "${p.surname}" />                              
                            </td>  
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
            <font size="4pt"><a href="home.jsp">Return</a></font>
        </div>
    </body>
</html>

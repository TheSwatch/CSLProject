<%-- 
    Author     : Loïc Irles
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="getPrisonersServlet"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Take conviction decision page</title>
        
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
            <form method="get" action="takeConvictionServlet">
                <fieldset>
                    <legend>Decision Informations</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="dateODecision">Date of decision<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input  type="date" id="dateODecision" name="dateODecision" size="20" maxlength="60" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="prisoner">Prisoner<span class="requis">*</span></label>
                            </td>
                            <td>
                                <select name="prisoner">
                                    <c:forEach items="${prisoners}" var="p">
                                        <option id="prisoner" value="${p.prisonFileNumber}"> <c:out value = "${p.givenName} ${p.surname}" /></option> 
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="duration">Duration<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="number" min="0" id="duration" name="duration" placeholder="Ex: 5, 10..." size="20" maxlength="20" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="decisionType">Decision type<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="text" id="decisionType" name="decisionType" value="1"  placeholder="1" readonly="true" size="20" maxlength="20" />
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <input type="submit" value="Submit"  />
                <input type="reset" value="Reset" /> <br />
                <p class="info">${ message }</p><br />
                <font size="4pt"><a href="home.jsp">Return</a></font>
            </form>
        </div>
    </body>
</html>

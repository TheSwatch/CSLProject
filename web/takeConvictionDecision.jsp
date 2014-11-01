<%-- 
    Document   : takeConvictionDecision
    Created on : 30 oct. 2014, 11:48:19
    Author     : loic
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="getPrisonersServlet"/>
<html>
    <head>
        <title>Take conviction decision page</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div>
            <form method="get" action="takeConvictionServlet">
                <fieldset>
                    <legend>Informations</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="dateODecision">Date of decision</label>
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
                <a href="home.jsp">Return</a>
            </form>
        </div>
    </body>
</html>

<%-- 
    Document   : takeFinalDischargeDecision
    Created on : 30 oct. 2014, 19:20:45
    Author     : loic
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="getPrisonersServlet"/>
<html>
    <head>
        <title>Take final discharge decision page</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="style.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div>
            <form method="get" action="takeFinalDischargeServlet">
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
                                <label for="dateOFD">Date of final discharge<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="date" id="dateOFD" name="dateOFD" size="20" maxlength="20" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="decisionType">Decision type<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="text" id="decisionType" name="decisionType" value="2"  placeholder="2" readonly="true" size="20" maxlength="20" />
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

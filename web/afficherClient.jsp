<%-- 
    Document   : afficherClient
    Created on : 11 oct. 2014, 19:44:08
    Author     : loic
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <form>
                <select name="nom" size="1">
                    <c:forEach items="${manager}" var="p">
                       <option> <c:out value = "${p}" /></option> 
                    </c:forEach>
                </select>
        </form>
        <%-- Affichage de la chaîne "message" transmise par la servlet --%>
        <%-- Puis affichage des données enregistrées dans le bean "client" transmis par la servlet --%>
        
        
        <%--<p>Prénom : ${ prisoner.surname }</p>
        <p>Adresse : ${ prisoner.prisonFileNumber }</p>
        <p>Numéro de téléphone : ${ prisoner.dateOfBirth }</p>
<p>Email : ${ prisoner.placeOfBirth }</p>--%>
    </body>
</html>

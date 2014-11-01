<%-- 
    Author     : Loïc Irles
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="getMotiveServlet"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Incarcerate page</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico"> 
    </head>
    <body>
        <div>
            <form method="get" action="incarcerateServlet">
                <fieldset>
                    <legend>Prisoner informations</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="motive">Motive label<span class="requis">*</span></label>
                            </td>
                            <td>
                                <select name="motive">
                                    <c:forEach items="${motive}" var="m">
                                        <option id="motive" value="${m.motiveNumber}"> <c:out value = "${m.motiveNumber} | ${m.motiveLabel}" /></option> 
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <a href="createMotive.jsp">+ New motive</a>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                               <label for="fileNumber">Prisoner file number <span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="text" id="fileNumber" name="fileNumber" placeholder="Ex: 0001, 0002.." size="20" maxlength="20" />
                            </td>
                        </tr>
                    
                        <tr>
                            <td>
                                <label for="name">Name <span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="text" id="name" name="name" placeholder="Ex: Satriani, Clapton.." size="20" maxlength="20" />
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="firstName">First name<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="text" id="firstName" name="firstName" placeholder="Ex: Joe, Eric.." size="20" maxlength="20" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="dateOB">Date of birth</label>
                            </td>
                            <td>
                                <input type="date" id="dateOB" name="dateOB" size="20" maxlength="60"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="placeOB">Place of birth<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="text" id="placeOB" name="placeOB" placeholder="Ex: Paris, Londres" size="20" maxlength="20" />
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="dIncarceration">Date of incarceration<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="date" id="dIncarceration" name="dIncarceration" size="20" maxlength="20"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="criminalCN">Criminal case number<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="text" id="criminalCN" name="criminalCN" placeholder="Ex: CC-0001, CC-0002.." size="20" maxlength="20" />
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="dateOCC">Date of criminal case<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="date" id="dateOCC" name="dateOCC" size="20" maxlength="20"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="jName">Juridiction name<span class="requis">*</span></label>
                            </td>
                            <td>
                                <input type="text" id="jName" name="jName" placeholder="Ex: New York, Bagnères de Bigorre.." size="20" maxlength="20" />
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <input type="submit" value="Submit"  />
                <input type="reset" value="Reset" /> <br /><br />
                <p class="info">${ message }</p><br />
                <a href="home.jsp">Return</a>
            </form>
        </div>
    </body>
</html>
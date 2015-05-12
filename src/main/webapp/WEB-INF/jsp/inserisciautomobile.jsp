<%-- 
    Document   : inserisciAutomobile
    Created on : 12-mag-2015, 14.33.02
    Author     : luca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inserisci automobile</h1>
        <form:form action = "aggiungiAuto.do" commandName="automobile">

            TARGA: <form:input path="targa" /> <br>
            MODELLO: <form:input path="modello" /> <br>
            tariffaMensile: <form:input path="tariffaMensile" /> <br>
            scadenza: <form:input path="scadenza" /> <br>
            compagniaLeasing: <form:input path="compagniaLeasing" /> <br>
            <input type="submit" value="Inserisci" />
            <form:errors path="*" element="div" />
        </form:form>
       
    </body>
</html>

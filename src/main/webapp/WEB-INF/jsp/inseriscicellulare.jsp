<%-- 
    Document   : inseriscicellulare
    Created on : 12-mag-2015, 14.30.59
    Author     : corsojava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserimento cellulare</title>
    </head>
    <body>
        <h3>Inserimento cellulare associato a dipendente</h3>
        <form:form action="inseriscicellulare.do" commandName="cellulare"> 
            Numero cellulare:<form:input path="numero" /> <br />
            Modello:<form:input path="modello" /> <br />
            Numero SIMCard:<form:input path="numeroSim" /> <br />
            Dipendente: <form:input path="dipendente" /> <br />
            Contratto:<input type="checkbox" name="contratto" value="ON" /><br />            
            <input type="submit" value="Associa cel"/> 
            <form:errors path="*" element="div"/>
        </form:form>

        ${messaggio}
    </body>
</html>

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
            Numero cel.<form:input path="numero" /> <br />
           <input type="submit" value="Salva cel"/> 
<<<<<<< HEAD
           <form:errors path="*" element="div"/>
        </form:form>
           ${messaggio}
=======
           <form:errors path="*" element="div" />
        </form:form>
        ${messaggio}
>>>>>>> 608408c8d81ea23481397ffa01a8e01826eba326
    </body>
</html>

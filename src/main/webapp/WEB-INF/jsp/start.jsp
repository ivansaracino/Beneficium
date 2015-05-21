<%-- 
    Document   : jsp
    Created on : May 5, 2015, 2:18:47 PM
    Author     : ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h3>Pagina iniziale Beneficium</h3>
        <h1>Login</h1>
          <form:form action = "login.do" commandName="utente">
           USERNAME: <form:input path="username" /> <br>
           PASSWORD <form:input path="password" /> <br>
            <input type="submit" value="Login" />
            <form:errors path="*" element="div" />
        </form:form>
        ${messaggio}
    </body>
</html>

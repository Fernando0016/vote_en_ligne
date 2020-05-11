<%-- 
    Document   : user
    Created on : 17 oct. 2017, 12:08:28
    Author     : nacer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER INFOS</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            out.println(request.getAttribute("info"));

            out.println("<br>votre compe " + request.getParameter("email1") + "  a bien été crée");
        %>
    </body>
</html>

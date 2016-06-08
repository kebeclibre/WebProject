<%-- 
    Document   : Login
    Created on : Jun 3, 2016, 2:23:08 PM
    Author     : Rome10
--%>

<%@page import="login.UserAuth"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
   UserAuth auth = (UserAuth)session.getAttribute("UserAuth");
   %>
   <%= auth%>
   <%

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proprement Préparé</title>
    </head>
    <body>
        <form action="login" method="POST">
            <input name="user" type="text"/>
            <input name="password" type="password" />
            <input type="submit" value="send" />
        </form>
    </body>
</html>

<%-- 
    Document   : authorForm.jsp
    Created on : Jun 3, 2016, 1:57:27 PM
    Author     : Rome10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Author</h1>
        <form action="addAuthor" >
            <input name="firstname" type="text"/>
            <input name="lastname" type="text"/>
            <input name ="date" type="text"/>
            <input type="submit" value="submit" />
            
        </form>
    </body>
</html>

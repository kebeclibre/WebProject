<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="UserAuth"  class="beans.UserAuth" scope="session"></jsp:useBean>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome <jsp:getProperty name="UserAuth" property="username" /></h1>
        <a href="allBooks">AllBooks</a><br/>
        <a href="bookForm.jsp">AddBook</a>
        <a href="authorForm.jsp">AddAuthor</a>
    </body>
</html>


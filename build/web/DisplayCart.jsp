<%-- 
    Document   : DisplayCart
    Created on : Jun 9, 2016, 1:28:26 PM
    Author     : rome10
--%>

<%@page import="beans.BookBean"%>
<%@page import="login.ShopCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="ShopCart" class="login.ShopCart" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Show</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr>
            
<%
            for (BookBean bb : ShopCart.getList()) {
                out.println("<tr>");
                
                out.println("<td>"+bb.getTitle()+"</td>");
                out.println("<td>"+bb.getIsbn()+"</td>");
                out.println("<td>"+bb.getPrice()+"</td>");
                
                 out.println("</tr>");
            }
%>         
    
        
        
        </table>
<div>Total Price <jsp:getProperty name="ShopCart" property="totalPrice"></jsp:getProperty> </div>
        </body>
</html>

<%-- 
    Document   : adminpage
    Created on : Apr 1, 2016, 7:44:29 PM
    Author     : hani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Admin!</h1>
        
        <form action="AdminpageServlet">
            <input type="submit" name="insert" value="Insert"/>
            <input type="submit" name="edit" value="Edit"/>
            <input type="submit" name="Delete" value="Delete"/>
        </form>
        <a href="LogOutServlet">Logout</a>
    </body>
</html>

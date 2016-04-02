<%-- 
    Document   : login
    Created on : Mar 31, 2016, 7:33:42 PM
    Author     : hani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login/Register</title>
    </head>
    <body>
        <h1>Login/Register</h1>
        
      <form name="form" action="UserLoginServlet">
            <table border="1">

              Email<input type="email" name="email" value="" required />
              Password<input type="password" name="pass" value="" required />
              
                <input type="reset" name="button" value="Reset"/>
                <input type="submit" name="button" id ="login"  />
            </table>
        </form>
        
        <p></p><p></p>
        
         
    </body>
</html>

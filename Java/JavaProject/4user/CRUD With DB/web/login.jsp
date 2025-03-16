<%-- 
    Document   : login
    Created on : Jun 16, 2024, 7:20:37 PM
    Author     : manhpthe172481
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="" method="POST">
            Username <input type="text" name="username"><br>
            Password <input type="text" name="password"><br>
            <div style="color: red">${error}</div>
            <!--<div style="color: red">$//{requestScope['error']}</div>-->
            <input type="submit" value="Submit">
        </form>
    </body>
</html>

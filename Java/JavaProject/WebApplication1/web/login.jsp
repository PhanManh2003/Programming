<%-- 
    Document   : login
    Created on : May 13, 2024, 9:03:48 AM
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
        <!--getRequestDispatcher-->
        <h1>Welcome ${username}</h1> 
        <!--getRequestDispatcher: ko cần set attribute-->
        <h1>Welcome ${param.user}</h1>
        <!--sendRedirect-->
        <h1>Welcome ${param.username}</h1>
    </body>
</html>

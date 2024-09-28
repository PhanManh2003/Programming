<%-- 
    Document   : create
    Created on : Jun 7, 2024, 4:06:08 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        
        <%@page import = "model.Human" %>
        <%@page import = "java.text.SimpleDateFormat" %>
        <%
            Human h = (Human)(request.getAttribute("h"));
            if(h == null){
                out.print("<h1>Insert Human</h1>" +
                "<form action='Insert' method='post'>" +
                "<label for='id'>ID:</label><br>" +
                "<input type='text' id='id' name='id' value><br><br>" +
                "<label for='name'>Name:</label><br>" +
                "<input type='text' id='name' name='name' value><br><br>" +
                "<label for='gender'>Gender:</label><br>" +
                "<input type='text' id='gender' name='gender' value><br><br>" +
                "<label for='dob'>DOB:</label><br>" +
                "<input type='text' id='dob' name='dob' value><br><br>" +
                "<label for='typeid'>Type ID:</label><br>" +
                "<input type='text' id='typeid' name='typeid' value><br><br>" +
                "<input type='submit' value='Submit'>" +
              "</form>");
            }
            else{
                String male = h.isGender()?"Male":"Female";
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String date = formatter.format(h.getDob().getTime());
                out.print("<h1>Update Human</h1>" +
                    "<form action='Update' method='post'>" +
                    "<label for='id'>ID:</label><br>" +
                    "<input type='text' id='id' name='id' value='" + h.getID() + "'><br><br>" +
                    "<label for='name'>Name:</label><br>" +
                    "<input type='text' id='name' name='name' value='" + h.getName() + "'><br><br>" +
                    "<label for='gender'>Gender:</label><br>" +
                    "<input type='text' id='gender' name='gender' value='" + male + "'><br><br>" +
                    "<label for='dob'>DOB:</label><br>" +
                    "<input type='text' id='dob' name='dob' value='" + date + "'><br><br>" +
                    "<label for='typeid'>Type ID:</label><br>" +
                    "<input type='text' id='typeid' name='typeid' value='" + h.getType().getTypeID() + "'><br><br>" +
                    "<input type='submit' value='Submit'>" +
                  "</form>");
            }
            
        
                    
        %>
    </body>
</html>

<%-- 
    Document   : list
    Created on : May 28, 2024, 2:25:35 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Page</title>
        <style>
            table, th, td {
              border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <h1>List Humans</h1>
        <table>
            <thead>
                <tr>
                  <th>Name</th>
                  <th>DOB</th>
                  <th>Gender</th>
                  <th>Type</th>
                  <th></th>
                </tr>
            </thead>
            <tbody>
                <%@page import = "model.Human" %>
                <%@page import="java.util.ArrayList"%>
                <%
                    ArrayList<Human> humans = (ArrayList<Human>)(request.getAttribute("h"));
                    String male_icon = "<i class=\"fa-user\"></i>";
                    String female_icon = "<i class=\"fa-sharp fa-regular fa-user\"></i>";
                    for(int i = 0; i < humans.size(); i++){
                        String gender = (humans.get(i).isGender())?"Main":"Female";
                        out.print("<tr>");
                        out.print("<td>" + humans.get(i).getName() +  "</td>");
                        out.print("<td>" + humans.get(i).getDob() +  "</td>");
                        out.print("<td>" + gender +  "</td>");
                        out.print("<td>" + humans.get(i).getType().getName() +  "</td>");
                        out.print("<td>");
                        out.print("<form action='Delete'> <input name='id' value='" + humans.get(i).getID() + "' hidden>"
                                    + "<input type='submit' value='Delete'></form>");
                        out.print("<br><form action='Update'> <input name='id' value='" + humans.get(i).getID() + "' hidden> "
                                    + "<input type='submit' value='Edit'></form>");
                        out.print("</td></tr>");
                    }
                %>
            </tbody>
        </table>
            <form action="Insert">
                <input type="submit" value="Insert">
            </form>
    </body>
</html>

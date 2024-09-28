<%-- 
    Document   : insert
    Created on : Jun 2, 2024, 8:43:55 PM
    Author     : manhpthe172481
--%>
<%@page import="model.HumanType"%>
<%@page import="dal.DBContext"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert New Human</title>
    </head>
    <body>
        <h1>Insert New Human</h1>
        <form action="insert" method="post">
            <table>
                <tr>
                    <td><label for="name">Name</label></td>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <td><label for="dob">Date of Birth</label></td>
                    <td><input type="date" name="dob" required></td>
                </tr>
                <tr>
                    <td><label for="gender">Gender</label></td>
                    <td>
                        <select name="gender" required>
                            <option value="true">Male</option>
                            <option value="false">Female</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="type">Type</label></td>
                    <td>
                        <select name="type" required>
                            <% 
                                // Fetch HumanType list from the request attribute
                                DBContext db = new DBContext();
                                ArrayList<HumanType> types = db.getTypes();
                                for (HumanType type : types) {
                            %>
                            <option value="<%= type.getTypeiD() %>"><%= type.getName() %></option>
                            <% 
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right">
                        <button type="submit">Insert</button>
                        <button type="reset">Reset</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

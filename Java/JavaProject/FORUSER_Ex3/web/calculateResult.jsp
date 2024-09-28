<%-- 
    Document   : calculateResult
    Created on : May 17, 2024, 6:27:58 PM
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
        <form method="post" action="CalServlet">
            <table>
                <tr>
                    <td><label>First:</label></td>
                    <td><input type="number" name="first" value="${first}"></td>
                </tr>
                <tr>
                    <td><label>Second:</label></td>
                    <td><input type="number" name="second" value="${second}"></td>
                </tr>
                <tr>
                    <td><label>Operator:</label></td>
                    <td>
                        <select name="operator">
                            <option value="+">+</option>
                            <option value="-">-</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Compute"></td>
                </tr>
                <tr>
                    <td><label>Result:</label></td>
                    <td><input type="number" name="result" value="${result}"></td>
                </tr>
            </table>
        </form>
    </body>
</html>

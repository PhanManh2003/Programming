<%-- 
    Document   : list
    Created on : May 26, 2024, 4:52:38 PM
    Author     : manhpthe172481
--%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("products");%>
        <% String error = (String)request.getAttribute("error"); %>
    </head>
    <body>

        <h1 style="text-align: center" >List Product</h1>
        <a href="index.html">Back to home</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Product's ID</th>
                    <th>Product's Name</th>
                    <th>Provider</th>
                    <th>Unit's Price</th>
                    <th colspan="2">Insert New</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for(Product x : list) {
                %>
                <tr>
                    <td name="id"><%= x.getId()%></td>
                    <td name="name"><%= x.getName()%></td>
                    <td name="provider"><%= x.getProvider()%></td>
                    <td name="price"><%= x.getPrice()%></td>
                    <td> 
                        <a href="#" onclick="update(this)">Edit</a> 
                    </td>
                    <td>
                        <form action="delete" method="post" onsubmit="return confirm('Are you sure you want to delete this product?');">
                            <input type="hidden" name="id" value="<%= x.getId() %>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>


        <% if(error != null) { %>
        <p style="color: red;"><%= error%></p>
        <% } else { %>
        <p style="color: green;">Thêm thành công</p>
        <% } %>

        <form style="display: none" id="form-update" action="update" method="post">
            <h1>Update form</h1>
            <table>             
                <tr>
                    <td>Id</td>
                    <td>
                        <input type="text" name="id" value="" />
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name" value="" />
                    </td>
                </tr>
                <tr>
                    <td>Provider</td>
                    <td>
                        <input type="text" name="provider" value="" />
                    </td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>
                        <input type="text" name="price" value="" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Submit" />
                    </td>
                </tr>
            </table>

        </form>
        <script>
            function update(e) {
                // hiển thị form update
                displayOrHideForm();

                // lấy ra thẻ tr gần nhất
                let tr = e.closest("tr");

                // lấy ra giá trị các thẻ input trong tr của list product
                let id = tr.querySelector("td[name='id']").innerText;
                let name = tr.querySelector("td[name='name']").innerText;
                let provider = tr.querySelector("td[name='provider']").innerText;
                let price = tr.querySelector("td[name='price']").innerText;

                // lấy ra cái form update và các thẻ input trong nó
                let form = document.querySelector("#form-update");

                let idInput = form.querySelector("input[name='id']");
                let nameInput = form.querySelector("input[name='name']");
                let providerInput = form.querySelector("input[name='provider']");
                let priceInput = form.querySelector("input[name='price']");

                // đổ dữ liệu vào
                idInput.value = id;
                nameInput.value = name;
                providerInput.value = provider;
                priceInput.value = price;
            }

            function displayOrHideForm() {
                let form = document.querySelector("#form-update");
                form.style.display = form.style.display === "none" ? "block" : "none";
            }
        </script>
    </body>
</html>

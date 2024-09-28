<%-- 
    Document   : list
    Created on : May 27, 2024, 9:20:28 AM
    Author     : manhpthe172481
--%>
<%@page import="model.Human"%>
<%@page import="model.HumanType"%>
<%@page import="dal.DBContext"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List human</title>
        <% ArrayList<Human> list = (ArrayList<Human>)request.getAttribute("humans"); %>
    </head>
    <body>
        <style>
            table{
                border-collapse: collapse;
                width: 50%;
            }
        </style>
        <a href="insert.jsp">Insert new human</a>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>DOB</th>
                    <th>Gender</th>
                    <th>Type</th>
                    <th colspan="2">Option</th>
                </tr>
            </thead>
            <tbody>            
                <% if (list != null) {
                    for(Human x : list) { 
                %>
                <tr>
                    <td name="id"><%= x.getID()%></td>
                    <td name="name"><%= x.getName() %></td>
                    <td name="dob"><%= x.getDob() %></td>
                    <td name="gender"><%= x.isGender() ? "Male" : "Female" %></td>
                    <td name="type"><%= x.getType().getName() %></td>
                    <td> 
                        <a href="#" onclick="update(this)">Edit</a> 
                    </td>
                    <td>
                        <form action="delete" method="post" onsubmit="return confirm('Are you sure you want to delete this human?');">
                            <input type="hidden" name="id" value="<%= x.getID() %>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
                <% } }%>
            </tbody>
        </table>




        <form style="display: none" id="form-update" action="update" method="post">
            <h1>Update form</h1>
            <table>
                <tr>
                    <td><label for="id">ID</label></td>
                    <td><input type="text" name="id" value="" readonly></td>
                </tr>
                <tr>
                    <td><label for="name">Name</label></td>
                    <td><input type="text" name="name" value=""></td>
                </tr>
                <tr>
                    <td><label for="dob">Date of Birth</label></td>
                    <td><input type="date" name="dob" value=""></td>
                </tr>
                <tr>
                    <td><label for="gender">Gender</label></td>
                    <td>
                        <select name="gender" >
                            <option value="true">Male</option>
                            <option value="false">Female</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="type">Type</label></td>
                    <td>
                        <select name="type">
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
                    <td align="">
                        <button type="submit">Update</button>
                        <button type="reset">Reset</button>
                    </td>
                </tr>
            </table>
        </form>

        <script>
            function update(e) {
                // Show the update form
                displayOrHideForm();

                // Get the nearest tr element
                let tr = e.closest("tr");

                // Get the values from the tr element
                let id = tr.querySelector("td[name='id']").innerText;
                let name = tr.querySelector("td[name='name']").innerText;
                let dob = tr.querySelector("td[name='dob']").innerText;
                let gender = tr.querySelector("td[name='gender']").innerText === "Male";
                let type = tr.querySelector("td[name='type']").innerText;

                // Get the form and input elements
                let form = document.querySelector("#form-update");

                let idInput = form.querySelector("input[name='id']");
                let nameInput = form.querySelector("input[name='name']");
                let dobInput = form.querySelector("input[name='dob']");
                let genderInput = form.querySelector("select[name='gender']");
                let typeInput = form.querySelector("select[name='type']");

                // Set the values to the form inputs
                idInput.value = id;
                nameInput.value = name;
                dobInput.value = new Date(dob).toISOString().substring(0, 10); // Format date to YYYY-MM-DD
                genderInput.value = gender;
                typeInput.value = Array.from(typeInput.options).find(option => option.text === type).value;
                /*
 Array.from(typeInput.options): typeInput.options là một tập hợp các phần tử <option> trong thẻ <select>. Array.from() được sử dụng để chuyển đổi tập hợp này thành một mảng.

.find(option => option.text === type): Phương thức find() được sử dụng để tìm kiếm phần tử đầu tiên trong mảng thỏa mãn điều kiện được cung cấp. Ở đây, chúng ta đang tìm phần tử <option> có thuộc tính text bằng với giá trị của biến type.

.value: Khi phần tử <option> thỏa mãn điều kiện được tìm thấy, chúng ta sử dụng thuộc tính value của nó. Điều này trả về giá trị của phần tử <option>, thường được sử dụng khi chúng ta muốn gán giá trị cho một trường input.
                 */
                
            }

            function displayOrHideForm() {
                let form = document.querySelector("#form-update");
                form.style.display = form.style.display === "none" ? "block" : "none";
            }
        </script>
    </body>
</html>

<%-- 
    Document   : list
    Created on : Jun 26, 2024, 11:44:43 AM
    Author     : manhpthe172481
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show</title>
    </head>
    <body>
        <style>

            caption {
                text-align: left;
            }

        </style>

        <form action="students?action=filterByGender" method="POST">
            <label>Gender:</label>
            <select name="genderFilter" onchange="return this.closest('form').submit()">
                <option value="both"  ${genderSelected == null ||
                                        genderSelected == "both" ? 
                                        'selected' : ''}>Both</option>
                <option value="male" ${genderSelected == "male" ?  'selected' : ''} >
                    Male
                </option>
                <option value="female" ${genderSelected == "female" ?  'selected' : ''} >
                    Female
                </option>
            </select>
        </form>

        <br><button type="button" onclick="insert()">Add</button>

        <table id="show" border="1">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Subject</th>
                <th>Modify</th>
            </tr>
            <!-- Add rows here with student data -->
            <c:forEach items="${listStudent}" var="s">
                <tr>
                    <td name="id">  ${s.getStudentID()}</td>
                    <td name="name">${s.getStudentName()}</td>
                    <td name="birthDate">${s.getBirthDate()}</td>
                    <td name="age">${s.getAge()}</td>
                    <td name="gender">${s.isGender() == true ? 'Male' : 'Female'}</td>
                    <td name="subjectName">
                        <c:forEach items="${listSubject}" var="sbj">
                            <c:if test="${sbj.getSubjectID() == s.getSubjectID()}">
                                ${sbj.getSubjectName()}
                            </c:if>
                        </c:forEach>
                    </td>   
                    <td name="modify">
                        <button onclick="update(this)">Edit</button>
                        <form method="POST" action="students?action=delete"
                              style="display: inline-block">
                            <input type="hidden" name="code" value="${s.getStudentID()}">
                            <button type="button" onclick="deleteStudent(this)">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <!-- Repeat for more students -->
        </table>


        <form action="students?action=insert" id="formAddEdit" style="display: none;" method="POST">
            <h2>Insert</h2>
            <input type ="hidden" name="id" value="0">
            <label for="code">Code:</label>
            <input type="text" name="code" id="code" required><br><br> 
            <label for="name">Name:</label>
            <input type="text" name="name" id="name" required><br><br>
            <label for="birthDate">Date of birth:</label>
            <input type="text" name="birthDate" id="birthDate" required> <br><br>
            <label>Gender:</label>
            <input type="radio" name="gender" value="male" id="male">
            <label for="male">Male</label> 
            <input type="radio" name="gender" value="female" id="female">
            <label for="female">Female</label> <br><br>

            <label for="subject">Subject:</label>
            <select name="subjectID">
                <option value="">-- Choose a subject --</option>
                <c:forEach items="${listSubject}" var="sbj">
                    <option value="${sbj.getSubjectID()}">${sbj.getSubjectName()}</option>
                </c:forEach>
            </select><br><br>
            <input type="submit">
        </form>

        <c:if test="${message != null}">
            <c:choose>
                <c:when test="${message.contains('successfully')}">
                    <p style="color: green">${message}</p>
                </c:when>
                <c:otherwise>
                    <p style="color: red">${message}</p>
                </c:otherwise>
            </c:choose>
        </c:if>



        <script>
            function update(e) {
                displayForm();

                //1. Cập nhật form action thành update
                let form = document.querySelector('#formAddEdit');
                form.action = "students?action=update";
                form.querySelector('h2').innerText = "Update";

                //2. Lấy dữ liệu ở hàng mà người dùng bấm 
                let tr = e.closest('tr');
                let id = tr.querySelector("td[name='id']").innerText.trim();
                let name = tr.querySelector("td[name='name']").innerText.trim();
                let birthDate = tr.querySelector("td[name='birthDate']").innerText.trim();
                let gender = tr.querySelector("td[name='gender']").innerText.trim();
                let subjectName = tr.querySelector("td[name='subjectName']").innerText.trim();


                //3. Đắp dữ liệu lấy được lên form update
                form.querySelector("input[name = 'code']").value = id;
                form.querySelector("input[name = 'code']").readOnly = true;
                form.querySelector("input[name = 'name']").value = name;
                form.querySelector("input[name = 'birthDate']").value = birthDate;
                if (gender.toLowerCase() === "male") {
                    form.querySelector("input[name = 'gender'][value='male']").checked = true;
                } else if (gender.toLowerCase() === "female") {
                    form.querySelector("input[name = 'gender'][value='female']").checked = true;
                }

                // Set the correct subject in the dropdown
                let subjectSelect = form.querySelector("select[name='subjectID']");
                for (let i = 0; i < subjectSelect.options.length; i++) {
                    if (subjectSelect.options[i].innerText.trim() === subjectName) {
                        subjectSelect.selectedIndex = i;
                        break;
                    }
                }

            }


            function insert() {
                displayForm();

                // Reset form nếu đã bấm vào edit
                let form = document.querySelector('#formAddEdit');
                form.action = "students?action=insert";
                form.querySelector('h2').innerText = "Insert";


                form.querySelector("input[name='code']").value = null;
                form.querySelector("input[name='code']").readOnly = false;
                form.querySelector("input[name='name']").value = null;
                form.querySelector("input[name='birthDate']").value = null;
                form.querySelector("input[name='gender'][value='male']").checked = false;
                form.querySelector("input[name='gender'][value='female']").checked = false;
                form.querySelector("select[name='subjectID']").selectedIndex = 0;

            }
            function deleteStudent(e) {
                let form = e.closest('form');
                if (confirm('Do you really want to delete this student?')) {
                    form.submit(); // Submit the form if the user confirms
                }
            }

            function displayForm() {
                let form = document.querySelector("#formAddEdit");
                if (form.style.display === 'none') {
                    form.style.display = 'block';
                } else {
                    form.style.display = 'none';
                }
            }

//            function selectStudent(e) {
//                let tr = e.closest('tr');
//
//                // lấy dữ liệu từ bảng 
//                let id = tr.querySelector("td[name='id']").innerText.trim();
//                let name = tr.querySelector("td[name='name']").innerText.trim();
//                let birthDate = tr.querySelector("td[name='birthDate']").innerText.trim();
//                let gender = tr.querySelector("td[name='gender']").innerText.trim();
//                let subjectName = tr.querySelector("td[name='subjectName']").innerText.trim();
//
//                // lấy bảng detail rồi đắp dữ liệu vào
//                let detail = document.querySelector("table#detail");
//                detail.querySelector("input[name='code']").value = id;
//                detail.querySelector("input[name='name']").value = name;
//                detail.querySelector("input[name='birthDate']").value = birthDate;
//                if (gender === 'Male') {
//                    detail.querySelector("input[name='gender'][value='male']").checked = true;
//                } else {
//                    detail.querySelector("input[name='gender'][value='female']").checked = true;
//                }
//                detail.querySelector("input[name='subjectName']").value = subjectName;
//
//
//            }



        </script>
    </body>

</html>

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
            table#show{
                border-collapse: collapse;
            }
            caption {
                text-align: left;
            }


        </style>
        <form action="show?action=searchBySubject" method="POST">
            <label>List of subjects:</label>
            <select name="subjectID" onchange="return this.closest('form').submit()">
                <option value="0"  ${subjectIDChoosen == null ||
                                     subjectIDChoosen == "0" ? 
                                     'selected' : ''}>All subjects</option>
                <c:forEach items="${listSubject}" var="sbj">
                    <option value="${sbj.getSubjectID()}" 
                            ${sbj.getSubjectID() == subjectIDChoosen ? 
                              'selected' : ''}
                            >
                        ${sbj.getSubjectName()}
                    </option>
                </c:forEach>
            </select>
        </form>

        <br><br><br>
        <table class="show" border="1">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Gender</th>
                <th>Subject</th>
                <th>Select</th>
            </tr>
            <!-- Add rows here with student data -->
            <c:forEach items="${listInstructor}" var="i">
                <tr>
                    <td name="id"> ${i.getInstructorID()}</td>
                    <td name="name">${i.getInstructorName()}</td>
                    <td name="birthDate">${i.getBirthDate()}</td>
                    <td name="gender">${i.isGender() == true ? 'Male' : 'Female'}</td>
                    <td name="subjectName">
                        <c:forEach items="${listSubject}" var="sbj">
                            <c:if test="${sbj.getSubjectID() == i.getSubjectID()}">
                                ${sbj.getSubjectName()}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <a href='#' onclick='selectInstructor(this)'>Select</a>
                    </td>
                </tr>
            </c:forEach>
            <!-- Repeat for more students -->
        </table>

        <br><br><br>
        <table id="detail">
            <caption>Detail Information:</caption>
            <tr>
                <td>
                    <label for="code">Code:</label>
                    <input type="text" name="code" id="code">
                </td>
                <td>
                    <label for="name">Name:</label>
                    <input type="text" name="name" id="name">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="birthDate">Date of birth:</label>
                    <input type="text" name="birthDate" id="birthDate">
                </td>
                <td>
                    <label>Gender:</label>
                    <input type="radio" name="gender" value="male" id="male">
                    <label for="male">Male</label> 
                    <input type="radio" name="gender" value="female" id="female">
                    <label for="female">Female</label> 
                </td>
            </tr>
            <tr>
                <td>
                    <label for="subject">Subject:</label>
                    <input type="text" name="subjectName" id="subject">
                </td>
                <td>

                </td>
            </tr>
        </table>
        <script>
            function selectInstructor(e) {
                let tr = e.closest('tr');

                // lấy dữ liệu từ bảng 
                let id = tr.querySelector("td[name='id']").innerText.trim();
                let name = tr.querySelector("td[name='name']").innerText.trim();
                let birthDate = tr.querySelector("td[name='birthDate']").innerText.trim();
                let gender = tr.querySelector("td[name='gender']").innerText.trim();
                let subjectName = tr.querySelector("td[name='subjectName']").innerText.trim();

                // lấy bảng detail rồi đắp dữ liệu vào
                let detail = document.querySelector("table#detail");
                detail.querySelector("input[name='code']").value = id;
                detail.querySelector("input[name='name']").value = name;
                detail.querySelector("input[name='birthDate']").value = birthDate;
                if (gender === 'Male') {
                    detail.querySelector("input[name='gender'][value='male']").checked = true;
                } else {
                    detail.querySelector("input[name='gender'][value='female']").checked = true;
                }
                detail.querySelector("input[name='subjectName']").value = subjectName;


            }
        </script>
    </body>

</html>

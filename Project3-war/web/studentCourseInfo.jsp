<%-- 
    Document   : studentCourseInfo
    Created on : 7/04/2023, 11:11:26 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Info</title>
        <style>
            table {
  width: 100%;
  border-collapse: collapse;
  background-color: #333;
  color: #fff;
}

table th,
table td {
  padding: 10px;
  border: 1px solid #ddd;
}

table th {
  background-color: #222;
  text-align: left;
}

table tr:nth-child(even) {
  background-color: #444;
}
            .in1 {
  padding: 10px 20px;
  background-color: #223;
  color: #fff;
  border-radius: 20px;
  border: none;
  cursor: pointer;
}

.in1:hover {
  background-color: #964;
}
        </style>
    </head>
    <body>
            <h1>Student - Course Information</h1>
        <form action="./StudentCourseServlet" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="Id" value="${StudentCourse.student}" /></td>
                </tr>
                <tr>
                    <td>Course Id</td>
                    <td><input type="text" name="Name" value="${StudentCourse.course}" /></td>
                </tr>
                <tr>
                    <td>Qualification</td>
                    <td><input type="text" name="Qualification" value="${StudentCourse.qualification}" /></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input class = "in1" type="submit" name="action" value="Add" />
                        <input class = "in1" type="submit" name="action" value="Edit" />
                        <input class = "in1" type="submit" name="action" value="Delete" />
                        <input class = "in1" type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Student</th>
            <th>Course</th>
            <th>Qualification</th>
                <c:forEach items="${allStudentCourses}" var="stcour">
                <tr>
                    <td>${stcour.student}</td>
                    <td>${stcour.course}</td>
                    <td>${stcour.qualification}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>

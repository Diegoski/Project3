<%-- 
    Document   : courseInfo
    Created on : 7/04/2023, 09:03:14 PM
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
            <h1>Course Information</h1>
        <form action="./CourseServlet" method="POST">
            <table>
                <tr>
                    <td>Course Id</td>
                    <td><input type="text" name="Id" value="${course.id}" /></td>
                </tr>
                <tr>
                    <td>Course Name</td>
                    <td><input type="text" name="Name" value="${course.nombre}" /></td>
                </tr>
                <tr>
                    <td>Credit Numbers</td>
                    <td><input type="text" name="Credit" value="${course.numeroCreditos}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="YearLevel" value="${course.semestre}" /></td>
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
            <th>ID</th>
            <th>Course Name</th>
            <th>Credit Numbers</th>
            <th>Year Level</th>
                <c:forEach items="${allCourses}" var="cour">
                <tr>
                    <td>${cour.id}</td>
                    <td>${cour.nombre}</td>
                    <td>${cour.numeroCreditos}</td>
                    <td>${cour.semestre}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>

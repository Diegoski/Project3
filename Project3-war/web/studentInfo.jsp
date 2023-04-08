<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
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
  background-color: #964
}
        </style>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="Id" value="${student.id}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="Nombre" value="${student.nombre}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="Apellido" value="${student.apellido}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="Semestre" value="${student.semestre}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
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
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.id}</td>
                    <td>${stud.nombre}</td>
                    <td>${stud.apellido}</td>
                    <td>${stud.semestre}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>

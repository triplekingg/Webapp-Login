<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Webapp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script></head>
<body>
<div class="container mt-4">
    <h1 class="my-4">Hello ${username}</h1>
    <p>
    <form action="/logout" method="get">
        <button type="submit">Logout</button>
    </form>
    </p>
    <table class="table table-striped table-bordered">
        <thread>
            <tr>
                <th>Username</th>
                <th>Actions</th>
            </tr>
        </thread>
        <tbody>
        <c:forEach var ="user" items="${users}">
            <tr>
                <td class="py-3">${user}</td>
                <td>
                    <button class="btn btn-warning btn-sm" type="button">Edit</button>
                    <c:if test="${username!=user}">
                        <button class="btn btn-danger btn-sm" type="button">Delete</button>
                    </c:if>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="/add_user" method="get">
        <button type="submit">Create a new user</button>
    </form>
</div>
</body>
</html>
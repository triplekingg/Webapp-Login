<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Home Page</title>
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
                    <button class="btn btn-danger btn-sm" type="button">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<p>
<form action="/add_user" method="get">
    <button type="submit">Create a new user</button>
</form>
</p>


<h4>
</h4>

</body>
</html>
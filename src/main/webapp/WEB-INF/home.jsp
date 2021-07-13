<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Webapp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-4">
    <h1 class="my-4">Hello ${username}</h1>
    <c:if test="${not empty message}">
        <c:choose>
            <c:when test="${hasError}">
                <div class="alert alert-danger" role="alert">
                        ${message}
                </div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-success" role="alert">
                        ${message}
                </div>
            </c:otherwise>
        </c:choose>
    </c:if>
    <p>
    <form action="/logout" method="get">
        <button type="submit">Logout</button>
    </form>
    </p>
    <table class="table table-striped table-bordered">
        <thread>
            <tr>
                <th>Id</th>
                <th>Username</th>
                <th>Display Name</th>
                <th>Actions</th>
            </tr>
        </thread>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td class="py-3">${user.id}</td>
                <td class="py-3">${user.username}</td>
                <td class="py-3">${user.displayName}</td>
                <td>
                    <a class="btn btn-warning btn-sm" type="button" href="/edit_user?username=${user.username}">Edit
                        Display Name</a>
                    <a class="btn btn-warning btn-sm" type="button" href="/change_password?username=${user.username}">Change
                        Password</a>
                    <c:if test="${username!=user.username}">
                        <!-- Button trigger modal -->
                        <button class="btn btn-danger btn-sm" type="button"
                                href="/user/delete?username=${user.username}"
                                data-bs-toggle="modal"
                                data-bs-target="#delete-modal-${user.username}"
                        >Delete
                        </button>


                        <!-- Modal -->
                        <div class="modal fade" id="delete-modal-${user.username}" tabindex="-1"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Confirm deletion of user with
                                            us</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Confirm deletion of user ${user.username}
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                        </button>
                                        <a class="btn btn-danger"
                                           href="/user/delete?username=${user.username}">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </div>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Home Page</title>
<body>
<p>
<form action="/logout" method="get">
    <button type="submit">Logout</button>
</form>
</p>
<h2>
    Hello ${username}
</h2>

<p>
<form action="/add_user" method="get">
    <button type="submit">Create a new user</button>
</form>
</p>

<h3>
    Here are the list of users:

<c:forEach var ="user" items="${users}">
    Item <c:out value="${user}"/><p>
</c:forEach>
</h3>
<h4>
</h4>

</body>
</html>
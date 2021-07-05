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
    ${users}
</h3>
<h4>
    <form action="/add_user" method="get">
        <button type="submit">Click here to create a new user</button>
    </form>
</h4>

</body>
</html>
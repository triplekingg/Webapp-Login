<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Home Page</title>
<body>
<p>
    ${error}
</p>
<p>
<form action="/add_user" method="post">
    <input type="text" placeholder="Enter Username" name="username" required><br>
    <input type="password" placeholder="Enter Password" name="password" required><br>
    <button type="submit">Create Account</button>
</form>
</p>
</body>
</html>
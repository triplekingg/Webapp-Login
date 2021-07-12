<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Home Page</title>
<body>
<p>
    Change Password
</p>
<p>
    ${error}
</p>
<p>
<form action="/change_password" method="post">
    <input type="hidden" name="username" value="${username}"><br>
    <input type="password" placeholder="Enter Password" name="password" required><br>
    <input type="password" placeholder="Confirm Password" name="confirmPassword" required><br>
    <button type="submit">Change Password</button>
</form>
</p>
</body>
</html>
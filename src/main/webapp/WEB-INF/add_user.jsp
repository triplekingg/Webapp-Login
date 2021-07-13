<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Create User</title>
<body>
<p>
    Create a New User
</p>
<p>
    ${error}
</p>
<p>
<form action="/add_user" method="post">
    <input type="text" placeholder="Enter Username" name="username" required><br>
    <input type="text" placeholder="Enter Display Name" name="displayName" required><br>
    <input type="password" placeholder="Enter Password" name="password" required><br>
    <input type="password" placeholder="Confirm Password" name="confirmPassword" required><br>
    <p>
        ${confirmation}
    </p>
    <button type="submit">Create Account</button>
</form>
</p>
</body>
</html>
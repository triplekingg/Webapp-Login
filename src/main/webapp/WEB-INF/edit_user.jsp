<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Edit User Details</title>
<body>
<p>
    Update Display Name
</p>
<p>
    ${error}
</p>
<p>
<form action="/edit_user" method="post">
    <input type="hidden" name="username" value="${username}"><br>
    <input type="text" placeholder="Enter Display Name" name="displayName" required><br>
    <button type="submit">Update</button>
</form>
</p>
</body>
</html>
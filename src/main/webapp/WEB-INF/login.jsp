<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Webapp Login</title>
<body>
<p>
    ${error}
</p>
<p>
<form action="/login" method="post">
    <i class="fa fa-user"></i>
    <input type="text" class="form-control" placeholder="Enter Username" name="username" autocomplete="on" required><br>
    <input type="password" class="form-control" placeholder="Enter Password" name="password" autocomplete="on" required><br>
    <i class="fa fa-key"></i>
    <button type="submit"><i class="fa fa-sign-in"></i> Login</button>
</form>
</p>
</body>
</html>
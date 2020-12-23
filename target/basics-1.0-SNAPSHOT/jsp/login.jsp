<%--
  Created by IntelliJ IDEA.
  User: kesep
  Date: 23.12.2020
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form name="loginForm" method="POST" action="controller">
        <input type="hidden" name="command" value="login" />
        Login:<br/>
        <input type="text" name="login" value="" />
        <br/>Password:<br/>
        <input type="password" name="password" value="" />
        <br/><br/>
        <input type="submit" value="log in">
        <br/>
        ${errorLoginMessage}
        <br/>
        ${errorPasswordMessage}
        <br/>
        ${errorUserMessage}
        <br/>
        ${nullPage}
    </form>
</body>
</html>

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
    <title>Sign up</title>
</head>
<body>
    <form name="signupForm" method="POST" action="controller">
        <input type="hidden" name="command" value="signup" />
        Username<br/>
        <input type="text" name="username" value="" required pattern="[a-zA-Z0-9._]{5,}"
               title='must include only letters, ciphers, characters ".", "_" and have at least 5 characters'/>
        ${errorUsernameMessage}
        <br/>Password<br/>
        <input type="password" name="password" value="" required pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&()])(?=\S+$).{8,20}$"
               title='must include at least one letter in upper and in lower case, at least one cipher, at least one special character ("@", "#". "$", "%", "^", "&", "(" or ")", no spaces and have from 8 to 20 characters'/>
        ${errorPasswordMessage}
        <br/><br/>
        <input type="submit" value="sign up">
        <br/>${errorUserMessage}
        ${nullPage}
    </form>
    <form name="loginForm" method="post" action="controller">
        <input type="hidden" name="command" value="login_page" />
        <input type="submit" value="log in">
        <br/>
        ${nullPage}
    </form>
</body>
</html>

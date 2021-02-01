<%--
  Created by IntelliJ IDEA.
  User: kesep
  Date: 27.12.2020
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<form name="signupForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login" />
    Your name<br/>
    <input type="text" name="name" value="" required/>
    <br/>e-mail<br/>
    <input type="email" name="email" value="" required/>
    <br/>Username<br/>
    <input type="text" name="username" value="" required pattern="[a-zA-Z0-9._]{5,20}"
           title='must include only letters, ciphers, characters ".", "_" and have from 5 to 20 characters' />
    ${errorUsernameMessage}
    <br/>Password<br/>
    <input type="password" name="password" value="" required pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&()])(?=\S+$).{8,20}$"
           title='must include at least one letter in upper and in lower case, at least one cipher, at least one special character ("@", "#". "$", "%", "^", "&", "(" or ")", no spaces and have from 8 to 20 characters'/>
    ${errorPasswordMessage}
    <br/><br/>
    <input type="submit" value="log in">
    <br/>${errorUserMessage}
</form>
<form name="infoForm" method="POST" action="controller">
    <input type="hidden" name="command" value="signup_page"/>
    <input type="submit" value="back">
</form>
</body>
</html>

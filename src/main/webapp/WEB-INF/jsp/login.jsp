<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html>
<head><title>Login Page</title>
    <jsp:include page="header.jsp"/>
</head>
<%--<body onload='document.f.username.focus();'>--%>

<h3>Login with Username and Password</h3>
<form name='f' action='/login' method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value='alex93306@gmail.com'></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' value="0000"/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
        </tr>
        <tr>
            <td colspan='2'><a href="/signup">Create new</a> </td>
        </tr>
    </table>
</form>
<jsp:include page="beforeBodyClose.jsp"/>
</body>
</html>
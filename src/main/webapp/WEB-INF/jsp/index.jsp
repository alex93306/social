
<head>

    <title>Hello, world!</title>
</head>
<body>
<h1>Hello, world!</h1>
<form method="post" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout"/>
</form>

</body>
</html>
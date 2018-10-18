<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="mb-1 text-center">Sign up</h1>
    <form action="/signup" method="post">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" id="firstName"/>
            </div>
            <div class="col-md-6 mb-3">
                <label for="lastName">First Name</label>
                <input type="text" class="form-control" id="lastName"/>
            </div>
        </div>
        <div class="mb-3">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email"/>
        </div>
        <div class="mb-3">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password"/>
        </div>
        <div class="mb-3">
            <label for="confirmPassword">Confirm password</label>
            <input type="password" class="form-control" id="confirmPassword"/>
        </div>
        <hr class="mb-4"/>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Create account</button>
    </form>
</div>
<jsp:include page="beforeBodyClose.jsp"/>
</body>
</html>

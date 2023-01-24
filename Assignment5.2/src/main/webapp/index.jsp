<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<form class = "form" action="login" method = "post">
	<div class = "container m-6 w-25 p-5 border-primary rounded-3 bg-light">
		<div class = "m-2"><h3 style = "color:blue">Login Here</h3></div>
		<h6 class = "m-2" style = "color:red">${valid}</h6>
		<input class="m-2 form-control" placeholder="Username" type = "text" name = "uname" required>
		<input class="m-2 form-control" placeholder="Password" type = "password" name = "upass" required>
		<button class="m-2 btn btn-primary" type = "submit">Login</button>
	</div>
	</form>
</body>
</html>
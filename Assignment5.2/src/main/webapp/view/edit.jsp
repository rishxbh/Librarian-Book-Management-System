
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<%--<% 
		if(session.getAttribute("uname") == null) {
			response.sendRedirect("login.jsp");
		}
	%> --%>
	<div class ="container mt-4 ms-6 p-4 w-25 border border-primary rounded-3 bg-light">
	<h5>Edit Book</h5>
	<form  class="form" action="edited" method = "post">
		<label class="form-label" for = "id">Book Code</label>
		<input class="form-control" type = "number" name = "id" value = "${id}" required readonly>
		<label class="form-label" for = "name">Book Name</label>
		<input class="form-control" type = "text" name = "name" value = "${name}" required>
		<label class="form-label" for = "author">Author</label>
		<select name="author" id="author">
		  <c:forEach items = "${authors}" var = "author">
		  <option value="${author.personID}">${author.fullName}</option>
		  </c:forEach>
		</select>
		<br>
		<label class="form-label" for = "date">Date</label>
		<input class="form-control" type = "text" name = "date" value = "${date}" required readonly>
		<button class = "mt-2 btn btn-primary" type = "submit">Submit</button>
	</form>
	</div>
</body>
</html>
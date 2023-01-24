<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<div>
		<div>
		<h5>HELLO, ${username}</h5>
		<a href = "boot"><button class = "btn btn-danger">LogOut</button></a>
		</div>
		<!-- <div>
			<form class = "form" action="match" method = "post">
			<div class = "container m-6 w-25 p-5 border-primary rounded-3 bg-light">
				<div class = "m-2"><h3 style = "color:#1b263b">Enter Details</h3></div>
				<input class="m-2 form-control" placeholder="Colour" type = "text" name = "colour" required>
				<input class="m-2 form-control" placeholder="Size" type = "text" name = "size" required>
				<input class="m-2 form-control" placeholder="Gender" type = "text" name = "gender" required>
				<div>
				<p>Sort by: </p>
				<input class="form-check-input" type="radio" name="preference" value="1" id = "1" checked>
				  <label class="form-check-label" for="1">
				    Price
				  </label>
				 <input class="form-check-input" type="radio" name="preference" value="2" id = "2">
				  <label class="form-check-label" for="2">
				    Rating
				  </label>
				 <input class="form-check-input" type="radio" name="preference" value="3" id = "3">
				  <label class="form-check-label" for="3">
				    Price And Rating
				  </label>
				</div>
				<div>
				<button class="m-2 btn btn-success" type = "submit">Search</button>
				<button class="m-2 btn btn-warning" type = "reset">Reset</button>
				</div>
			</div>
			</form>
		</div> -->
		<div class = "container w-75 mt-4  border border-success rounded-3">
			<table class = "table table-striped table-hover">
				<thead>
				 <tr>
				 	<th>BookCode</th>
				 	<th>Name</th>
				 	<th>Author</th>
				 	<th>Date Added</th>
				 </tr>
				</thead>
				<tbody>
					<c:forEach items = "${books}" var = "tshirt">
					<tr>
						<td><c:out value="${book.bookCode}"/></td>
						<td><c:out value="${book.bookName}"/></td>
						<td><c:out value="${book.author.fullName}"/></td>
						<td><c:out value="${book.date}"/></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
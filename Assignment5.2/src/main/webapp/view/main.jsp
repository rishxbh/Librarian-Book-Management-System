<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<div>
		<div>
		<a href = "/"><button class = "btn btn-danger">LogOut</button></a>
		</div>
		<div class = "container w-50 mt-4 bg-light border border-success rounded-3">
			<h5>Add new Product</h5>
			<form class = "form" action="/add" method = "post">
				<label class="form-label" for = "Title">Book Code</label>
				<input class="form-control" type = "number" id = "id" name = "id" required>
				<label class="form-label" for = "name">Book Name</label>
				<input class="form-control" type = "text" id = "name" name = "name" required>
				<label class="form-label" for = "author">Author      </label>
				<select name="author" id="author">
				  <c:forEach items = "${authors}" var = "author">
				  <option value="${author.personID}">${author.fullName}</option>
				  </c:forEach>
				</select>
				<br>
				<button class = "btn btn-primary" type = "submit">Submit</button>
			</form>
		</div>
		<div class = "container w-75 mt-4  border border-success rounded-3">
			<table class = "table table-striped table-hover">
				<thead>
				 <tr>
				 	<th>BookCode</th>
				 	<th>Name</th>
				 	<th>Author</th>
				 	<th>Date Added</th>
				 	<th colspan = '2'>Action</th>
				 </tr>
				</thead>
				<tbody>
					<c:forEach items = "${books}" var = "book">
					<tr>
						<td><c:out value="${book.bookCode}"/></td>
						<td><c:out value="${book.bookName}"/></td>
						<td><c:out value="${book.author.fullName}"/></td>
						<td><c:out value="${book.date}"/></td>
						<td><form action = "edit">
					      		<input type = "hidden" name = "id" value = "${book.bookCode}">
					      		<input type = "hidden" name = "name" value = "${book.bookName}">
					      		<input type = "hidden" name = "date" value = "${book.date}">
					      		<button class = "btn btn-warning" type = "submit">edit</button></form></td>
					    <td><form action = "delete">
					      		<input type = "hidden" name = "id" value = "${book.bookCode}">
					      		<button class = "btn btn-danger" type = "submit">delete</button></form></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
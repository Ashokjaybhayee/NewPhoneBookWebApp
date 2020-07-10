<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>

function deleteConfirm(){

	return confirm("Are you sure , you want to delete? ");
	
}
</script>
</head>
<body>


<a href="loadform">+Add new Contact</a>

	<table border="1">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Contact Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${contactList}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td>
						<a href="editContact?cid=${c.contactId}">Edit</a> 
						<a href="deleteContact?cid=${c.contactId}">delete</a>
					</td>

				</tr>

			</c:forEach>

		</tbody>

	</table>

</body>
</html>
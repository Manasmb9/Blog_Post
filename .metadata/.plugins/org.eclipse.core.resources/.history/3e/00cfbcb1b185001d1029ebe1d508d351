<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>

<title>

Save Post
</title>


</head>
<body>
<h2> Hello Manas</h2>
<form:form action= "savePost" modelAttribute = "post" method= "POST">
<input type="hidden" name="postId" value="${post.id}">

	<table>
		<tbody>
			<tr>
				<td><label>Title :</label>
				<form:input path="title" /></td>
			</tr>
			<tr>
				<td><label>Excerpt :</label>
				<form:input path="excerpt" /></td>
			</tr>
			<tr>
				<td><label>Content :</label>
				<form:input path="content" /></td>
			</tr>
			<tr>
				<td><label>Author :</label>
				<form:input path="author" /></td>
			</tr>
			
			<tr>
				<td><label></label></td>
				<td><input type = "submit" name = "submitButton" value = "Save" class = "save" /></td>
			</tr>
		</tbody>
	</table>
</form:form>

</body>
</html>
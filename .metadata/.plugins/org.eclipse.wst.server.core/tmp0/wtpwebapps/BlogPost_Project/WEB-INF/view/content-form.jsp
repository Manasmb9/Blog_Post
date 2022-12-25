<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h2> Hello Manas</h2>
${post.content}
<br><br>
<form action = "showFormForUpdate">
<input type = "hidden" id = "postId" name =postId value= "${post.id}">
<input type = "submit" value = "Edit Post">
</form>
<form action = "delete">
<input type = "hidden" id = "postId" name =postId value= "${post.id}">
<input type = "submit" value = "Delete Post" onclick = "if(!(confirm('Are you sure want to delete this post'))) return false">

</form>


</body>
</html>
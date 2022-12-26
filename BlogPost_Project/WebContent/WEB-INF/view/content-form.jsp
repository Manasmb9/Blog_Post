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
	<input type = "hidden" id = "postId" name ="postId" value= "${post.id}">
	<input type = "submit" value = "Edit Post">
</form>
<form action = "delete">
	<input type = "hidden" id = "postId" name ="postId" value= "${post.id}">
	<input type = "submit" value = "Delete Post" onclick = "if(!(confirm('Are you sure want to delete this post'))) return false">
</form>
	<form>
		<button id="addcomment" formaction="addcomment" type="submit" name="id" value="${post.id}">Add Comment</button>
		<input type="hidden" name="postId" value="${post.id}">
	</form>
	<h2>comments</h2>
	<div id="container">
	
		<div id="content">	

				<!-- loop over and print our customers -->
				<c:forEach var="comment" items="${post.comments}">
						<div class = "comments">
							<h2> ${comment.name} </h2>
							<small> ${comment.email} </small>, <small> ${comment.created_at} </small><br>
							<span> ${comment.comment} </span><br>
						</div><br>
				</c:forEach>
				
		</div>
	
	</div>
</body>
</html>
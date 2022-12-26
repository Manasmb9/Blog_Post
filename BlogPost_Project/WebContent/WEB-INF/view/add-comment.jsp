<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>New/Edit Post</h2>
	
	<form:form action="savecomment" modelAttribute="comment" method="POST">
		
		${param.postId}
		<form:input path="name" placeholder="name"/>
		<br><br>
		<form:input path="email" placeholder="email"/>
		<br><br>
		<form:textarea path="comment" placeholder="Comment"/>
		<br><br>
		<input type="hidden" name="commentId" value="${comment.id}">
		<button type="submit" name="postId" value="${param.postId}">Add</button>
	</form:form>
</body>
</html>
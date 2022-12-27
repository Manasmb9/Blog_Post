<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

<title>Blog Post</title>
<style type="text/css">
button{
			border: 1px solid black;
			background-color: white;
			margin-left: auto;
			margin-right: auto;
			width: 50%
		}
		#posts {
			padding: 5px 5px;
			height:100px;
		}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

table {
	table-layout: fixed;
	margin-left: auto;
	margin-right: auto;
}

th, td {
	padding: 10px;
}
</style>
</head>
<body>
	<input type="button" value="AddPost"
		onclick="window.location.href ='showFormForAdd';return false;"
		class="add-button" />
	<br>
	<br>
	<form:form action="search" method="GET">
                Search : <input type="text" name="theSearchName" />

		<input type="submit" value="Search" class="add-button" />
	</form:form>
	<br><br>
		
	
			<h2>MY BLOG </h2>

	<div id="container">
	
		<div id="content">
		
		
				<c:forEach var="tempPost" items="${post}">
					<form>
						<button formaction="showFormForView" type="submit" name="postId" value="${tempPost.id}">
							<div id = "posts">
								<h2> ${tempPost.title} </h2>
								<small> ${tempPost.published_at} </small><br>
								<span> ${tempPost.excerpt} </span><br>
							</div><br>
						</button>
					</form>
				</c:forEach>
				
		</div>
	
	</div>
							
	<br>
	<br>
	<table>
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Excerpt</th>
			<th>Content</th>
			<th>Author</th>
			<th>Published_At</th>
			<th>Published</th>
			<th>Created_At</th>
			<th>Updated_At</th>
			<th>View</th>
			<th>Action</th>
		</tr>
		<c:forEach var="tempPost" items="${post}">
			<c:url var="viewLink" value="/post/showFormForView">
				<c:param name="postId" value="${tempPost.id}" />
			</c:url>
			<c:url var="updateLink" value="/post/showFormForUpdate">
				<c:param name="postId" value="${tempPost.id}" />
			</c:url>
			<c:url var="deleteLink" value="/post/delete">
				<c:param name="postId" value="${tempPost.id}" />
			</c:url>
			<tr>
				<td>${tempPost.id}</td>
				<td>${tempPost.title}</td>
				<td>${tempPost.excerpt}</td>
				<td>${tempPost.content}</td>
				<td>${tempPost.author}</td>
				<td>${tempPost.published_at}</td>
				<td>${tempPost.is_published}</td>
				<td>${tempPost.created_at}</td>
				<td>${tempPost.updated_at}</td>
				<td><a href="${viewLink}">View</a></td>
				<td><a href="${updateLink}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
<br><br>
	<input type="checkbox" id="C" name="C" value="C"/>    
                 <label>C</label>   
              <input type="checkbox" id="Java" name="Java" value="Java"/>    
                 <label>Java</label>    
              <input type="checkbox" id="Python" name="Python" value="Python"/>    
                 <label>Python</label>  
         <input type="checkbox" id="PHP" name="PHP" value="PHP"/>    
                 <label>PHP</label>  

	
</body>

</html>


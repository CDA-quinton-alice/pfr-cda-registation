<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page test Mat</title>
</head>
<body>

	<div>
		<c:forEach items="${utilisateur}" var="utilisateur">
			<p>${utilisateur}</p>
			</c:forEach>
	</div>

<p>utilisateur par name</p>
<p>${user}</p>
	
	
	
	
</body>
</html>
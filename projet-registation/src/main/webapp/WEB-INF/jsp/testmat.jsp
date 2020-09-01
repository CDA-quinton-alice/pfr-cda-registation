<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<c:forEach items="${utilisateur}" var="utilisateur">
			<p>${utilisateur}</p>
			</c:forEach>
	</div>

	
	
	
	
</body>
</html>
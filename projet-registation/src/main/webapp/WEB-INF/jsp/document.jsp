<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Documents</title>
</head>
<body>
	<div>
		<c:forEach items="${document}" var="document">
			<p>${document}</p>
			</c:forEach>
	</div>
</body>
</html>
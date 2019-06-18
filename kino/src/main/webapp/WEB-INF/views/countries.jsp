<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
	<!DOCTYPE html>
	<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<c:forEach items="${countries}" var="country">
			<a href="#"
				class="list-group-item list-group-item-action flex-column align-items-start">
				<div class="d-flex w-100 justify-content-between">
					<h5 class="mb-1">
						<c:out value="${country.name}" />
					</h5>
				</div>
			</a>
		</c:forEach>
	</div>
</body>
	</html>
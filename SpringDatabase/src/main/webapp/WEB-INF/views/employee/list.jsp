<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Employee List Page</title>
</head>
<body>

		<h3>Employees</h3>
		
		<ul>
			<c:forEach items="${employees }" var="employee">
				<li>${employee.first_name } ${employee.last_name }</li>
			</c:forEach>
		</ul>

</body>
</html>
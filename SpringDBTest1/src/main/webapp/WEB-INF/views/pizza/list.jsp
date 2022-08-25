<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>피자 조회하기</title>
</head>
<body>

		<h3>피자 조회</h3>
		
		<table border='1'>
		
			<tr>
				<th>피자 번호</th>
				<th>피자 이름</th>
				<th>피자 가격</th>
				<th>피자 칼로리</th>
			</tr>
				<c:forEach items="${pizzaList }" var="pizza">
				
				<tr>
					<td>${pizza.pizza_id }</td>
					<td>${pizza.pizza_name }</td>
					<td>${pizza.pizza_price }</td>
					<td>${pizza.pizza_calories }</td>
					<td><a href="update?id=${pizza.pizza_id }">수정</a></td>
					<td><a href="delete?id=${pizza.pizza_id }">삭제</a></td>
				</tr>
				</c:forEach>
		</table>
		
		<a href="<c:url value="/pizza/add" />">새 피자 추가하기</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>피자 조회</title>
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
				<c:forEach items="${pizzas }" var="pizza">
			<tr>
					<td>${pizza.pizza_id }</td>
					<td>${pizza.pizza_name }</td>
					<td>${pizza.pizza_price }</td>
					<td>${pizza.pizza_calories }</td>			
					<td><button onclick="location.href='./update?id=${pizza.pizza_id }'">수정</button></td>	
					<td><button onclick="location.href='./update?id=${pizza.pizza_id }'">삭제</button></td>		
			</tr>
				</c:forEach>
		</table>

</body>
</html>
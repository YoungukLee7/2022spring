<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ��ȸ</title>
</head>
<body>

		<h3>���� ��ȸ</h3>
		
		<table border='1'>
		
			<tr>
				<th>���� ��ȣ</th>
				<th>���� �̸�</th>
				<th>���� ����</th>
				<th>���� Į�θ�</th>
			</tr>
				<c:forEach items="${pizzas }" var="pizza">
			<tr>
					<td>${pizza.pizza_id }</td>
					<td>${pizza.pizza_name }</td>
					<td>${pizza.pizza_price }</td>
					<td>${pizza.pizza_calories }</td>			
					<td><button onclick="location.href='./update?id=${pizza.pizza_id }'">����</button></td>	
					<td><button onclick="location.href='./update?id=${pizza.pizza_id }'">����</button></td>		
			</tr>
				</c:forEach>
		</table>

</body>
</html>
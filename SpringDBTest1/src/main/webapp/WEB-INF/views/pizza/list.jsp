<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ��ȸ�ϱ�</title>
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
				<c:forEach items="${pizzaList }" var="pizza">
				
				<tr>
					<td>${pizza.pizza_id }</td>
					<td>${pizza.pizza_name }</td>
					<td>${pizza.pizza_price }</td>
					<td>${pizza.pizza_calories }</td>
					<td><a href="update?id=${pizza.pizza_id }">����</a></td>
					<td><a href="delete?id=${pizza.pizza_id }">����</a></td>
				</tr>
				</c:forEach>
		</table>
		
		<a href="<c:url value="/pizza/add" />">�� ���� �߰��ϱ�</a>

</body>
</html>
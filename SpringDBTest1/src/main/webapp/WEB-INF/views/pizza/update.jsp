<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �����ϱ�</title>
</head>
<body>

		<h3>���� �����ϱ�</h3>
		
		<form action="update" method="POST">
			ID: <input name="pizza_id" value="${pizza.pizza_id }" type="text" readonly/> <br>
			�̸�: <input name="pizza_name" value="${pizza.pizza_name }" type="text" /> <br>
			����: <input name="pizza_price" value="${pizza.pizza_price }" type="text" /> <br> 
			Į�θ�: <input name="pizza_calories" value="${pizza.pizza_calories }" type="text" /> <br>
			<input type="submit" value="�����ϱ�"/>
		</form>

</body>
</html>
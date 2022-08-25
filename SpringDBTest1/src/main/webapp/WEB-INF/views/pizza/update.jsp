<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>피자 수정하기</title>
</head>
<body>

		<h3>피자 수정하기</h3>
		
		<form action="update" method="POST">
			ID: <input name="pizza_id" value="${pizza.pizza_id }" type="text" readonly/> <br>
			이름: <input name="pizza_name" value="${pizza.pizza_name }" type="text" /> <br>
			가격: <input name="pizza_price" value="${pizza.pizza_price }" type="text" /> <br> 
			칼로리: <input name="pizza_calories" value="${pizza.pizza_calories }" type="text" /> <br>
			<input type="submit" value="수정하기"/>
		</form>

</body>
</html>
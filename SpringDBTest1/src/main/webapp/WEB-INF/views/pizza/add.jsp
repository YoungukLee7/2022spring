<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>새 피자 추가하기</title>
</head>
<body>

		<h3>새 피자 추가하기</h3>
		
		<form action="add" method="POST">
			이름: <input name="pizza_name" type="text" /> <br>
			가격: <input name="pizza_price" type="text" /> <br> 
			칼로리: <input name="pizza_calories" type="text" /> <br>
			<input type="submit" />
		</form>

</body>
</html>
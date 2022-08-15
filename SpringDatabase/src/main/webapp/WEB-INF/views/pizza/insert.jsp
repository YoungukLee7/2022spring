<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>피자 추가</title>
</head>
<body>

		<h3>피자 추가</h3>
		
		<table border='1'>
			<form action="./insertPizza" method="POST">
			<tr>
				<td>피자 이름</td>
				<td>피자 가격</td>
				<td>피자 칼로리</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="name"/>
				</td>
				<td>					
					<input type="number" name="price"/>
				</td>
				<td>
					<input type="number" step="0.01" name="col"/>					
				</td>
			</tr>
			<input type="submit" value="추가" />
			</form>
		</table>

</body>
</html>
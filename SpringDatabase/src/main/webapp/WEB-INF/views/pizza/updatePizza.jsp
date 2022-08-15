<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>피자 수정</title>
</head>
<body>

		<h3>피자 수정</h3>
		
		<table border='1'>
			<form action="" method="POST">
			<tr>
				<th>피자 번호</th>
				<th>피자 이름</th>
				<th>피자 가격</th>
				<th>피자 칼로리</th>
			</tr>
			<tr>
				<td><input type="text" value="${ids }" readonly/></td>
				<td><input type="text" value="${names }"/></td>
				<td><input type="number" value="${prices }"/></td>
				<td><input type="number" step="0.01" value="${caloriess }"/></td>
				<td><input type="submit" value="수정" /></td>
			</tr>
			</form>
		</table>

</body>
</html>
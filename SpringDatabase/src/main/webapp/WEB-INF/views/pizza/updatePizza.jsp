<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ����</title>
</head>
<body>

		<h3>���� ����</h3>
		
		<table border='1'>
			<form action="" method="POST">
			<tr>
				<th>���� ��ȣ</th>
				<th>���� �̸�</th>
				<th>���� ����</th>
				<th>���� Į�θ�</th>
			</tr>
			<tr>
				<td><input type="text" value="${ids }" readonly/></td>
				<td><input type="text" value="${names }"/></td>
				<td><input type="number" value="${prices }"/></td>
				<td><input type="number" step="0.01" value="${caloriess }"/></td>
				<td><input type="submit" value="����" /></td>
			</tr>
			</form>
		</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �߰�</title>
</head>
<body>

		<h3>���� �߰�</h3>
		
		<table border='1'>
			<form action="./insertPizza" method="POST">
			<tr>
				<td>���� �̸�</td>
				<td>���� ����</td>
				<td>���� Į�θ�</td>
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
			<input type="submit" value="�߰�" />
			</form>
		</table>

</body>
</html>
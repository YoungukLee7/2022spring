<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���ε� �� ���� ��� ����</title>

<style>
	a {
		text-decoration: none;
	}
</style>

</head>
<body>
	
		<h3>Uploaded File List</h3>
		
		<ul>
			<c:forEach items="${files }" var="file">
				<li>
					<a href="${file }">${file }</a>
					<!-- �ٿ�ε带 ������ �Ŀ� �̹��� �±׷� �����ϸ� �� �������� ��ȸ�� �� �ִ� -->
					<img src="${file }" />
				</li>
			</c:forEach>
		</ul>
		

</body>
</html>
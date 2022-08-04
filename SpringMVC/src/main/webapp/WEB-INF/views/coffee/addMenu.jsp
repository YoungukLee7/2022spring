<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Add Coffee Menu</title>
</head>
<body>

		<h3>Ŀ�� �޴� �߰��ϱ�</h3>
		
		<form action="<c:url value="/hello/coffee/add1" />" method="POST" id="add">
			name : <input type="text" name="name" value="Americano"/> <br>		
			price : <input type="text" name="price" value="1700"/>	<br>		
			hot : <input type="radio" name="hot" value="true"/>		
				  <input type="radio" name="hot" value="false"/> <br>			
		</form>
		
		<!-- ���� Ǭ ��� -->
		<button type="submit" form="add" onclick="javascript: form.action='/springmvc/hello/coffee/add1'">add1</button>
		<button type="submit" form="add" formaction="/springmvc/hello/coffee/add2" />add2</button>
		
		<!-- ����� Ǭ ��� -->
		<button id="btn1">add1</button>
		<button type="submit" form="add" formaction="<c:url value="/hello/coffee/add2" />" />add2</button>
		<button type="submit" form="add" formaction="<c:url value="/hello/coffee/add3" />" />add3</button>
		
		<script>
			// 1. add1�� ������ /springmvc/hello/coffee/add1�� submit
			
			const btn1 = document.getElementById("btn1"); 
			const form = document.getElementById("add"); 
			
			btn1.addEventListener('click' , (e) => {
				form.action = '/springmvc/hello/coffee/add1';
				form.submit();
			})
			
			// 2. add2�� ������ /springmvc/hello/coffee/add2�� submit
	


		</script>
		

</body>
</html>
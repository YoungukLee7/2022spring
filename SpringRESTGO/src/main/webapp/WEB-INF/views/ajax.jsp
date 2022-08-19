<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Ajax ����ϱ�</title>
<style>
	img {
		width: 100px;
	}
</style>
</head>
<body>

		<h3>Ajax Index</h3>
		
		<h5>static resources mapping</h5>
		
		<p>
			���� �ڿ����� webapp/resources/�� �����ϰ�
			/resources/** uri�� �����ϸ� �ȴ�
			(servlet-context�� ������ ����)
		</p>
		
		<img src="https://static.hubzum.zumst.com/hubzum/2020/08/21/10/16af61affa8841f58caaedd241064824.jpg" alt="" />
		<img src="/restful/resources/images/pang.jpg" alt="" />


		<button id="btn-xhttp">xhttp ��û ������</button>
		
		<hr>
		
		<!-- Hint : select �±׿��� ���𰡸� �������� �� �߻��ϴ� �̺�Ʈ�� �ִ� -->
		name: <select id="select-pizza-name" name="name">
					<c:forEach items="${pizzas }" var="pizza">
					<option value="${pizza.pizza_id }">${pizza.pizza_name }</option>
					</c:forEach>				  
			  </select> <br>
		price: <input type="text" id="input-pizza-price" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�" /> <br>
		calories: <input type="text" id="input-pizza-calories" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�" /> <br>
		pizza_id: <input type="text" id="input-pizza-id" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�" readonly/> <br>
		<input id="input-pizza-name" type="hidden" />
		
		<button id="btn-xhttp-put">xhttp put �غ��� (update)</button>
		
		<hr>
		
		<div id="out2">���� ���� ���Դϴ�.</div>
		
		<hr>
		
		price: 		<input type="text" id="post-pizza-price" /> <br>
		calories: 	<input type="text" id="post-pizza-calories" /> <br>
		name:		<input type="text" id="post-pizza-name" /> <br>
		
		<button id="btn-xhttp-post">xhttp post �غ��� (insert)</button>
		
		<hr>
		
		<div id="out3">���� �߰� ���Դϴ�.</div>
		
		<hr>

		<div id="out"></div>

		<script src="/restful/resources/js/ajax.js"></script>
</body>
</html>
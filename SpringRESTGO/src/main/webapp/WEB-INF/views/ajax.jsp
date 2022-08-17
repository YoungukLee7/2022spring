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
		name: <select id="selectall">
					<c:forEach items="${allpizzas }" var="allpizza">
					<option value="${allpizza.pizza_name }">${allpizza.pizza_name }</option>
					
					</c:forEach>				  
			  </select> <br>
		price: <input type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�" value="${onlypizza.pizza_price }"/> <br>
		calories: <input type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�" value="${onlypizza.pizza_calories }"/> <br>
		pizza_id: <input type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�" value="${onlypizza.pizza_id }" readonly/> <br>


		<form action=""></form>
		
		<button id="btn-xhttp-put">xhttp put �غ��� (update)</button>
		
		<hr>

		<div id="out"></div>

		<script src="/restful/resources/js/ajax.js"></script>
</body>
</html>
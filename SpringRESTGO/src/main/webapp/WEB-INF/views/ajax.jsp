<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Ajax 사용하기</title>
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
			정적 자원들은 webapp/resources/에 보관하고
			/resources/** uri로 접근하면 된다
			(servlet-context의 내용을 참조)
		</p>
		
		<img src="https://static.hubzum.zumst.com/hubzum/2020/08/21/10/16af61affa8841f58caaedd241064824.jpg" alt="" />
		<img src="/restful/resources/images/pang.jpg" alt="" />


		<button id="btn-xhttp">xhttp 요청 보내기</button>
		
		<hr>
		
		<!-- Hint : select 태그에서 무언가를 선택했을 때 발생하는 이벤트가 있다 -->
		name: <select id="select-pizza-name" name="name">
					<c:forEach items="${pizzas }" var="pizza">
					<option value="${pizza.pizza_id }">${pizza.pizza_name }</option>
					</c:forEach>				  
			  </select> <br>
		price: <input type="text" id="input-pizza-price" placeholder="피자를 선택하면 값이 채워집니다" /> <br>
		calories: <input type="text" id="input-pizza-calories" placeholder="피자를 선택하면 값이 채워집니다" /> <br>
		pizza_id: <input type="text" id="input-pizza-id" placeholder="피자를 선택하면 값이 채워집니다" readonly/> <br>
		<input id="input-pizza-name" type="hidden" />
		
		<button id="btn-xhttp-put">xhttp put 해보기 (update)</button>
		
		<hr>
		
		<div id="out2">아직 수정 전입니다.</div>
		
		<hr>
		
		price: 		<input type="text" id="post-pizza-price" /> <br>
		calories: 	<input type="text" id="post-pizza-calories" /> <br>
		name:		<input type="text" id="post-pizza-name" /> <br>
		
		<button id="btn-xhttp-post">xhttp post 해보기 (insert)</button>
		
		<hr>
		
		<div id="out3">아직 추가 전입니다.</div>
		
		<hr>

		<div id="out"></div>

		<script src="/restful/resources/js/ajax.js"></script>
</body>
</html>
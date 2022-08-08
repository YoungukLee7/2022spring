<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>파일 업로드</title>
</head>
<body>

		<h3>/fileupload/form</h3>
	
		<!--
			파일을 보낼 때에는 method를 POST로 설정하고 
			enctype(인코딩 타입)을 multipart/form-data로 설정해야 한다. 
		-->
		<form action="./" method="POST" enctype="multipart/form-data">
			원하는 파일 선택: <input type="file" name="file" />
			<input type="submit" value="등록" />
		</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./style.css"/>
<title>Insert title here</title>
</head>
<body>

<section>
	
	<!-- 1. 헤더 정보 -->
	<header class="header1">
		<h1>변수/연산자/클래스</h1>
	</header>
	
	<!-- 2. 본문 -->
	<section>
		<br>
		<br>
		<%
		// (1) 정수형 변수(price) 선언
		int price;
		// (2) 변수에 값 할당
		price = 12000;
		%>
		<!-- (3) 변수값 출력 -->
		가격은 <%= price %>원 입니다.
		<br>
		<br>
		<br>
	</section>
	
	<!-- 3. 푸터 -->
	<footer class="footer1">
		<center>
		
		</center>
	</footer>
</section>
</body>
</html>
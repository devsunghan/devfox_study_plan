<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id = "gugudan" class="dao.GuGuDan" scope="request"/>
	<h4>구구단 출력하기</h4>
	<%
		int num = 0;
		for(int i = 1; i < 10; i++) {
			num = gugudan.process(5, i);
			out.print(5 + " * " + i + " = " + num + "<br>");
		}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String strNum = request.getParameter("num");
		int intNum = Integer.parseInt(strNum);
	%>
	<%
		for (int i = 1; i < 10; i++) {
			out.println(intNum + " * " + i + " = " + (intNum*i) + "<br>");
		}
	%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Refresh","5");
		Calendar cal = Calendar.getInstance();
		String am_pm;
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		if (hour < 12)
			am_pm = " AM";
		else {
			am_pm = " PM";
			hour = hour - 12;
		}
		String CT = hour + ":" + minute + ":" + second + am_pm;
	%>
	<p>현재 시간은 <b><%=CT %></b>
	<p> <a href="./response_data.jsp"><U>Google 홈페이지로 이동하기</U></a>

</body>
</html>
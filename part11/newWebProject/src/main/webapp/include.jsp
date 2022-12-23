<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="include_data.jsp" flush="false">
		<jsp:param name="num" value= "5" />
	</jsp:include>

</body>
</html>
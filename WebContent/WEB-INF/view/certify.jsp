<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>auth</title>
</head>
<body>
	<div align="center">
		<h2>
			<a href="${pageContext.request.contextPath }/alpha/index">WELLCOME</a>
		</h2>
		<hr />
		<div align="right">
			<a href="${pageContext.request.contextPath }/login">LOGIN</a> | <a
				href="${pageContext.request.contextPath }/logout">LOGOUT</a> | <a
				href="${pageContext.request.contextPath }/join">JOIN</a> | <a
				href="${pageContext.request.contextPath }/chat">CHAT</a>
		</div>
	<h3>인증을 완료해주세요 </h3>
	<a href="${pageContext.request.contextPath }/auth">인증받으러가기</a>
	</div>
</body>
</html>
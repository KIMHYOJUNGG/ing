<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h2><a href="${pageContext.request.contextPath }/alpha/index">WELLCOME</a> </h2>
	<hr/>
	<div align="right">
	<a href="${pageContext.request.contextPath }/login">LOGIN</a> | <a href="${pageContext.request.contextPath }/logout">LOGOUT</a> | <a href="${pageContext.request.contextPath }/join">JOIN</a>
	| <a href="${pageContext.request.contextPath }/chat">CHAT</a>
	</div>
	<hr/>
	<c:if test="${!empty err }">
		<p style="color:red">${err }</p>
	</c:if>
	<form action = "${pageContext.request.contextPath }/join" method="post" 
	style="width: 330px; text-align: left;">
	<div style="margin-top: 20px;">
		<span>ID(*)</span> <span></span><br /> <input type="text" name="id"
			id="id" placeholder="아이디" autocomplete="off" onblur="check()">
		<a id="idp"></a>
	</div>
	<div style="margin-top: 20px;"> 
		<span>PASS(*)</span><br /> <input type="pass" name="pass" id="pass" onblur="check2()"
			placeholder="비밀번호">
	</div>
	<div style="margin-top: 20px;">
		<span>EMAIL(*)</span><br /> <input type="text" name="email" id="email" onblur="check3()"
			placeholder="이메일" autocomplete="off">
	</div>
	
	<div style="margin-top: 20px;">
		<button type="submit" style="width: 100%; height: 30px;" id="click"  >가 입 신 청
			</button>
	</div>
	</form>
	</div>
</body>
</html>
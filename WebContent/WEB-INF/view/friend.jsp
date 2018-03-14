<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>friendAdd</title>
</head>
<body>
	<div align="center">
		<h2>
			<a href="${pageContext.request.contextPath }/alpha/index">WELLCOME</a>
		</h2>
		<hr />
		<c:choose>
		<c:when test="${pageContext.request.session != null }">
		<div align="right">
			<a href="${pageContext.request.contextPath }/login">LOGIN</a> | <a
				href="${pageContext.request.contextPath }/logout">LOGOUT</a> | <a
				href="${pageContext.request.contextPath }/join">JOIN</a> | <a
				href="${pageContext.request.contextPath }/chat">CHAT</a> | <a
				href="${pageContext.request.contextPath }/friendAdd">FRIEND</a>
			</div>
		</c:when>
		<c:otherwise>
		<div align="right">
			<a href="${pageContext.request.contextPath }/login">LOGIN</a> | <a
				href="${pageContext.request.contextPath }/join">JOIN</a> 
		</div>
		</c:otherwise>
		</c:choose>
	<hr />
	<c:forEach items="${list }" var="l" >
		<p> ${l.ID } <button>친구신청</button></p> 
	</c:forEach>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h2>${ment }</h2>
	<hr/>
	<div align="right">
	<a href="<%=request.getContextPath() %>/login">LOGIN</a> | <a href="<%=request.getContextPath() %>/join">JOIN</a>
	</div>
	<hr/>
	<form action = "/registerP.jsp" method="post" 
	style="width: 330px; text-align: left;">
	<div style="margin-top: 20px;">
		<span>ID(*)</span> <span></span><br /> <input type="text" name="id"
			id="id" placeholder="아이디" autocomplete="off" onblur="check()">
		<a id="idp"></a>
	</div>
	<div style="margin-top: 20px;"> 
		<span>PASS(*)</span><br /> <input type="password" name="pass" id="pass" onblur="check2()"
			placeholder="비밀번호">
	</div>
	<div style="margin-top: 20px;">
		<span>NICKNAME(*)</span><br /> <input type="text" name="nick" id="nick" onblur="check3()"
			placeholder="닉네임" autocomplete="off">
	</div>
	
	<div style="margin-top: 20px;">
		<button type="submit" style="width: 100%; height: 30px;" id="click" disabled >가 입
			신 청</button>
	</div>
	</form>
</body>
</html>
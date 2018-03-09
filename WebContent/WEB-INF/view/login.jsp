<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Join</title>
</head>
<body>
	<div align="center">
	<h2>${ment }</h2>
	<hr/>
	<div align="right">
	<a href="${pageContext.request.contextPath }/login">LOGIN</a> | <a href="${pageContext.request.contextPath }/join">JOIN</a>
	</div>
	<hr/>
	<form action="${pageContext.request.contextPath }/login" method="post">
	<p>
		<input type="text"  name="id"  placeholder="아이디"  autocomplete="off"  pattern="[a-zA-Z]+" value="${id}"/>
	</p>
	<p>
		<input type="text"  name="email"  placeholder="이메일"  autocomplete="off"  value="${email }"/>
	</p>
	<p>
		<input type="password" name="pass"  placeholder="비밀번호"  value="${pass }" />
	</p>	
		<button type="submit" id="login" >Login</button>
	</form>	
	</div>

</body>
</html>
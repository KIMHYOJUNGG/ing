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
	<a href="<%=request.getContextPath() %>/login">LOGIN</a> | <a href="<%=request.getContextPath() %>/join">JOIN</a>
	</div>
	<hr/>
		<form action="login.jsp" method="post">
	<p>
		<input type="text"  name="id"  placeholder="아이디"  autocomplete="off"/>
	</p>
	<p>
		<input type="text"  name="email"  placeholder="이메일"  autocomplete="off"/>
	</p>
	<p>
		<input type="password" name="pass"  placeholder="비밀번호"/>
	</p>	
		<button type="submit" id="login" >Login</button>
	</form>	
	</div>

</body>
</html>
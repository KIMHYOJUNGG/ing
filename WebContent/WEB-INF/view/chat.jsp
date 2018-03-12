<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>chat</title>
</head>
<body>

<style>
input, select {
	padding: 4px;
}
</style>
</head>
<body>
	<div align="center">
	<h2><a href="${pageContext.request.contextPath }/alpha/index">WELLCOME</a> </h2>
	<hr/>
	<div align="right">
	<a href="${pageContext.request.contextPath }/login">LOGIN</a> | <a href="${pageContext.request.contextPath }/join">JOIN</a>
	| <a href="${pageContext.request.contextPath }/chat">CHAT</a>
	</div>
	<hr/>
	

<div style="font-size: 17pt; margin-top: 50px;">
	채팅방 개설<br /> <span style="font-size: 11pt;">개설하고자 하는 채팅방을 설정한 후
		개설을 신청하세요.</span>
</div>
	<form action="openchatp.jsp" id="open" method="post"
		autocomplete="off">
		<p>
			분류 <select name="cate1" onchange="catechange(this);" style="width:150px; height:30px">
				<option value="연령대별">연령대별</option>
				<option value="주제별">주제별</option>
			</select> <select name="cate2" id="cate2" style="width:150px; height:30px">
				<option value="10대">10대</option>
				<option value="20대">20대</option>
				<option value="30대">30대</option>
				<option value="40대">40대</option>
				<option value="50대">50대</option>
			</select>
		</p>
		<p>
			제목 <input type="text" name="title" placeholder="대화방 주제를 설정해주세요" style="width:310px; height:30px"  />
		</p>
		<p>
			<button type="submit" >대화방 개설</button>
		</p>
	</form>
	</div>
	
	
</body>
</html>
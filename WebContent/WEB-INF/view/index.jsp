<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Spring - managed by GIT</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<div align="center">
		<h2>
			<a href="${pageContext.request.contextPath }/alpha/index">WELLCOME</a>
		</h2>
		<hr />
		<div align="right">
			<a href="${pageContext.request.contextPath }/login">LOGIN</a> | <a
				href="${pageContext.request.contextPath }/join">JOIN</a> | <a
				href="${pageContext.request.contextPath }/chat">CHAT</a>
		</div>
	<hr />
	<div class="alert alert-info ">
			<b>현재접속자수:<span id="cnt"></span></b> / 
			<strong>서버알림</strong><span id="info">-</span>
	</div>
	  <div class="alert alert-warning  alert-dismissible" id="warn" style="display: none" >
	  <a href="javascript:location.reload();" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>경고!</strong> 다른 윈도우 혹은 탭에서 상태가 변경되었습니다.
 	 </div>
	</div>
	
</body>

<script>
	//${pageContext.request.serverName}
	
	var ws = new WebSocket("ws://${pageContext.request.serverName}${pageContext.request.contextPath }/alert");
	// 연결이 됬음때..
	ws.onopen = function(){
		console.log("opened");
		console.log(this);
	} 
	// 메세지가 들어올때.
	ws.onmessage = function(resp){
		console.log(resp);
		var obj = JSON.parse(resp.data);
		$("#cnt").html(obj.cnt);  // 접속자수 
		$("#info").html(obj.info);  // 누가 open하고 누가 close했는지
		$("#warn").show(obj.warn);
	
	}
	// 연결이 끊길때
	ws.onclose = function(){
		window.alert("연결이 해제되었습니다.");
	}
	
	
</script>
</html>
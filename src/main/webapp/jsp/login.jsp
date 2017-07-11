<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:directive.include file="include.jsp" />

<link href="<%=request.getContextPath()%>/public/css/compiled/signin.css" rel="stylesheet" type="text/css" media="screen" />
<script src="<%=request.getContextPath()%>/public/js/sha1.js"></script>

<title>Login</title>
</head>
<script type="text/javascript">
	var getLogin = function(){
		var password = $("#password").val();
		password = CryptoJS.SHA1(password);
		$("#password").val(password);
		$("#random").val(Math.floor(Math.random() * (100000 + 1)));
		$("#loginForm").submit();
	};
	$(function(){
		$("#password").keypress(function(e){
			var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
			if(eCode == 13){
				getLogin();
			}
		});
	});
	
</script>
<body class="login-bg">
	<div class="login-wrapper">
		<a href="#"> <img class="logo" src="<%=request.getContextPath()%>/public/img/logo-white.png">
		</a>

		<div class="box">
			<div class="content-wrap">
				<h6>登录</h6>
				<form action="" id="loginForm">
					<input class="form-control" type="text" placeholder="用户名" name="userName" id="userName"/> 
					<input class="form-control" type="password" placeholder="密码" name="password" id="password"/> 
					<input type="hidden"  name="random" id="random" value=""/>
					<a href="#" class="forgot">忘记密码?</a>
					<div class="remember">
						<!-- <input id="remember-me" type="checkbox"/> <label for="remember-me">记住密码</label> -->
						<label id="result" style="color:red;">${result}</label>
					</div>
					<a class="btn-glow primary login" href="#" onclick="getLogin()" id="loginBtn">登录</a>
				</form>
			</div>
		</div>

		<div class="no-account">
			<p>没有账号?</p>
			<a href="signup.html">注册</a>
		</div>
	</div>
</body>
</html>
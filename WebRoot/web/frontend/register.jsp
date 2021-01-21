<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="basePath"
	value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/" />
<!DOCTYPE html>
<html>
<head>
<title>用户注册</title>
<base href="${basePath}">
<link href="<%=request.getContextPath()%>/web/css/2.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/web/scripts/check.js"
	type="text/javascript"></script>
</head>
<body>
	<form class="box" action="register" method="post">
		<h1>Register</h1>
		<p>
			用户名<input id="username" type="text" name="username" maxlength="15"
				placeholder="请输入账号" />
		</p>
		<p>
			密 码<input id="password" type="password" name="password"
				maxlength="25" placeholder="请输入密码" />
		</p>
		<p>
			电话<input id="telephone" type="text" name="telephone" maxlength="25"
				placeholder="请输入电话" />
		</p>
	
		<input type="submit" class="Login1"
			onclick="return checkRegisterForm();" name="mysubmit" value="注册" />
        <p>
		<a href="<%=request.getContextPath()%>/web/login.jsp">切换到登录页面</a>
	    </p>
	</form>
	



</body>
</html>

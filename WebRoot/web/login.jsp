<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="basePath"
	value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/" />
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<title>用户登录</title>
<base href="${basePath}">
<script src="<%=request.getContextPath()%>/web/scripts/check.js"
	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/web/css/2.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<form class="box" action="login" method="post">
		<h1>Login</h1>
		<p>
			用户名<input id="username" type="text" name="username" maxlength="15"
				placeholder="请输入账号" />
		</p>
		<p>
			密 码<input  id="password"  type="password" name="password" maxlength="25"
				placeholder="请输入密码" /> 
		</p>
		<input type="submit" class="Login1" onclick="return checkLoginForm();"
			name="mysubmit" value="登录" />
		<p>
			如果你不是本站用户，单击<a href="web/frontend/register.jsp">此处</a>注册。
		</p>

	</form>
	<c:if test="${registerMsg!=null}">
		<script type="text/javascript">
			alert("${registerMsg}")
		</script>
		<c:remove var="registerMsg" />
	</c:if>

	<c:if test="${loginMsg!=null}">
		<script type="text/javascript">
			alert("${loginMsg}")
		</script>
		<c:remove var="loginMsg" />
	</c:if>


</body>
</html>

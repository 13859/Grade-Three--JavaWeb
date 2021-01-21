<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="basePath"
	value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/" />
<!DOCTYPE html>
<html>
<head>
<title>显示商品类别</title>
<base href="${basePath}">
<link href="<%=request.getContextPath()%>/web/css/main.css"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="showCategory">
		<div class="websiteTitle">
			<h1>南苑の茶</h1>
		</div>
		<div>
			登录用户：<span style="color: black;">${username}</span>
			<c:forEach var="i" begin="1" end="5">             
        </c:forEach>
			<a href="logout">注销</a>
		</div>
		<div class="title">
			<h3>商品类别</h3>
		</div>
		<div class="main">
			<table>
				<tr>
					<th>类别编号</th>
					<th>商品类别</th>
				</tr>
				<c:forEach var="category" items="${categorys}">
					<tr align='center'>
						<td>${category.id}</td>
						<td width="150"><a
							href="<%=request.getContextPath()%>/showProduct?categoryId=${category.id}">${category.name}</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

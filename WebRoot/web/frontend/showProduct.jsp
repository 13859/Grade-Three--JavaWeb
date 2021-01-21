<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="basePath"
	value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/" />
<!DOCTYPE html>
<html>
<head>
<title>显示商品信息</title>
<base href="${basePath}">
<link href="<%=request.getContextPath()%>/web/css/main.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>南苑の茶甜品购物网</h1>
	<hr width="700px">
	登录用户：
	<span style="color: black;">${username}</span>
	<c:forEach var="i" begin="1" end="5">     
</c:forEach>
	<a href="logout">注销</a>
	
	<hr width="700px">
	欢迎选购【
	<span style="color: #ff889d; font-weight: bold;">${categoryName}</span>】类商品
	<hr width="700px">
	<table >
		<c:forEach varStatus="status" var="product" items="${products}">
			<c:if test="${status.count%5==0}">
				<tr>
			</c:if>
			<td>
				<table>
					<tr>
						<img src="web/images/product${product.id}.png" width="60px"
							height="60px">
					</tr>
					<tr>
						<th><b>商品编号：</b>
						</th>
						<th>${product.id}</th>
					</tr>
					<tr>
						<td><b>商品名称：</b>
						</td>
						<td>${product.name}</td>
					</tr>
					<tr>
						<td><b>销售价格：</b>
						</td>
						<td>${product.price}</td>
					</tr>
					<tr>
						<td><b>上架时间：</b>
						</td>
						<td><fmt:formatDate value="${product.addTime}"
								pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<td><b>用户操作：</b>
						</td>
						<td><a href="operateCart?id=${product.id}&operation=add">加入购物车</a>
						</td>
					</tr>
				</table>
			</td>
			<c:if test="${status.count%4==0}">
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<hr width="700px">
	<a style="color: #ff889d;" href="showCategory">返回商品类别页面</a>
	<hr width="700px">
	<jsp:include page="showCart.jsp" />
</body>
</html>

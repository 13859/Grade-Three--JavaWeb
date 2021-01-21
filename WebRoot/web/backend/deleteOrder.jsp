<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>
<!DOCTYPE html>
<html>
<head>
    <title>显示订单信息</title>
    <base href="${basePath}">
    <link href="<%=request.getContextPath()%>/web/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<hr>
<table width="90%" border="0px">
    <tr>
        <td align="left">登录用户：<span style="color: black;">${username}</span></td>
        <td align="right"><a href="logout" target="_parent">注销</a></td>
    </tr>
</table>
<hr>
<h3>订单列表</h3>
<hr>
<table border="1" width="90%" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>用户电话</th>
        <th>订单金额</th>
        <th>寄送地址</th>
        <th>订单生成时间</th>
        
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr align="center">
            <td>${order.id}</td>
            <td>${order.username}</td>
            <td>${order.telephone}</td>
            <td>${order.totalPrice}</td>
            <td>${order.deliveryAddress}</td>
            <td><fmt:formatDate value="${order.orderTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            <td><a href="operateOrder?id=${order.id}&operation=delete" >删除</a></td>
            
          
        </tr>
    </c:forEach>
</table>
<hr>
</body>
</html>

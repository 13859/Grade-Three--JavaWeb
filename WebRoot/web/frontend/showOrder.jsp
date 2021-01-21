<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>
<!DOCTYPE html>
<html>
<head>
    <title>显示订单</title>
    <base href="${basePath}">
    <link href="<%=request.getContextPath()%>/web/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="showOrder">
    <div class="websiteTitle">
        <h1>南苑の茶</h1>
    </div>
    <div>
        登录用户：<span style="color: black;">${lastOrder.getUsername()}</span>
        <c:forEach var="i" begin="1" end="5">             
        </c:forEach>
        <a href="logout">注销</a>
    </div>
    <div class="title">
        <h3>生成订单</h3>
    </div>
    <div class="main">
        <table border="1" cellspacing="0">
            <tr>
                <th>订单编号</th>
                <td>${lastOrder.id}</td>
            </tr>
            <tr>
                <th>用户名</th>
                <td>${lastOrder.username}</td>
            </tr>
            <tr>
                <th>联系电话</th>
                <td>${lastOrder.telephone}</td>
            </tr>
            <tr>
                <th>总金额</th>
                <td>${lastOrder.totalPrice}</td>
            </tr>
            <tr>
                <th>送货地址</th>
                <td>${lastOrder.deliveryAddress}</td>
            </tr>
        </table>
    </div>
    <div class="footer">
        <p><a href="pay" onclick="alert('${lastOrder.username}，支付成功！');">支付</a></p>
    </div>
</div>
</body>
</html>

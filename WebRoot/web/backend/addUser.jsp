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
    <title>显示用户信息</title>
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
<h3>用户列表</h3>
<hr>
<table border="1" width="90%" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>电话</th>
        <th>注册时间</th>
        <th>权限</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr align="center">
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.telephone}</td>
            <td><fmt:formatDate value="${user.registerTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            <td>
                <c:choose>
                    <c:when test="${user.popedom==0}">
                        管理员
                    </c:when>
                    <c:otherwise>
                        普通用户
                    </c:otherwise>
                </c:choose>
            </td>
            <td><a href="<%=request.getContextPath()%>/web/backend/addTrueaddUser.jsp" >添加</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>
<!DOCTYPE html>
<html>
<head>
    <title>生成订单</title>
    <base href="${basePath}">
    <link href="<%=request.getContextPath()%>/web/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="makeOrder">
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
        <h3>生成订单</h3>
    </div>
    <div class="main">
        <form action="makeOrder" method="post">
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="username" readonly="readonly"
                               value="${username}"/></td>
                </tr>
                <tr>
                    <td>联系电话</td>
                    <td><input type="text" name="telephone"/></td>
                </tr>
                <tr>
                    <td>总金额</td>
                    <td><input type="text" name="totalPrice" readonly="readonly"
                               value="${totalPrice}"/></td>
                </tr>
                <tr>
                    <td>送货地址</td>
                    <td><input type="text" name="deliveryAddress"/></td>
                </tr>
                <tr align="center">
                    <td colspan="2"><input type="submit" value="生成订单"/> <input
                            type="reset" value="重置"/></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="footer">
        <p><a href="showCategory">返回商品类别页面</a></p>
    </div>
</div>
</body>
</html>

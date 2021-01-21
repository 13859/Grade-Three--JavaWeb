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
    <title>显示购物车</title>
    <base href="${basePath}">
</head>
<body>
<h3>${username}的购物车</h3>
<table>
    <tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>销售价格</th>
        <th>购买数量</th>
        <th>合计金额</th>
        <th>用户操作</th>
    </tr>
    <c:forEach var="shoppingItem" items="${shoppingTable}">
        <tr>
            <td>${shoppingItem.id}</td>
            <td>${shoppingItem.name}</td>
            <td>￥${shoppingItem.price}</td>
            <td>${shoppingItem.amount}</td>
            <td>￥${shoppingItem.sum}</td>
            <td><a href="operateCart?id=${shoppingItem.id}&operation=delete">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td>总金额</td>
        <td></td>
        <td></td>
        <td></td>
        <c:choose>
            <c:when test="${totalPrice==null}">
                <td style="color: red">￥0.00</td>
            </c:when>
            <c:otherwise>
                <td style="color: red">￥${totalPrice}</td>
            </c:otherwise>
        </c:choose>
        <td></td>
    </tr>
</table>
<hr width="800px">
<c:choose>
    <c:when test="${totalPrice==null}">
        <a style="color: #ff889d;" href="web/frontend/makeOrder.jsp?totalPrice=0.00">生成订单</a>
    </c:when>
    <c:otherwise>
        <a style="color: #ff889d;" href="web/frontend/makeOrder.jsp?totalPrice=${totalPrice}">生成订单</a>
    </c:otherwise>
</c:choose>
<c:if test="${orderMsg!=null}">
    <script type="text/javascript">alert("${orderMsg}")</script>
    <c:remove var="orderMsg"/>
</c:if>
</body>
</html>

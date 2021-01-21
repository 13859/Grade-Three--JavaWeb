<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理左面板</title>
    <base href="${basePath}">
    <link rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function show(id) {
            var obj = document.getElementById('c_' + id);
            if (obj.style.display == 'block') {
                obj.style.display = 'none';
            } else {
                obj.style.display = 'block';
            }
        }
    </script>
</head>

<body style="background:#ffc8d2;">
<table  cellSpacing=0 cellPadding=0 width='100%' border=0>
    <tbody >
    <tr>
        <td class=catemenu> <a
                style='CURSOR: pointer' οnclick=show(1)><img src="web/images/folder.png">用户管理</a>
        </td>
    </tr>
    <tbody id=c_1>
    <tr>
        <td class=bar2 height=20>  <img src="web/images/file.png"> <a  style="color:black;" href="showUser" target="main_frame">查看用户</a></td>
    </tr>
    <tr>
        <td class=bar2 height=20>  <img src="web/images/file.png"> <a style="color:black;" href="addUser" target="main_frame">添加用户</a>
        </td>
    </tr>
    <tr>
        <td class=bar2 height=20>  <img src="web/images/file.png"> <a style="color:black;" href="updateUser" target="main_frame">更新用户</a>
        </td>
    </tr>
    <tr>
        <td class=bar2 height=20>  <img src="web/images/file.png"> <a style="color:black;" href="deletetUser" target="main_frame">删除用户</a>
        </td>
    </tr>
    </tbody>

    <tbody>
    <tr>
        <td class=catemenu> <a
                style='CURSOR: pointer' οnclick=show(2)><img src="web/images/folder.png">
            类别管理</a></td>
    </tr>
    <tbody id=c_2 >
    <tr>
        <td class=bar2 height=20>  <img src="web/images/file.png"> <a style="color:black;" href="showCategoryTable" target="main_frame">查看类别</a>
        </td>
    </tr>
  
    </tbody>

    <tbody>
    <tr>
        <td class=catemenu> <a
                style='CURSOR: pointer' οnclick=show(3)><img src="web/images/folder.png">
            商品管理</a></td>
    </tr>
    <tbody id=c_3 >
    <tr>
        <td class=bar2 height=20>  <img src="web/images/file.png"> <a style="color:black;" href="showProductTable" target="main_frame">查看商品</a>
        </td>
    </tr>
    <tr>
        <td class=bar2 height=20>  <img src="web/images/file.png"> <a style="color:black;" href="addProduct" target="main_frame">添加商品</a>
        </td>
    </tr>
    </tbody>

    <tbody>
    <tr>
        <td class=catemenu> <a
                style='CURSOR: pointer' οnclick=show(4)><img src="web/images/folder.png">
            订单管理</a></td>
    </tr>
    <tbody id=c_4 >
    <tr>
        <td class=bar2 height=20>  <img src="web/images/file.png"> <a style="color:black;" href="showOrder" target="main_frame">查看订单</a>
        </td>
    </tr>
    <tr>
        <td class=bar2 height=20>  <img src="web/images/file.png"> <a style="color:black;" href="deleteOrder" target="main_frame">删除订单</a>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>

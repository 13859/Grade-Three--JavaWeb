<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>
<!DOCTYPE html>
<html>
<head>
    <title>用户注册</title>
    <base href="${basePath}">
    <link href="<%=request.getContextPath()%>/web/css/2.css" rel="stylesheet" type="text/css"/>
    <script src="<%=request.getContextPath()%>/web/scripts/check.js" type="text/javascript"></script>
</head>
<body>
<form class="box" action="operateProduct?operation=add" method="post">
		<p>
			商品名<input id="name" type="text" name="name" maxlength="15"
				placeholder="请输入商品名" />
		</p>
		<p>
			商品价格<input id="price" type="text" name="price"
				maxlength="15" placeholder="请输入商品价格" />
		</p>
		<p>
			商品类别编号<input id="categoryId" type="text" name="categoryId" maxlength="5"
				placeholder="请输入电话" />
		</p>
		
	
		<input type="submit" class="Login1"
			onclick="return checkAddProductForm();" name="mysubmit" value="添加" /> 
	    </form>
    


<c:if test="${registerMsg!=null}">
		<script type="text/javascript">
			alert("${registerMsg}")
		</script>
		<c:set var="registerMsg" value="" />
	</c:if>
</body>
</html>

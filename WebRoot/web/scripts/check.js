/**
 * 检验登录表单
 *
 * @returns {Boolean}
 */
function checkLoginForm() {
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    if (username.value == "") {
        alert("用户名不能为空！");
        username.focus();
        return false;
    }
    if (password.value == "") {
        alert("密码不能为空！");
        password.focus();
        return false;
    }
    return true;
}

/**
 * 检验注册表单
 *
 * @returns {Boolean}
 */
function checkRegisterForm() {
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var telephone = document.getElementById("telephone");
    if (username.value == "") {
        alert("用户名不能为空！");
        username.focus();
        return false;
    }
    if (password.value == "") {
        alert("密码不能为空！");
        password.focus();
        return false;
    }

    //var pattern = "/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/";
    if (telephone.value=="") {
        alert("电话不能为空！");
        telephone.focus();
        return false;
    }
    return true;
}
/**后台后台后台
 * 检验添加产品表单
 *
 * @returns {Boolean}
 */
function checkAddProductForm() {
    var name = document.getElementById("name");
    var price = document.getElementById("price");
    var categoryId = document.getElementById("categoryId");
    if (name.value == "") {
        alert("商品名不能为空！");
        name.focus();
        return false;
    }
    if (price.value == "") {
        alert("商品价格不能为空！");
        price.focus();
        return false;
    }
    if (categoryId.value == "") {
        alert("商品类别编号不能为空！");
        categoryId.focus();
        return false;
    }
    return true;
}
/**后台后台后台
 * 检验添加用户表单
 *
 * @returns {Boolean}
 */
function checkAddUserForm() {
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var telephone = document.getElementById("telephone");
    var obj = document.getElementsByName("popedom");
    if (username.value == "") {
        alert("用户名不能为空！");
        username.focus();
        return false;
    }
    if (password.value == "") {
        alert("密码不能为空！");
        password.focus();
        return false;
    }

    //var pattern = "/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/";
    if (telephone.value=="") {
        alert("电话不能为空！");
        telephone.focus();
        return false;
    }
    if(!obj[0].checked&&!obj[1].checked){
    		alert("请选择单选框！");
            return false;
    	}
    	
    	 
      
    
   
    return true;
  
}















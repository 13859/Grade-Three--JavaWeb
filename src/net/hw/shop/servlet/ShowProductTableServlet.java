package net.hw.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hw.shop.bean.Product;
import net.hw.shop.bean.User;
import net.hw.shop.service.ProductService;
import net.hw.shop.service.UserService;
@WebServlet("/showProductTable")
public class ShowProductTableServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // 创建商品服务对象
        ProductService productService = new ProductService();
        // 获取全部商品
        List<Product> products = productService.findAllProducts();
        // 获取session对象
        HttpSession session = request.getSession();
        // 把商品列表以属性的方式保存到session里
        session.setAttribute("products", products);
        // 重定向到显示商品页面（showProduct.jsp）
        response.sendRedirect(request.getContextPath() + "/web/backend/showProduct.jsp");
       
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

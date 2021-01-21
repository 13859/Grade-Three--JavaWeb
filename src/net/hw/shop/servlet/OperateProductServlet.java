package net.hw.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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

@WebServlet("/operateProduct")
public class OperateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// 设置请求对象的字符编码
		request.setCharacterEncoding("utf-8");

		// 获取商品操作
		String operation = request.getParameter("operation");

		// 获取用户名
		String name = request.getParameter("name");
		// 获取密码
		double price = Double.parseDouble(request.getParameter("price"));
		// 获取电话号码
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
      
		// 设置注册时间（时间戳对象）
		Timestamp AddTime = new Timestamp(System.currentTimeMillis());
		// 创建用户对象
		Product product = new Product();
		// 设置用户对象信息
		product.setName(name);
		product.setPrice(price);

		product.setAddTime(AddTime);
		product.setCategoryId(categoryId);

		// 创建UserService对象
		ProductService productService = new ProductService();
		// 调用UserService对象的添加用户方法
		int count = productService.addProduct(product);
		// 判断是否注册成功
		if (count > 0) {

			// 创建用户服务对象
			ProductService productService1 = new ProductService();
			// 获取全部用户
			List<Product> products = productService1.findAllProducts();
			for (int i = 0; i < products.size(); i++) {
				Product a = products.get(i);// 直接拿这个a去点get或者set就行了
				System.out.println(a.getName());
			}

			// 获取session对象
			HttpSession session1 = request.getSession();
			// 把用户列表以属性的方式保存到session里
			session1.setAttribute("products", products);
			// 重定向到登录页面
			response.sendRedirect(request.getContextPath()
					+ "/web/backend/addProduct.jsp");
		
		} else {

			// 重定向到注册页面
			response.sendRedirect(request.getContextPath()
					+ "/web/backend/addTrueaddUser.jsp");

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

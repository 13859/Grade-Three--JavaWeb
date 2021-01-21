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

import net.hw.shop.bean.Order;
import net.hw.shop.bean.User;
import net.hw.shop.service.OrderService;
import net.hw.shop.service.UserService;
@WebServlet("/operateOrder")
public class OperateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求对象的字符编码
		request.setCharacterEncoding("utf-8");
		// 获取商品操作
		String operation = request.getParameter("operation");
		// 创建用户服务对象
	    OrderService orderService = new OrderService();
		// 获取商品标识符
		int id = Integer.parseInt(request.getParameter("id"));
		//删除指定用户
	    orderService.deleteOrderById(id);
		// 创建用户服务对象
	    OrderService orderService2 = new OrderService();
		// 获取全部用户
		List<Order> orders = orderService2.findAllOrders();
		// 获取session对象
		HttpSession session = request.getSession();
		// 把用户列表以属性的方式保存到session里
		session.setAttribute("orders", orders);
		// 重定向到显示用户页面（showUser.jsp）
		response.sendRedirect(request.getContextPath()
							+ "/web/backend/deleteOrder.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

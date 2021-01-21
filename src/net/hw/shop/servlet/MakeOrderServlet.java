package net.hw.shop.servlet;
/**
 * 功能：生成订单控制程序

 */

import java.io.IOException;

import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.hw.shop.bean.Order;

import net.hw.shop.service.OrderService;


@WebServlet("/makeOrder")
public class MakeOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置请求对象的字符编码
        request.setCharacterEncoding("utf-8");
        // 获取表单提交数据
        String username = request.getParameter("username");
        String telephone = request.getParameter("telephone");
        Double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        String deliveryAddress = request.getParameter("deliveryAddress");
        // 创建订单对象
        Order order = new Order();
        // 设置订单属性
        order.setUsername(username);
        order.setTotalPrice(totalPrice);
        order.setTelephone(telephone);
        order.setDeliveryAddress(deliveryAddress);
        order.setOrderTime(new Date());
        // 创建订单服务
        OrderService orderService = new OrderService();
        // 添加订单
        orderService.addOrder(order);
        // 获取最后一个订单
        Order lastOrder = orderService.findLastOrder();
        // 保存到session里
        request.getSession().setAttribute("lastOrder", lastOrder);
        // 重定向到显示订单页面
        response.sendRedirect(request.getContextPath() + "/web/frontend/showOrder.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

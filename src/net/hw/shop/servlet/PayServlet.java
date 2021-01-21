package net.hw.shop.servlet;
/**
 * 功能：支付处理程序

 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/pay")
public class PayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置请求对象的字符编码
        request.setCharacterEncoding("utf-8");
        ///////////////////////
        // 待做部分
        // 设置session失效
        request.getSession().invalidate();
        // 重定向到登录页面
        response.sendRedirect(request.getContextPath() + "/web/login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

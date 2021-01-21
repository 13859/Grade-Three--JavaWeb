package net.hw.shop.servlet;
/**
 * 功能：登录处理类

 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hw.shop.bean.User;
import net.hw.shop.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置请求对象的字符编码
        request.setCharacterEncoding("utf-8");
        // 获取会话对象
        HttpSession session = request.getSession();
        // 获取用户名
        String username = request.getParameter("username");
        // 获取密码
        String password = request.getParameter("password");
        // 定义用户服务对象
        UserService userService = new UserService();
        // 执行登录方法，返回用户实体
        User user = userService.login(username, password);
        // 判断用户登录是否成功
        if (user != null) {
            // 设置session属性
            session.setMaxInactiveInterval(5 * 60);
            session.setAttribute("username", username);
            session.removeAttribute("loginMsg");
            // 根据用户权限跳转到不同页面
            if (user.getPopedom() == 0) {
                System.out.println("用户登录成功，进入后台管理！");
                response.sendRedirect(request.getContextPath() + "/web/backend/management.jsp");
            } else if (user.getPopedom() == 1) {
                System.out.println("用户登录成功，进入前台显示类别！");
                response.sendRedirect(request.getContextPath() + "/showCategory");
            }
        } else {
            System.out.println("用户名或密码错误，用户登录失败！");
            // 设置session属性loginMsg
            session.setAttribute("loginMsg", "用户名或密码错误！");
            response.sendRedirect(request.getContextPath() + "/web/login.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

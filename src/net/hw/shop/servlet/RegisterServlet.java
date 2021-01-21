package net.hw.shop.servlet;
/**
 * 功能：处理用户注册

 */

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hw.shop.bean.User;
import net.hw.shop.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置请求对象的字符编码
        request.setCharacterEncoding("utf-8");
        // 获取session对象
        HttpSession session = request.getSession();

        // 获取用户名
        String username = request.getParameter("username");
        // 获取密码
        String password = request.getParameter("password");
        // 获取电话号码
        String telephone = request.getParameter("telephone");
        // 设置注册时间（时间戳对象）
        Timestamp registerTime = new Timestamp(System.currentTimeMillis());
        // 设置用户为普通用户
        int popedom = 1;

        // 创建用户对象
        User user = new User();
        // 设置用户对象信息
        user.setUsername(username);
        user.setPassword(password);
        user.setTelephone(telephone);
        user.setRegisterTime(registerTime);
        user.setPopedom(popedom);

        // 创建UserService对象
        UserService userService = new UserService();
        // 调用UserService对象的添加用户方法
        int count = userService.addUser(user);

        // 判断是否注册成功
        if (count > 0) {
            // 设置session属性
            session.setAttribute("registerMsg", "恭喜，注册成功！");
            // 重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/web/login.jsp");
            // 在控制台输出测试信息
            System.out.println("恭喜，注册成功，跳转到登录页面！");
        } else {
            // 设置session属性
            session.setAttribute("registerMsg", "遗憾，注册失败！");
            // 重定向到注册页面
            response.sendRedirect(request.getContextPath() + "/web/frontend/register.jsp");
            // 在控制台输出测试信息
            System.out.println("遗憾，注册失败，跳转到注册页面！");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

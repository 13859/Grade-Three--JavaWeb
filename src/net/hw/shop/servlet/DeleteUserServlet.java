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

import net.hw.shop.bean.User;
import net.hw.shop.service.UserService;
@WebServlet("/deletetUser")
public class DeleteUserServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建用户服务对象
        UserService userService = new UserService();
        // 获取全部用户
        List<User> users = userService.findAllUsers();
        // 获取session对象
        HttpSession session = request.getSession();
        // 把用户列表以属性的方式保存到session里
        session.setAttribute("users", users);
        // 重定向到显示用户页面（showUser.jsp）
        response.sendRedirect(request.getContextPath() + "/web/backend/deleteUser.jsp");
     
	}
	
	
		
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

}

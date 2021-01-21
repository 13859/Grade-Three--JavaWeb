package net.hw.shop.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hw.shop.bean.User;
import net.hw.shop.service.UserService;

@WebServlet("/operateUser")
public class OperateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求对象的字符编码
		request.setCharacterEncoding("utf-8");
		// 获取商品操作
		String operation = request.getParameter("operation");
		if (operation.equals("delete")) {
			// 创建用户服务对象
			UserService userService = new UserService();
			// 获取商品标识符
			int id = Integer.parseInt(request.getParameter("id"));
			// 删除指定用户
			userService.deleteUserById(id);
			// 创建用户服务对象
			UserService userService2 = new UserService();
			// 获取全部用户
			List<User> users = userService2.findAllUsers();
			// 获取session对象
			HttpSession session = request.getSession();
			// 把用户列表以属性的方式保存到session里
			session.setAttribute("users", users);
			// 重定向到显示用户页面（showUser.jsp）
			response.sendRedirect(request.getContextPath()
					+ "/web/backend/deleteUser.jsp");
		} else if (operation.equals("add")) {
			// 获取用户名
			String username = request.getParameter("username");
			// 获取密码
			String password = request.getParameter("password");
			// 获取电话号码
			String telephone = request.getParameter("telephone");
			// 获取popedom(用来判断是学生还是老师)
			int popedom = Integer.parseInt(request.getParameter("popedom"));
			// 设置注册时间（时间戳对象）
			Timestamp registerTime = new Timestamp(System.currentTimeMillis());
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

				// 创建用户服务对象
				UserService userService1 = new UserService();
				// 获取全部用户
				List<User> users = userService1.findAllUsers();
				// 获取session对象
				HttpSession session1 = request.getSession();
				// 把用户列表以属性的方式保存到session里
				session1.setAttribute("users", users);
				// 重定向到登录页面
				response.sendRedirect(request.getContextPath()
						+ "/web/backend/addUser.jsp");
				
			} else {

				// 重定向到注册页面
				response.sendRedirect(request.getContextPath()
						+ "/web/backend/addTrueaddUser.jsp");
				
			}
		} else if (operation.equals("update")) {
			
			int num = Integer.parseInt(request.getParameter("number"));
			
			if(num==1){
			// 创建用户服务对象
			UserService userService = new UserService();
			// 获取商品标识符
			int id = Integer.parseInt(request.getParameter("id"));
			// 删除指定用户
			userService.deleteUserById(id);
			// 创建用户服务对象
			UserService userService2 = new UserService();
			// 获取全部用户
			List<User> users = userService2.findAllUsers();
			// 获取session对象
			HttpSession session = request.getSession();
			// 把用户列表以属性的方式保存到session里
			session.setAttribute("users", users);
			// 重定向到显示用户页面（showUser.jsp）
			response.sendRedirect(request.getContextPath()
					+ "/web/backend/addTrueaddUser.jsp");
			}
			else{
				// 获取用户名
				String username = request.getParameter("username");
				// 获取密码
				String password = request.getParameter("password");
				// 获取电话号码
				String telephone = request.getParameter("telephone");
				// 获取popedom(用来判断是学生还是老师)
				int popedom = Integer.parseInt(request.getParameter("popedom"));
				// 设置注册时间（时间戳对象）
				Timestamp registerTime = new Timestamp(System.currentTimeMillis());
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

					// 创建用户服务对象
					UserService userService1 = new UserService();
					// 获取全部用户
					List<User> users = userService1.findAllUsers();
					// 获取session对象
					HttpSession session1 = request.getSession();
					// 把用户列表以属性的方式保存到session里
					session1.setAttribute("users", users);
					// 重定向到登录页面
					response.sendRedirect(request.getContextPath()
							+ "/web/backend/updateUser.jsp");
					
				} else {

					// 重定向到注册页面
					response.sendRedirect(request.getContextPath()
							+ "/web/backend/addTrueaddUser.jsp");
					
				}
			
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}

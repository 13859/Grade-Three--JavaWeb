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

import net.hw.shop.bean.Category;
import net.hw.shop.bean.User;
import net.hw.shop.service.CategoryService;
import net.hw.shop.service.UserService;

@WebServlet("/showCategory")
public class ShowCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // 创建商品类别服务类对象
       CategoryService categoryService = new CategoryService();
        // 获取全部商品类别
        List<Category> categorys = categoryService.findAllCategories();
        // 获取session对象
        HttpSession session = request.getSession();
        // 把用户列表以属性的方式保存到session里
        session.setAttribute("categorys", categorys);
        // 重定向到显示用户页面（showUser.jsp）
        response.sendRedirect(request.getContextPath() + "/web/frontend/showCategory.jsp");
       
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

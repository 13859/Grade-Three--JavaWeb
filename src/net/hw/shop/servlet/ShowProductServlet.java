package net.hw.shop.servlet;
/**
 * 功能：显示商品列表的控制程序
 *     通过业务层访问后台数据，
 *     然后将数据返回给前台页面

 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hw.shop.bean.Product;
import net.hw.shop.service.CategoryService;
import net.hw.shop.service.ProductService;

@WebServlet("/showProduct")
public class ShowProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取类别标识符
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        // 创建商品类别服务对象
        CategoryService categoryService = new CategoryService();
        // 判断商品类别是否存在
        if (categoryService.findCategoryById(categoryId) != null) {
            // 由类别标识符获取类别名
            String categoryName = categoryService.findCategoryById(categoryId).getName();
            // 创建商品服务对象
            ProductService productService = new ProductService();
            // 获取指定商品类别的商品列表
            List<Product> products = productService.findProductsByCategoryId(categoryId);
            // 获取session对象                     
            HttpSession session = request.getSession();
            // 把商品列表对象以属性的方式保存到session里
            session.setAttribute("products", products);
            // 把类别名以属性的方式保存到session里
            session.setAttribute("categoryName", categoryName);
            // 重定向到显示商品信息页面
            response.sendRedirect(request.getContextPath() + "/web/frontend/showProduct.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

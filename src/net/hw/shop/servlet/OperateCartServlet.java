package net.hw.shop.servlet;
/**
 * 功能：操作购物车控制程序

 */

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hw.shop.service.ProductService;

@WebServlet("/operateCart")
public class OperateCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取商品标识符
        int id = Integer.parseInt(request.getParameter("id"));
        // 获取商品操作
        String operation = request.getParameter("operation");

        // 从session里获取购物车（键：商品标识符；值：购买数量）
        LinkedHashMap<Integer, Integer> cart = (LinkedHashMap<Integer, Integer>) request.getSession()
                .getAttribute("cart");
        // 判断购物车是否为空
        if (cart == null) {
            // 创建购物车
            cart = new LinkedHashMap<Integer, Integer>();
            // 将购物车保存到session里，便于用户在不同页面访问购物车
            request.getSession().setAttribute("cart", cart);
        }

        if (operation.equals("add")) {
            // 将商品添加到购物车
            if (cart.containsKey(id)) { // 该商品已购买过
                // 购买数量增加1
                cart.put(id, cart.get(id) + 1);
            } else { // 该商品未曾购买
                // 购买数量设置为1
                cart.put(id, 1);
            }
        } else if (operation.equals("delete")){
            // 将商品从购物车删除
            if (cart.get(id) > 1) {
                // 购买数量减少1
                cart.put(id, cart.get(id) - 1);
            } else {
                // 从购物车里删除该商品
                cart.remove(id);
            }
        }

        // 创建商品服务对象
        ProductService productService = new ProductService();
        // 获取该商品类别标识符
        int categoryId = productService.findProductById(id).getCategoryId();
        // 重定向到显示购物车控制程序
        response.sendRedirect(request.getContextPath() + "/showCart?categoryId=" + categoryId);
    }
}

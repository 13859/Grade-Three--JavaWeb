package net.hw.shop.servlet;
/**
 * 功能：显示购物车控制程序

 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hw.shop.bean.Product;
import net.hw.shop.service.ProductService;

@WebServlet("/showCart")
public class ShowCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取商品类别标识符
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        // 获取session对象
        HttpSession session = request.getSession();
        // 获取购物车
        LinkedHashMap<Integer, Integer> cart = (LinkedHashMap<Integer, Integer>) session.getAttribute("cart");

        // 判断购物车是否为空
        if (cart != null) {
            // 定义购物表
            List<HashMap<String, Object>> shoppingTable = new ArrayList<HashMap<String, Object>>();
            // 创建商品服务对象
            ProductService productService = new ProductService();
            // 购物总金额
            double totalPrice = 0.0;
            // 遍历购物车
            for (Integer id : cart.keySet()) {
                // 获取商品对象
                Product product = productService.findProductById(id);
                // 生成购物表记录
                HashMap<String, Object> shoppingItem = new HashMap<String, Object>();
                shoppingItem.put("id", product.getId());
                shoppingItem.put("name", product.getName());
                shoppingItem.put("price", product.getPrice());
                shoppingItem.put("amount", cart.get(id));
                shoppingItem.put("sum", product.getPrice() * cart.get(id));
                // 将购物表记录添加到购物表中
                shoppingTable.add(shoppingItem);
                // 累加购买总金额
                totalPrice = totalPrice + (Double) shoppingItem.get("sum");
            }

            // 将购物表和购买总金额保存到session里
            session.setAttribute("shoppingTable", shoppingTable);
            session.setAttribute("totalPrice", totalPrice);

            // 重定向到显示商品控制程序
            response.sendRedirect(request.getContextPath() + "/web/frontend/showProduct.jsp?categoryId=" + categoryId);
        } else {
            System.out.println("购物车里没有类别号为[" + categoryId + "]的商品！");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

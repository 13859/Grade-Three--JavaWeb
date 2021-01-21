package net.hw.shop.dao.impl;

import net.hw.shop.bean.Order;
import net.hw.shop.dao.OrderDao;
import org.junit.Test;

import java.util.List;

public class TestOrderDaoImpl {
    @Test
    public void testFindAll() {
        // 创建订单数据访问对象
        OrderDao orderDao = new OrderDaoImpl();
        // 获取全部订单
        List<Order> orders = orderDao.findAll();
        // 判断是否有订单
        if (orders.size() > 0) {
            // 遍历订单列表
            for (Order order: orders) {
                System.out.println(order);
            }
        } else {
            System.out.println("没有订单！");
        }
    }
}

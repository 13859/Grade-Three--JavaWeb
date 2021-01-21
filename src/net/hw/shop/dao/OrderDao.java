package net.hw.shop.dao;

/**
 * 功能：订单数据访问接口

 */
import java.util.List;

import net.hw.shop.bean.Order;

public interface OrderDao {
    // 插入订单
    int insert(Order order);
    // 按标识符删除订单
    int deleteById(int id);
    // 更新订单
    int update(Order order);
    // 按标识符查询订单
    Order findById(int id);
    // 查询最后一个订单
    Order findLast();
    // 查询全部订单
    List<Order> findAll();
}
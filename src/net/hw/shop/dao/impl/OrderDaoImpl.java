package net.hw.shop.dao.impl;
/**
 * 功能：订单数据访问接口实现类

 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.hw.shop.bean.Order;
import net.hw.shop.dao.OrderDao;
import net.hw.shop.dbutil.ConnectionManager;

public class OrderDaoImpl implements OrderDao {
    /**
     * 插入订单
     */
    @Override
    public int insert(Order order) {
        // 定义插入记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "INSERT INTO t_order (username, telephone, total_price, delivery_address, order_time)"
                + " VALUES (?, ?, ?, ?, ?)";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, order.getUsername());
            pstmt.setString(2, order.getTelephone());
            pstmt.setDouble(3, order.getTotalPrice());
            pstmt.setString(4, order.getDeliveryAddress());
            pstmt.setTimestamp(5, new Timestamp(order.getOrderTime().getTime()));
            // 执行更新操作，插入记录
            count = pstmt.executeUpdate();
            // 关闭预备语句对象
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }

        // 返回插入记录数
        return count;
    }

    /**
     * 删除订单
     */
    @Override
    public int deleteById(int id) {
        // 定义删除记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "DELETE FROM t_order WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setInt(1, id);
            // 执行更新操作，删除记录
            count = pstmt.executeUpdate();
            // 关闭预备语句对象
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }

        // 返回删除记录数
        return count;
    }

    /**
     * 更新订单
     */
    @Override
    public int update(Order order) {
        // 定义更新记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "UPDATE t_order SET username = ?, telephone = ?, total_price = ?,"
                + " delivery_address = ?, order_time = ? WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, order.getUsername());
            pstmt.setString(2, order.getTelephone());
            pstmt.setDouble(3, order.getTotalPrice());
            pstmt.setString(4, order.getDeliveryAddress());
            pstmt.setTimestamp(5, new Timestamp(order.getOrderTime().getTime()));
            pstmt.setInt(6, order.getId());
            // 执行更新操作，更新记录
            count = pstmt.executeUpdate();
            // 关闭预备语句对象
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }

        // 返回更新记录数
        return count;
    }

    /**
     * 查询最后一个订单
     */
    @Override
    public Order findLast() {
        // 声明订单
        Order order = null;
        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_order";
        try {
            // 创建语句对象
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // 执行SQL，返回结果集
            ResultSet rs = stmt.executeQuery(strSQL);
            // 定位到最后一条记录
            if (rs.last()) {
                // 创建订单实体
                order = new Order();
                // 设置实体属性
                order.setId(rs.getInt("id"));
                order.setUsername(rs.getString("username"));
                order.setTelephone(rs.getString("telephone"));
                order.setTotalPrice(rs.getDouble("total_price"));
                order.setDeliveryAddress(rs.getString("delivery_address"));
                order.setOrderTime(rs.getTimestamp("order_time"));
            }
            // 关闭结果集
            rs.close();
            // 关闭语句对象
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            ConnectionManager.closeConnection(conn);
        }
        // 返回订单对象
        return order;
    }

    /**
     * 按标识符查询订单
     */
    @Override
    public Order findById(int id) {
        // 声明订单
        Order order = null;

        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_order WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setInt(1, id);
            // 执行SQL查询，返回结果集
            ResultSet rs = pstmt.executeQuery();
            // 判断结果集是否有记录
            if (rs.next()) {
                // 实例化订单
                order = new Order();
                // 利用当前记录字段值去设置订单的属性
                order.setId(rs.getInt("id"));
                order.setUsername(rs.getString("username"));
                order.setTelephone(rs.getString("telephone"));
                order.setTotalPrice(rs.getDouble("total_price"));
                order.setDeliveryAddress(rs.getString("delivery_address"));
                order.setOrderTime(rs.getTimestamp("order_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }

        // 返回订单
        return order;
    }

    /**
     * 查询全部订单
     */
    @Override
    public List<Order> findAll() {
        // 声明订单列表
        List<Order> orders = new ArrayList<Order>();
        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_order";
        try {
            // 创建语句对象
            Statement stmt = conn.createStatement();
            // 执行SQL，返回结果集
            ResultSet rs = stmt.executeQuery(strSQL);
            // 遍历结果集
            while (rs.next()) {
                // 创建订单实体
                Order order = new Order();
                // 设置实体属性
                order.setId(rs.getInt("id"));
                order.setUsername(rs.getString("username"));
                order.setTelephone(rs.getString("telephone"));
                order.setTotalPrice(rs.getDouble("total_price"));
                order.setDeliveryAddress(rs.getString("delivery_address"));
                order.setOrderTime(rs.getTimestamp("order_time"));
                // 将实体添加到订单列表
                orders.add(order);
            }
            // 关闭结果集
            rs.close();
            // 关闭语句对象
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            ConnectionManager.closeConnection(conn);
        }
        // 返回用户列表
        return orders;
    }
}
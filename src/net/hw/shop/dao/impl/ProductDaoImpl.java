package net.hw.shop.dao.impl;

/**
 * 功能：产品数据访问接口实现类

 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.hw.shop.bean.Product;
import net.hw.shop.dao.ProductDao;
import net.hw.shop.dbutil.ConnectionManager;

public class ProductDaoImpl implements ProductDao {
    /**
     * 插入商品
     */
    @Override
    public int insert(Product product) {
        // 定义插入记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "INSERT INTO t_product (name, price, add_time, category_id)" + " VALUES (?, ?, ?, ?)";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setTimestamp(3, new Timestamp(product.getAddTime().getTime()));
            pstmt.setInt(4, product.getCategoryId());
            // 执行更新操作，插入新记录
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
     * 删除商品
     */
    @Override
    public int deleteById(int id) {
        // 定义删除记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "DELETE FROM t_product WHERE id = ?";
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
     * 更新商品
     */
    @Override
    public int update(Product product) {
        // 定义更新记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "UPDATE t_product SET name = ?, price = ?, add_time = ?,"
                + " category_id = ? WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setTimestamp(3, new Timestamp(product.getAddTime().getTime()));
            pstmt.setInt(4, product.getCategoryId());
            pstmt.setInt(5, product.getId());
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
     * 按标识符查找商品
     */
    @Override
    public Product findById(int id) {
        // 声明商品
        Product product = null;
        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_product WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setInt(1, id);
            // 执行SQL查询，返回结果集
            ResultSet rs = pstmt.executeQuery();
            // 判断结果集是否有记录
            if (rs.next()) {
                // 实例化商品
                product = new Product();
                // 利用当前记录字段值去设置商品类别的属性
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setAddTime(rs.getTimestamp("add_time"));
                product.setCategoryId(rs.getInt("category_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }

        // 返回商品
        return product;
    }

    /**
     * 按类别查询商品
     */
    @Override
    public List<Product> findByCategoryId(int categoryId) {
        // 定义商品列表
        List<Product> products = new ArrayList<Product>();

        // 获取数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_product WHERE category_id = ?";
        try {
            // 创建预备语句
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setInt(1, categoryId);
            // 执行SQL语句，返回结果集
            ResultSet rs = pstmt.executeQuery();
            // 遍历结果集，将其中的每条记录生成商品对象，添加到商品列表
            while (rs.next()) {
                // 实例化商品对象
                Product product = new Product();
                // 利用当前记录字段值设置实体对应属性
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setAddTime(rs.getTimestamp("add_time"));
                product.setCategoryId(rs.getInt("category_id"));
                // 将商品添加到商品列表
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }
        // 返回商品列表
        return products;
    }

    /**
     * 查询全部商品
     */
    @Override
    public List<Product> findAll() {
        // 声明商品列表
        List<Product> products = new ArrayList<Product>();
        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_product";
        try {
            // 创建语句对象
            Statement stmt = conn.createStatement();
            // 执行SQL，返回结果集
            ResultSet rs = stmt.executeQuery(strSQL);
            // 遍历结果集
            while (rs.next()) {
                // 创建商品实体
                Product product = new Product();
                // 设置实体属性
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setAddTime(rs.getTimestamp("add_time"));
                product.setCategoryId(rs.getInt("category_id"));
                // 将实体添加到商品列表
                products.add(product);
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
        // 返回商品列表
        return products;
    }
}
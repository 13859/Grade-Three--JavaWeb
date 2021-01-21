package net.hw.shop.dao.impl;

/**
 * 功能：类别数据访问接口实现类

 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.hw.shop.bean.Category;
import net.hw.shop.dao.CategoryDao;
import net.hw.shop.dbutil.ConnectionManager;

public class CategoryDaoImpl implements CategoryDao {
    /**
     * 插入类别
     */
    @Override
    public int insert(Category category) {
        // 定义插入记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "INSERT INTO t_category (name) VALUES (?)";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, category.getName());
            // 执行更新操作，插入新录
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
     * 删除类别
     */
    @Override
    public int deleteById(int id) {
        // 定义删除记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "DELETE FROM t_category WHERE id = ?";
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
     * 更新类别
     */
    @Override
    public int update(Category category) {
        // 定义更新记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "UPDATE t_category SET name = ? WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, category.getName());
            pstmt.setInt(2, category.getId());
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
     * 按标识符查询类别
     */
    @Override
    public Category findById(int id) {
        // 声明商品类别
        Category category = null;

        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_category WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setInt(1, id);
            // 执行SQL查询，返回结果集
            ResultSet rs = pstmt.executeQuery();
            // 判断结果集是否有记录
            if (rs.next()) {
                // 实例化商品类别
                category = new Category();
                // 利用当前记录字段值去设置商品类别的属性
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }

        // 返回商品类别
        return category;
    }

    /**
     * 查询全部类别
     */
    @Override
    public List<Category> findAll() {
        // 声明类别列表
        List<Category> categories = new ArrayList<Category>();
        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_category";
        try {
            // 创建语句对象
            Statement stmt = conn.createStatement();
            // 执行SQL，返回结果集
            ResultSet rs = stmt.executeQuery(strSQL);
            // 遍历结果集
            while (rs.next()) {
                // 创建类别实体
                Category category = new Category();
                // 设置实体属性
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                // 将实体添加到类别列表
                categories.add(category);
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
        // 返回类别列表
        return categories;
    }
}
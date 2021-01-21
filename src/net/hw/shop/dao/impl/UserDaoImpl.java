package net.hw.shop.dao.impl;

/**
 * 功能：用户数据访问接口实现类

 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.hw.shop.bean.User;
import net.hw.shop.dao.UserDao;
import net.hw.shop.dbutil.ConnectionManager;

public class UserDaoImpl implements UserDao {
    /**
     * 插入用户
     */
    @Override
    public int insert(User user) {
        // 定义插入记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "INSERT INTO t_user (username, password, telephone, register_time, popedom)"
                + " VALUES (?, ?, ?, ?, ?)";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getTelephone());
            pstmt.setTimestamp(4, new Timestamp(user.getRegisterTime().getTime()));
            pstmt.setInt(5, user.getPopedom());
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
     * 删除用户记录
     */
    @Override
    public int deleteById(int id) {
        // 定义删除记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "DELETE FROM t_user WHERE id = ?";
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
     * 更新用户
     */
    @Override
    public int update(User user) {
        // 定义更新记录数
        int count = 0;

        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "UPDATE t_user SET username = ?, password = ?, telephone = ?,"
                + " register_time = ?, popedom = ? WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getTelephone());
            pstmt.setTimestamp(4, new Timestamp(user.getRegisterTime().getTime()));
            pstmt.setInt(5, user.getPopedom());
            pstmt.setInt(6, user.getId());
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
     * 按标识符查询用户
     */
    @Override
    public User findById(int id) {
        // 声明用户
        User user = null;

        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_user WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setInt(1, id);
            // 执行SQL查询，返回结果集
            ResultSet rs = pstmt.executeQuery();
            // 判断结果集是否有记录
            if (rs.next()) {
                // 实例化用户
                user = new User();
                // 利用当前记录字段值去设置商品类别的属性
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setTelephone(rs.getString("telephone"));
                user.setRegisterTime(rs.getTimestamp("register_time"));
                user.setPopedom(rs.getInt("popedom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }

        // 返回用户
        return user;
    }

    @Override
    public List<User> findByUsername(String username) {
        // 声明用户列表
        List<User> users = new ArrayList<User>();
        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_user WHERE username = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, username);
            // 执行SQL查询，返回结果集
            ResultSet rs = pstmt.executeQuery();
            // 遍历结果集
            while (rs.next()) {
                // 创建类别实体
                User user = new User();
                // 设置实体属性
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setTelephone(rs.getString("telephone"));
                user.setRegisterTime(rs.getTimestamp("register_time"));
                user.setPopedom(rs.getInt("popedom"));
                // 将实体添加到用户列表
                users.add(user);
            }
            // 关闭结果集
            rs.close();
            // 关闭语句对象
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            ConnectionManager.closeConnection(conn);
        }
        // 返回用户列表
        return users;
    }

    @Override
    public List<User> findAll() {
        // 声明用户列表
        List<User> users = new ArrayList<User>();
        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_user";
        try {
            // 创建语句对象
            Statement stmt = conn.createStatement();
            // 执行SQL，返回结果集
            ResultSet rs = stmt.executeQuery(strSQL);
            // 遍历结果集
            while (rs.next()) {
                // 创建用户实体
                User user = new User();
                // 设置实体属性
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setTelephone(rs.getString("telephone"));
                user.setRegisterTime(rs.getTimestamp("register_time"));
                user.setPopedom(rs.getInt("popedom"));
                // 将实体添加到用户列表
                users.add(user);
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
        return users;
    }

    /**
     * 登录方法
     */
    @Override
    public User login(String username, String password) {
        // 定义用户对象
        User user = null;
        // 获取数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_user WHERE username = ? AND password = ?";
        try {
            // 创建预备语句对象
            PreparedStatement psmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            psmt.setString(1, username);
            psmt.setString(2, password);
            // 执行查询，返回结果集
            ResultSet rs = psmt.executeQuery();
            // 判断结果集是否有记录
            if (rs.next()) {
                // 实例化用户对象
                user = new User();
                // 用记录值设置用户属性
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setTelephone(rs.getString("telephone"));
                user.setRegisterTime(rs.getDate("register_time"));
                user.setPopedom(rs.getInt("popedom"));
            }
            // 关闭结果集
            rs.close();
            // 关闭预备语句
            psmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            ConnectionManager.closeConnection(conn);
        }

        // 返回用户对象
        return user;
    }
}

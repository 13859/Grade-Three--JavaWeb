package net.hw.shop.dbutil;

/**
 * 功能：数据库连接管理类

 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionManager {
    /**
     * 数据库驱动程序
     */
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    /**
     * 数据库统一资源标识符
     */
    private static final String URL = "jdbc:mysql://localhost:3306/simonshop";
    /**
     * 数据库用户名
     */
    private static final String USERNAME = "root";
    /**
     * 数据库密码
     */
    private static final String PASSWORD = "root";

    /**
     * 私有化构造方法，拒绝实例化
     */
    private ConnectionManager() {
    }

    /**
     * 获取数据库连接静态方法
     *
     * @return 数据库连接对象
     */
    public static Connection getConnection() {
        // 定义数据库连接
        Connection conn = null;
        try {
            // 安装数据库驱动程序
            Class.forName(DRIVER);
            // 获得数据库连接
            conn = DriverManager.getConnection(URL
                    + "?useUnicode=true&characterEncoding=UTF8", USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回数据库连接
        return conn;
    }

    /**
     * 关闭数据库连接静态方法
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        // 判断数据库连接是否为空
        if (conn != null) {
            // 判断数据库连接是否关闭
            try {
                if (!conn.isClosed()) {
                    // 关闭数据库连接
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试数据库连接是否成功
     *
     * @param args
     */
    public static void main(String[] args) {
        // 获得数据库连接
        Connection conn = getConnection();
        // 判断是否连接成功
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "恭喜，数据库连接成功！");
        } else {
            JOptionPane.showMessageDialog(null, "遗憾，数据库连接失败！");
        }

        // 关闭数据库连接
        closeConnection(conn);
    }
}

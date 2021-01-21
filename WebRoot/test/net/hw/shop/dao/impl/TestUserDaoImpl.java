package net.hw.shop.dao.impl;

import net.hw.shop.bean.User;
import net.hw.shop.dao.UserDao;
import org.junit.Test;

public class TestUserDaoImpl {
    @Test
    public void testLogin() {
        String username, password;

        username = "admin";
        password = "903213";

        // 创建用户数据访问对象
        UserDao userDao = new UserDaoImpl();
        User user = userDao.login(username, password);

        // 判断用户是否登录成功
        if (user != null) {
            System.out.println("恭喜，登录成功！");
        } else {
            System.out.println("遗憾，登录失败！");
        }
    }

    @Test
    public void testUpdate() {
        // 创建用户数据访问对象
        UserDao userDao = new UserDaoImpl();

        // 找到涂文艳用户，其id是4
        User user = userDao.findById(4);
        // 修改密码与电话
        user.setPassword("903213");
        user.setTelephone("13945457890");
        // 更新涂文艳用户
        int count = userDao.update(user);
        // 判断更新用户是否成功
        if (count > 0) {
            System.out.println("恭喜，用户更新成功！");
        } else {
            System.out.println("遗憾，用户更新失败！");
        }

        // 再次查询涂文艳用户
        user = userDao.findById(4);
        // 查看涂文艳用户信息
        System.out.println(user);
    }
}

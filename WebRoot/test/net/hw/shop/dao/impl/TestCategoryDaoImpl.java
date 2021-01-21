package net.hw.shop.dao.impl;

import net.hw.shop.bean.Category;
import net.hw.shop.dao.CategoryDao;
import org.junit.Test;

import java.util.List;

public class TestCategoryDaoImpl {
    @Test
    public void testFindAll() {
        // 创建类别数据访问对象
        CategoryDao categoryDao = new CategoryDaoImpl();
        // 获取全部商品类别
        List<Category> categories = categoryDao.findAll();
        // 判断是否有类别
        if (!categories.isEmpty()) {
            for (Category category: categories) {
                System.out.println(category);
            }
        } else {
            System.out.println("没有商品类别！");
        }
    }
}
package net.hw.shop.dao.impl;

import net.hw.shop.bean.Category;
import net.hw.shop.bean.Product;
import net.hw.shop.dao.CategoryDao;
import net.hw.shop.dao.ProductDao;
import org.junit.Test;

import java.util.List;

public class TestProductDaoImpl {
    @Test
    public void testFindByCategoryId() {
        // 创建商品数据访问对象
        ProductDao productDao = new ProductDaoImpl();
        // 定义商品类别编号
        int categoryId = 5;
        // 创建商品类别数据访问对象
        CategoryDao categoryDao = new CategoryDaoImpl();
        // 判断类别是否存在
        if (categoryDao.findById(categoryId) != null) {
            // 获取类别名称
            String categoryName = categoryDao.findById(categoryId).getName();
            // 获取该类别商品
            List<Product> products = productDao.findByCategoryId(categoryId);
            // 判断商品是否存在
            if (!products.isEmpty()) {
                // 遍历商品列表
                for (Product product: products) {
                    System.out.println(product);
                }
            } else {
                System.out.println("[" + categoryName + "]类别没有商品！");
            }
        } else {
            System.out.println("类别编号[" + categoryId + "]不存在！");
        }
    }
}

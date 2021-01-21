package net.hw.shop.dao;

/**
 * 功能：商品数据访问接口

 */
import java.util.List;

import net.hw.shop.bean.Product;

public interface ProductDao {
    // 插入商品
    int insert(Product product);
    // 按标识符删除商品
    int deleteById(int id);
    // 更新商品
    int update(Product product);
    // 按标识符查询商品
    Product findById(int id);
    // 按类别查询商品
    List<Product> findByCategoryId(int categoryId);
    // 查询全部商品
    List<Product> findAll();
}
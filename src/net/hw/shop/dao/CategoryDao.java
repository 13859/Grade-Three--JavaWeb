package net.hw.shop.dao;

/**
 * 功能：类别数据访问接口

 */
import java.util.List;

import net.hw.shop.bean.Category;

public interface CategoryDao {
    // 插入类别
    int insert(Category category);
    // 按标识符删除类别
    int deleteById(int id);
    // 更新类别
    int update(Category category);
    // 按标识符查询类别
    Category findById(int id);
    // 查询全部类别
    List<Category> findAll();
}
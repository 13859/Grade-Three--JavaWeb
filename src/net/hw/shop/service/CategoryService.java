package net.hw.shop.service;

/**
 * 功能：类别服务类

 */

import java.util.List;

import net.hw.shop.bean.Category;
import net.hw.shop.dao.CategoryDao;
import net.hw.shop.dao.impl.CategoryDaoImpl;

public class CategoryService {
    /**
     * 声明类别数据访问对象
     */
    private CategoryDao categoryDao = new CategoryDaoImpl();

    public int addCategory(Category category) {
        return categoryDao.insert(category);
    }

    public int deleteCategoryById(int id) {
        return categoryDao.deleteById(id);
    }

    public int updateCategory(Category category) {
        return categoryDao.update(category);
    }

    public Category findCategoryById(int id) {
        return categoryDao.findById(id);
    }

    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }
}
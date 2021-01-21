package net.hw.shop.service;

/**
 * 功能：商品服务类

 */

import java.util.List;

import net.hw.shop.bean.Product;
import net.hw.shop.dao.ProductDao;
import net.hw.shop.dao.impl.ProductDaoImpl;

public class ProductService {
    /**
     * 声明商品数据访问对象
     */
    private ProductDao productDao = new ProductDaoImpl();

    public int addProduct(Product product) {
        return productDao.insert(product);
    }

    public int deleteProductById(int id) {
        return productDao.deleteById(id);
    }

    public int updateProduct(Product product) {
        return productDao.update(product);
    }

    public Product findProductById(int id) {
        return productDao.findById(id);
    }

    public List<Product> findProductsByCategoryId(int categoryId) {
        return productDao.findByCategoryId(categoryId);
    }

    public List<Product> findAllProducts() {
        return productDao.findAll();
    }
}
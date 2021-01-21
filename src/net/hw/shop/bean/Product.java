package net.hw.shop.bean;

/**
 * 功能：商品实体类

 */
import java.util.Date;


public class Product {
    /**
     * 商品标识符
     */
    private int id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品单价
     */
    private double price;
    /**
     * 商品上架时间
     */
    private Date addTime;
    /**
     * 商品所属类别标识符
     */
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", addTime=" + addTime +
                ", categoryId=" + categoryId +
                '}';
    }
}
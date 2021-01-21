package net.hw.shop.bean;

/**
 * 功能：订单实体类

 */
import java.util.Date;

public class Order {
    /**
     * 订单标识符
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 订单总金额
     */
    private double totalPrice;
    /**
     * 送货地址
     */
    private String deliveryAddress;
    /**
     * 下单时间
     */
    private Date orderTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", totalPrice=" + totalPrice +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", orderTime=" + orderTime +
                '}';
    }
}
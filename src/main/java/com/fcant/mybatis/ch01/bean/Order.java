package com.fcant.mybatis.ch01.bean;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.order_id
     *
     * @mbg.generated Wed Jul 24 20:33:03 GMT+08:00 2019
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.order_no
     *
     * @mbg.generated Wed Jul 24 20:33:03 GMT+08:00 2019
     */
    private String orderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.order_price
     *
     * @mbg.generated Wed Jul 24 20:33:03 GMT+08:00 2019
     */
    private Float orderPrice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.order_id
     *
     * @return the value of orders.order_id
     *
     * @mbg.generated Wed Jul 24 20:33:03 GMT+08:00 2019
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.order_id
     *
     * @param orderId the value for orders.order_id
     *
     * @mbg.generated Wed Jul 24 20:33:03 GMT+08:00 2019
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.order_no
     *
     * @return the value of orders.order_no
     *
     * @mbg.generated Wed Jul 24 20:33:03 GMT+08:00 2019
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.order_no
     *
     * @param orderNo the value for orders.order_no
     *
     * @mbg.generated Wed Jul 24 20:33:03 GMT+08:00 2019
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.order_price
     *
     * @return the value of orders.order_price
     *
     * @mbg.generated Wed Jul 24 20:33:03 GMT+08:00 2019
     */
    public Float getOrderPrice() {
        return orderPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.order_price
     *
     * @param orderPrice the value for orders.order_price
     *
     * @mbg.generated Wed Jul 24 20:33:03 GMT+08:00 2019
     */
    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }
}
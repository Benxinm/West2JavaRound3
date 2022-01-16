package com.benxinm.round3;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Order implements Record {
    @JSONField(name="订单编号")
    private  int orderId;
    @JSONField(name = "商品编号")
    private  int goodId;
    @JSONField(name = "订单时间")
    private  Date time;
    public Order(int orderId, int goodId, Date time) {
        this.orderId = orderId;
        this.goodId = goodId;
        this.time = time;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

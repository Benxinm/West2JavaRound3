package com.benxinm.round3;

import com.alibaba.fastjson.annotation.JSONField;

public class Good implements Record {
    @JSONField(name = "产品编号")
    private int id;
    @JSONField(name = "产品名称")
    private String name;
    @JSONField(name = "价格")
    private double price;

    public Good(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

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
}

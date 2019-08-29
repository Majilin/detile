package com.order.detile.domain;

import javax.persistence.Id;
import java.util.Date;

public class Sellerorders {
    @Id
    private Integer sorderid;

    private Integer orderid;

    private Integer status;

    private Date stime;

    private Date etime;

    private Integer shopid;


    private String address;

    public Integer getSorderid() {
        return sorderid;
    }

    public void setSorderid(Integer sorderid) {
        this.sorderid = sorderid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
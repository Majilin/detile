package com.order.detile.domain;

public class Address {
    private Integer id;

    private Integer userid;

    private String address;

    private Integer defaultid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDefaultid() {
        return defaultid;
    }

    public void setDefaultid(Integer defaultid) {
        this.defaultid = defaultid;
    }
}
package com.order.detile.domain;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class MyResponseEntity {
    private String message;
    private HttpStatus status;
    private List<Object> data=new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public MyResponseEntity(){}
    public MyResponseEntity(String message,HttpStatus status,Object ...obj){
        this.status=status;
        this.message=message;
        for (Object o:obj ) {
            data.add(o);
        }
    }
    public MyResponseEntity(String message,HttpStatus status){
        this.status=status;
        this.message=message;
    }
}

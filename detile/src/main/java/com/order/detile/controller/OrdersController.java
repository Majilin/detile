package com.order.detile.controller;

import com.order.detile.domain.*;
import com.order.detile.myproperties.GoodsProperties;
import com.order.detile.redisUtil.MyRedisUtil;
import com.order.detile.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class OrdersController {
    @Resource(name="sellerOrdersServiceImpl")
    SellerOrdersService sellerOrdersService;
    @Resource(name="ordersdetailServiceImpl")
    OrdersdetailService ordersdetailService;
    @Resource(name="ordersServiceImpl")
    OrdersService ordersService;
    @Resource(name="goodsProperties")
    GoodsProperties goodsProperties;
    @Resource(name="myRedisUtil")
    MyRedisUtil myRedisUtil;
    @Resource(name="addressServiceImpl")
    AddressService addressService;
    @Transactional
    @ResponseBody
    @RequestMapping(value="/addneworder",method = RequestMethod.POST)
    public MyResponseEntity addNewOrders(HttpServletRequest request){
        Ordersdetail ordersDetail=new Ordersdetail();
        ordersDetail.setGoodsid(1);
        ordersDetail.setQuantity(3);
        ordersDetail.setShopid(1);
        HttpSession session =request.getSession();
        User user1=new User();
        user1.setId(1);
        session.setAttribute("User",user1);
        //获取当前登录的User对象
        User user=(User)session.getAttribute("User");
        //查询用户的默认地址，有则返回，没有则返回最后一个地址，为空返回null
        Address defaultAddress=null;
        defaultAddress=addressService.selectDefaultAddress(user.getId());
        System.out.println(defaultAddress);
        if(defaultAddress==null){
            return new MyResponseEntity("noAddress",HttpStatus.OK);
        }
        //设置订单信息
        Orders orders=new Orders();
        //设置用户id
        orders.setUid(user.getId());
        //生成并设置订单id
        orders.setOrderid(generateOrderId());
        //设置订单创建时间
        orders.setStime(new Date());
        //设置订单初始状态为0代表待付款
        orders.setStatus(0);
        //设置用户的配送地址，初始值为用户的默认地址
        orders.setAddressid(defaultAddress.getId());
        //设置订单明细对应的订单编号
        ordersDetail.setOrderid(orders.getOrderid());
        //拆单到商家订单中
        Sellerorders sellerorders=new Sellerorders();
        sellerorders.setOrderid(orders.getOrderid());
        sellerorders.setStime(orders.getStime());
        sellerorders.setShopid(ordersDetail.getShopid());
        sellerorders.setStatus(orders.getStatus());
        sellerorders.setAddress(defaultAddress.getAddress());
        //将订单保存在mysql中
        int result=ordersService.insertNewOrder(orders);
        if(result>0){
            //将订单明细保存在mysql中
            result=ordersdetailService.insertNewOrdersDetail(ordersDetail);
            if(result>0){
                //将商家订单保存在mysql中
                result=sellerOrdersService.insertNewSellerOrders(sellerorders);
                if(result>0){
                    //将订单保存在redis缓存中，并设置过期时间为两个小时
                    myRedisUtil.set("orders:"+orders.getOrderid(),orders.getOrderid(),15);
                    myRedisUtil.put("orderset","orders:"+orders.getOrderid());
                }else{
                    return new MyResponseEntity("insertSellerOrderException",HttpStatus.OK);
                }
            }else{
                return new MyResponseEntity("insertOrderDetailException",HttpStatus.OK);
            }
        }else{
            return new MyResponseEntity("insertOrderException",HttpStatus.OK);
        }
        return new MyResponseEntity("success",HttpStatus.OK);
    }

    private static int generateOrderId(){
        int result=(int)(Math.random()*1000+9000);
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("ssSSS");
        result=Integer.parseInt(sdf.format(d)+result);
        return result;
    }
    @RequestMapping(value = "/test")
    public void test(){
        System.out.println("0000");
        System.out.println(myRedisUtil.set("orderid",1,10));
        myRedisUtil.set("o",1,20);
    }
}

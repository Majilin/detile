package com.order.detile.quartz;

import com.order.detile.redisUtil.MyRedisUtil;
import com.order.detile.service.OrdersService;
import com.order.detile.service.SellerOrdersService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.Set;

public class OrderJob extends QuartzJobBean {
    @Resource(name="myRedisUtil")
    MyRedisUtil myRedisUtil;
    @Resource(name="ordersServiceImpl")
    OrdersService ordersService;
    @Resource(name="sellerOrdersServiceImpl")
    SellerOrdersService sellerOrdersService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Set<Object> set=myRedisUtil.getSetAll("orderset");
        for (Object s:set) {
            Object obj=myRedisUtil.get(s.toString());
            if(obj==null){
                myRedisUtil.setRemove("orderset",s);
                int orderid=Integer.parseInt(s.toString().substring(7));
                ordersService.updateOrderStatus(7,orderid);
                sellerOrdersService.updateSellerOrderStatus(7,orderid);
            }
        }
    }
}

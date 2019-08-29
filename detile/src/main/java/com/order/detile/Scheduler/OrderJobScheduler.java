package com.order.detile.Scheduler;

import com.order.detile.quartz.OrderJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderJobScheduler {
    @Bean
    public JobDetail orderJobDetail(){
        return JobBuilder.newJob(OrderJob.class).withIdentity("orderJobDetail").storeDurably().build();
    }
    @Bean
    public Trigger orderJobTrigger(){
        SimpleScheduleBuilder scheduleBuilder=SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        return TriggerBuilder.newTrigger().forJob(orderJobDetail()).withSchedule(scheduleBuilder).build();
    }
}

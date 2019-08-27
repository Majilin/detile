package com.order.detile.myproperties;

import com.order.detile.quartz.MySampleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleScheduler {
    @Bean
    public JobDetail sampleJobDetail() {
        //withIdentity定义 TriggerKey,也可以不设置，会⾃动⽣成⼀个独⼀⽆⼆的 TriggerKey ⽤来区分不同的 Trigger
        //usingJobData("name", "World定时器") 设置SampleJob属性对应的值
        return JobBuilder.newJob(MySampleJob.class).withIdentity("mysampleJob")
                .usingJobData("name", "World定时器").storeDurably().build();
    }
    @Bean
    public Trigger sampleJobTrigger() {
        //withIntervalInSeconds(10)每隔10秒钟执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
                .withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
    }

}



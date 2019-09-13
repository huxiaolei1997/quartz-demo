package com.xlh.quartz.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2019年09月13日 15:22 胡晓磊 Exp $
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 创建一个jobDetail 实例，将该实例与HelloJob 绑定
        JobDetail detail = JobBuilder.newJob(HelloJob.class)
                .usingJobData("message", "Hello myjob1")
                .usingJobData("FloatJobValue", 3.14F)
                .withIdentity("myJob","group1").build();

//        // 获取距离当前时间3秒后的时间
//        Date date = new Date();
//        date.setTime(date.getTime() + 3000);
//
//        Date endDate = new Date();
//        endDate.setTime(endDate.getTime() + 6000);

//        System.out.println("jobDetail's name : " + detail.getKey().getName());
//        System.out.println("jobDetail's group : " + detail.getKey().getGroup());
//        System.out.println("jobDetail's jobClass : " + detail.getJobClass().getName());
        // 创建一个Trigger实例，定义该job立即执行，并且每隔两秒钟重复执行一次，直到永远
        // 这里需要注意虽然trigger所属的group是group1，看起来和job所属的group名字是一样的，但是其实两个还是属于不同的组
//        SimpleTrigger trigger = TriggerBuilder
//                .newTrigger()
//                .usingJobData("message", "Hello myTrigger1")
//                .usingJobData("DoubleJobValue", 2.0D)
//                .withIdentity("myTrigger", "group1")
////                .startNow()
////                .startAt(date)
////                .endAt(endDate)
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
//                .build();

        // 距离当前4秒钟之后开始执行
//        Date date = new Date();
//        date.setTime(date.getTime() + 4000L);
//        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder
//                .newTrigger()
//                .withIdentity("myTrigger", "group1")
//                .startAt(date)
//                .build();

        // 距离当前4秒钟之后开始执行，之后每隔2秒钟执行3次任务，总共执行4次
//        Date date = new Date();
//        date.setTime(date.getTime() + 4000L);
//        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder
//                .newTrigger()
//                .withIdentity("myTrigger", "group1")
//                .startAt(date)
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(3))
//                .build();

        // 每秒钟触发一次任务
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myCronTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();

        // 创建scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 绑定jobdetail和trigger
        scheduler.scheduleJob(detail, trigger);

        scheduler.start();
        System.out.println("Current Exec time is :" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        // scheduler执行2秒后挂起
        Thread.sleep(2000L);
//        scheduler.standby();
        // 关闭定时任务，如果调用shutdown之后，再次调用start会抛出异常
        // shutdown(true) 表示等待所有正在执行的job执行完毕之后，再关闭scheduler
        // shutdown(false) 调用shutdown之后，直接关闭scheduler
//        scheduler.shutdown();
        scheduler.shutdown(true);

        // 挂起3秒后重新启动scheduler，之前没有执行完的定时任务都需要被执行
        Thread.sleep(3000L);
        scheduler.start();
        //
//        Thread.sleep(5000L);
//        scheduler.shutdown();

    }
}

package com.xlh.quartz.demo;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2019年09月13日 15:15 胡晓磊 Exp $
 */
public class HelloJob implements Job {
    private String message;

    private Float FloatJobValue;

    private Double DoubleJobValue;

    /**
     * Getter method for property <tt>message</tt>.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter method for property <tt>FloatJobValue</tt>.
     *
     * @return property value of FloatJobValue
     */
    public Float getFloatJobValue() {
        return FloatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        FloatJobValue = floatJobValue;
    }

    /**
     * Getter method for property <tt>DoubleJobValue</tt>.
     *
     * @return property value of DoubleJobValue
     */
    public Double getDoubleJobValue() {
        return DoubleJobValue;
    }

    public void setDoubleJobValue(Double doubleJobValue) {
        DoubleJobValue = doubleJobValue;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        // 打印当前的执行时间，格式为2017-01-01
        System.out.println("Current Exec time is :" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        // 编写具体的业务逻辑
        System.out.println("Hello World!");
//
//        Trigger currentTrigger = jobExecutionContext.getTrigger();
//        System.out.println("Start time is " + currentTrigger.getStartTime());
//        System.out.println("End time is " + currentTrigger.getEndTime());
//        System.out.println("job key is " + currentTrigger.getJobKey().getName());
//        System.out.println("job group is " + currentTrigger.getJobKey().getGroup());
//        JobKey key = jobExecutionContext.getJobDetail().getKey();
////        JobKey key = jobExecutionContext.getMergedJobDataMap(); // 获取trigger和jobDetail里的自定义信息，如果trigger和JobDetail里的属性名相同，trigger优先，也就是会获取trigger的值
//        System.out.println("My Job name and group are" + key.getName() + ", " + key.getGroup());
//        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
//        System.out.println("My Trigger name and group are" + triggerKey.getName() + ", " + triggerKey.getGroup());
//        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
//        JobDataMap triggerDataMap = jobExecutionContext.getTrigger().getJobDataMap();
//
//        String jobMsg = jobDataMap.getString("message");
//        Float jobFloatValue = jobDataMap.getFloat("FloatJobValue");
//
//        System.out.println("通过getter和setter方法获取jobDataMap里的值" + message + ", " + FloatJobValue + ", " + DoubleJobValue);
//
//        String triggerMsg = triggerDataMap.getString("message");
//        Double triggerDoubleValue = triggerDataMap.getDouble("DoubleJobValue");
//        System.out.println("jobMsg is " + jobMsg + " jobFloatValue is " + jobFloatValue + ", triggerMsg is " + triggerMsg + " triggerDoubleValue is" + triggerDoubleValue);
    }
}

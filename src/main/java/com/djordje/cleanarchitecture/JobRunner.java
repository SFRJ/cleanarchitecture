package com.djordje.cleanarchitecture;

import com.djordje.cleanarchitecture.configuration.HelloWorld;
import com.djordje.cleanarchitecture.entrypoints.WhatsTheTimeManager;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JobRunner {

    public static void main(String[] args) throws SchedulerException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-config.xml");

        //TODO Find out how to use JobDetail with Spring

        JobDetail whatsTheTime = newJob(WhatsTheTimeManager.class).withIdentity("whatsTheTime", "jobsGroup1").build();

        Trigger trigger = newTrigger()
                .withIdentity("whatsTheTimeJobTrigger", "jobsGroup1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        scheduler.scheduleJob(whatsTheTime, trigger);
    }

}

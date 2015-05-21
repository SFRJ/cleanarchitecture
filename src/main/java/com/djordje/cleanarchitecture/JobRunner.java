package com.djordje.cleanarchitecture;

import com.djordje.cleanarchitecture.entrypoints.WhatsTheTimeManager;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JobRunner {

    public static void main(String[] args) throws SchedulerException {
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

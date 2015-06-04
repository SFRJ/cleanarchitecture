package com.djordje.cleanarchitecture;

import com.djordje.cleanarchitecture.configuration.WhatsTheTimeConfiguration;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JobRunner {

    public static void main(String[] args) throws SchedulerException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(WhatsTheTimeConfiguration.class);
        AutowiringSpringBeanJobFactory autowiringSpringBeanJobFactory = new AutowiringSpringBeanJobFactory();
        autowiringSpringBeanJobFactory.setApplicationContext(applicationContext);

        SpringBeanJobFactory springBeanJobFactory = new SpringBeanJobFactory();

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(trigger());
        schedulerFactoryBean.setJobFactory(springBeanJobFactory);
        schedulerFactoryBean.start();
    }

    private static SimpleTrigger trigger() {
        return newTrigger()
                .withIdentity("whatsTheTimeJobTrigger", "jobsGroup1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();
    }

}

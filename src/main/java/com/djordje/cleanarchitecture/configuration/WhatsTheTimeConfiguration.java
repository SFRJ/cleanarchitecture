package com.djordje.cleanarchitecture.configuration;

import com.djordje.cleanarchitecture.AutowiringSpringBeanJobFactory;
import com.djordje.cleanarchitecture.entrypoints.WhatsTheTimeManager;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Configuration
@ComponentScan(basePackages = "com.djordje.cleanarchitecture")
public class WhatsTheTimeConfiguration {
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(trigger());
        schedulerFactoryBean.setJobDetails(jobDetail());
        schedulerFactoryBean.setJobFactory(springBeanJobFactory());
        return schedulerFactoryBean;
    }

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        return new AutowiringSpringBeanJobFactory();
    }

    @Bean
    public JobDetail jobDetail() {
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setKey(new JobKey("WhatsTheTime"));
        jobDetail.setJobClass(WhatsTheTimeManager.class);
        jobDetail.setDurability(true);
        return jobDetail;
    }

    @Bean
    public SimpleTrigger trigger() {
        return newTrigger()
                .forJob(jobDetail())
                .withIdentity("whatsTheTimeJobTrigger", "jobsGroup1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();
    }
}

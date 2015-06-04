package com.djordje.cleanarchitecture.entrypoints;

import com.djordje.cleanarchitecture.core.dataprovider.LocationRetriever;
import com.djordje.cleanarchitecture.core.usecase.WhatsTheTime;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class WhatsTheTimeManager extends QuartzJobBean {

    @Autowired
    private WhatsTheTime usecase;
    @Autowired
    private LocationRetriever locationDataProvider;

    public WhatsTheTimeManager() {
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        usecase.tellMeWhatsTheTimeIn(locationDataProvider.allLocations());
    }

    public void setUsecase(WhatsTheTime usecase) {
        this.usecase = usecase;
    }

    public void setLocationDataProvider(LocationRetriever locationDataProvider) {
        this.locationDataProvider = locationDataProvider;
    }
}

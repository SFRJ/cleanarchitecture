package com.djordje.cleanarchitecture.entrypoints;

import com.djordje.cleanarchitecture.core.dataprovider.LocationRetriever;
import com.djordje.cleanarchitecture.core.usecase.WhatsTheTime;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class WhatsTheTimeManager implements Job {

    private WhatsTheTime usecase;
    private LocationRetriever locationDataProvider;

    public WhatsTheTimeManager() {
    }

    public WhatsTheTimeManager(WhatsTheTime usecase, LocationRetriever locationDataProvider) {
        this.usecase = usecase;
        this.locationDataProvider = locationDataProvider;
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        usecase.tellMeWhatsTheTimeIn(locationDataProvider.allLocations());
    }
}

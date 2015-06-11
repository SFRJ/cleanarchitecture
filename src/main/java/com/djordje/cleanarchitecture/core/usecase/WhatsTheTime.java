package com.djordje.cleanarchitecture.core.usecase;

import com.djordje.cleanarchitecture.core.dataprovider.TimeOutputRenderer;
import com.djordje.cleanarchitecture.core.dataprovider.TimeRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
    There are 2 ways of enabling Constructor Injection in Spring.
    -You can Annotate the class with @Component and its constructor with @Autowire
    -You can create a Configuration class marked with the @Configuration annotation (e.g See WhatsTheTimeConfiguration) and create methods that
    initialise the beans that you want to inject.
*/
@Component
public class WhatsTheTime {

    private TimeRetriever timeRetriever;
    private TimeOutputRenderer timeOutputRenderer;

    @Autowired
    public WhatsTheTime(TimeRetriever timeRetriever, TimeOutputRenderer timeOutputRenderer) {
        this.timeRetriever = timeRetriever;
        this.timeOutputRenderer = timeOutputRenderer;
    }

    public void tellMeWhatsTheTimeIn(List<String> locations) {
        for(String location : locations) {
            String time = timeRetriever.timeFor(location);
            timeOutputRenderer.renderReport(location, time);
        };
    }
}

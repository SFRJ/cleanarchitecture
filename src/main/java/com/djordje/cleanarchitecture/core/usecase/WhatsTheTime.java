package com.djordje.cleanarchitecture.core.usecase;

import com.djordje.cleanarchitecture.core.dataprovider.TimeOutputRenderer;
import com.djordje.cleanarchitecture.core.dataprovider.TimeRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


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
        locations.stream().map((location) -> {
            String time = timeRetriever.timeFor(location);
            return timeOutputRenderer.renderReport(location, time);
        });
    }
}

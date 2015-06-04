package com.djordje.cleanarchitecture.dataproviders;

import com.djordje.cleanarchitecture.core.dataprovider.TimeRetriever;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
public class TimeRetrieverDataProvider implements TimeRetriever {

    public TimeRetrieverDataProvider() {
    }

    @Override
    public String timeFor(String location) {
        SimpleDateFormat timeInLocation = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
        timeInLocation.setTimeZone(TimeZone.getTimeZone(location));
        return timeInLocation.format(new Date());
    }
}

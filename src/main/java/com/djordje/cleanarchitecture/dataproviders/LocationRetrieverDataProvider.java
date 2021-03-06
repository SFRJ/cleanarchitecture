package com.djordje.cleanarchitecture.dataproviders;

import com.djordje.cleanarchitecture.core.dataprovider.LocationRetriever;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class LocationRetrieverDataProvider implements LocationRetriever{

    public LocationRetrieverDataProvider() {
    }

    @Override
    public List<String> allLocations() {
        return asList("Europe/London", "Europe/Madrid", "Europe/Moscow", "Asia/Tokyo", "Australia/Melbourne", "America/New_York");
    }
}

package com.djordje.cleanarchitecture.dataproviders;

import com.djordje.cleanarchitecture.core.dataprovider.LocationRetriever;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.Arrays.asList;

public class LocationRetrieverDataProvider implements LocationRetriever{

    @Autowired
    public LocationRetrieverDataProvider() {
    }

    @Override
    public List<String> allLocations() {
        return asList("Europe/London", "Europe/Madrid", "Europe/Moscow", "Asia/Tokyo", "Australia/Melbourne", "America/New_York");
    }
}

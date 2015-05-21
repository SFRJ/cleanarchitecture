package com.djordje.cleanarchitecture.dataproviders;

import com.djordje.cleanarchitecture.core.dataprovider.TimeOutputRenderer;
import com.djordje.cleanarchitecture.core.domain.TimeReport;
import org.springframework.beans.factory.annotation.Autowired;

public class TimeOutputRendererDataProvider implements TimeOutputRenderer {

    public TimeOutputRendererDataProvider() {
    }

    @Override
    public TimeReport renderReport(String location, String time) {
        System.out.println(location + " time is " + time);
        return new TimeReport(location, time);
    }
}

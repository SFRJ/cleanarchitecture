package com.djordje.cleanarchitecture.core.dataprovider;

import com.djordje.cleanarchitecture.core.entities.TimeReport;

public interface TimeOutputRenderer {
    TimeReport renderReport(String timeInLocation, String location);
}

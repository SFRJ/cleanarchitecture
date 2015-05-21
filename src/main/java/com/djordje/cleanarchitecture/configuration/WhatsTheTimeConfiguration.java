package com.djordje.cleanarchitecture.configuration;

import com.djordje.cleanarchitecture.core.dataprovider.LocationRetriever;
import com.djordje.cleanarchitecture.core.usecase.WhatsTheTime;
import com.djordje.cleanarchitecture.entrypoints.WhatsTheTimeManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WhatsTheTimeConfiguration {

    @Bean
    public WhatsTheTimeManager whatsTheTimeManager(WhatsTheTime whatsTheTimeUseCase, LocationRetriever locationDataProvider) {
        return new WhatsTheTimeManager(whatsTheTimeUseCase, locationDataProvider);
    }
}

package com.djordje.cleanarchitecture.configuration;

import com.djordje.cleanarchitecture.core.dataprovider.LocationRetriever;
import com.djordje.cleanarchitecture.core.dataprovider.TimeOutputRenderer;
import com.djordje.cleanarchitecture.core.usecase.WhatsTheTime;
import com.djordje.cleanarchitecture.dataproviders.LocationRetrieverDataProvider;
import com.djordje.cleanarchitecture.dataproviders.TimeOutputRendererDataProvider;
import com.djordje.cleanarchitecture.dataproviders.TimeRetrieverDataProvider;
import com.djordje.cleanarchitecture.entrypoints.WhatsTheTimeManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WhatsTheTimeConfiguration {

    @Bean
    public LocationRetrieverDataProvider locationRetrieverDataProvider() {
        return new LocationRetrieverDataProvider();
    }

    @Bean
    public TimeRetrieverDataProvider timeRetrieverDataProvider() {
        return new TimeRetrieverDataProvider();
    }

    @Bean
    public TimeOutputRenderer timeOutputRenderer() {
        return new TimeOutputRendererDataProvider();
    }

    @Bean
    public WhatsTheTimeManager whatsTheTimeManager(WhatsTheTime whatsTheTimeUseCase, LocationRetriever locationDataProvider) {
        return new WhatsTheTimeManager(whatsTheTimeUseCase, locationDataProvider);
    }
}

package com.djordje.cleanarchitecture.configuration;

import com.djordje.cleanarchitecture.core.dataprovider.LocationRetriever;
import com.djordje.cleanarchitecture.core.dataprovider.TimeOutputRenderer;
import com.djordje.cleanarchitecture.core.dataprovider.TimeRetriever;
import com.djordje.cleanarchitecture.core.usecase.WhatsTheTime;
import com.djordje.cleanarchitecture.dataproviders.LocationRetrieverDataProvider;
import com.djordje.cleanarchitecture.dataproviders.TimeOutputRendererDataProvider;
import com.djordje.cleanarchitecture.dataproviders.TimeRetrieverDataProvider;
import com.djordje.cleanarchitecture.entrypoints.WhatsTheTimeManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WhatsTheTimeConfiguration {
//A configuration class, is a common way of injecting the beans in String.
//Any constructor in the application will have automatically have injected any of this dependencies

    @Bean
    public LocationRetriever locationRetrieverDataProvider() {
        return new LocationRetrieverDataProvider();
    }

    @Bean
    public TimeRetriever timeRetrieverDataProvider() {
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

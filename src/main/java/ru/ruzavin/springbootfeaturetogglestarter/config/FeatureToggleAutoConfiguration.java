package ru.ruzavin.springbootfeaturetogglestarter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ruzavin.springbootfeaturetogglestarter.client.FeatureToggleClient;
import ru.ruzavin.springbootfeaturetogglestarter.service.FeatureToggleService;
import ru.ruzavin.springbootfeaturetogglestarter.service.FeatureToggleServiceImpl;

@EnableFeignClients
@Configuration
@ConditionalOnProperty(name = "feature-toggle.enabled", havingValue = "true")
public class FeatureToggleAutoConfiguration {


    @Bean
    public FeatureToggleService featureToggleService(
            FeatureToggleClient featureToggleClient
    ) {
        return new FeatureToggleServiceImpl(featureToggleClient);
    }

}

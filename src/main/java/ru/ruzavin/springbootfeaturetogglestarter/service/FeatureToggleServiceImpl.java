package ru.ruzavin.springbootfeaturetogglestarter.service;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ruzavin.springbootfeaturetogglestarter.client.FeatureToggleClient;
import ru.ruzavin.springbootfeaturetogglestarter.dto.FeatureToggleModel;

@Service
@RequiredArgsConstructor
public class FeatureToggleServiceImpl implements FeatureToggleService {

    private final FeatureToggleClient featureToggleClient;

    @Override
    public Boolean getFeatureState(String name) {
        FeatureToggleModel featureToggle;
        try {
            featureToggle = featureToggleClient.getFeatureToggle(name);
        } catch (FeignException.NotFound e) {
            throw new IllegalArgumentException("State of feature with name ".concat(name).concat(" not found"));
        } catch (FeignException e) {
            throw new IllegalArgumentException("Something went wrong");
        }

        return featureToggle != null ? featureToggle.active() : false;
    }

}

package ru.ruzavin.springbootfeaturetogglestarter.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ruzavin.springbootfeaturetogglestarter.dto.FeatureToggleModel;

@FeignClient(name = "FeatureToggleClient", url = "${feign.url}", path = "/data")
public interface FeatureToggleClient {

    @GetMapping("/name/{name}")
    FeatureToggleModel getFeatureToggle(@PathVariable String name);

}

package ru.ruzavin.springbootfeaturetogglestarter.dto;

import java.util.UUID;

public record FeatureToggleModel(
        UUID id,
        String name,
        Boolean active
) {
}

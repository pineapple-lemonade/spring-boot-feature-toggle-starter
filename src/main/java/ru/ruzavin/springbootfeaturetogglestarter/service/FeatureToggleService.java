package ru.ruzavin.springbootfeaturetogglestarter.service;

public interface FeatureToggleService {

    Boolean getFeatureState(String name);
}

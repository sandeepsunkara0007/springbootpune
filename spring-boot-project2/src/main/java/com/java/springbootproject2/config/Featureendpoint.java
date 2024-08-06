package com.java.springbootproject2.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features") // Specify the ID for the endpoint
public class Featureendpoint {
    private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

    public Featureendpoint() {
        featureMap.put("Department", new Feature(true));
        featureMap.put("user", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> features() {
        return featureMap;
    }

    public Feature feature(@Selector String featurename) {
        return featureMap.get(featurename);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}

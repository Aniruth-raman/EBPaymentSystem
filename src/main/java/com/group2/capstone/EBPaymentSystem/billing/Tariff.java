package com.group2.capstone.EBPaymentSystem.billing;

import com.group2.capstone.EBPaymentSystem.profile.PropertyType;

import java.util.HashMap;
import java.util.Map;

public class Tariff {
    Tariff tariff = new Tariff.Builder().withLowRate(PropertyType.RESIDENTIAL, 0.1).withMediumRate(PropertyType.RESIDENTIAL, 0.2).withHighRate(PropertyType.RESIDENTIAL, 0.3).withLowRate(PropertyType.COMMERCIAL, 0.4).withMediumRate(PropertyType.COMMERCIAL, 0.5).withHighRate(PropertyType.COMMERCIAL, 0.6).withLowRate(PropertyType.GOVERNMENT, 0.7).withMediumRate(PropertyType.GOVERNMENT, 0.8).withHighRate(PropertyType.GOVERNMENT, 0.9).build();
    private final Map<PropertyType, Double> lowRates;
    private final Map<PropertyType, Double> mediumRates;
    private final Map<PropertyType, Double> highRates;

    private Tariff(Builder builder) {
        this.lowRates = builder.lowRates;
        this.mediumRates = builder.mediumRates;
        this.highRates = builder.highRates;
    }

    public double getRateForUsage(PropertyType propertyType, double usage) {
        if (usage <= 100) {
            return lowRates.getOrDefault(propertyType, 0.0);
        } else if (usage <= 200) {
            return mediumRates.getOrDefault(propertyType, 0.0);
        } else {
            return highRates.getOrDefault(propertyType, 0.0);
        }
    }

    public static class Builder {
        private final Map<PropertyType, Double> lowRates;
        private final Map<PropertyType, Double> mediumRates;
        private final Map<PropertyType, Double> highRates;

        public Builder() {
            lowRates = new HashMap<>();
            mediumRates = new HashMap<>();
            highRates = new HashMap<>();
        }

        public Builder withLowRate(PropertyType propertyType, double rate) {
            lowRates.put(propertyType, rate);
            return this;
        }

        public Builder withMediumRate(PropertyType propertyType, double rate) {
            mediumRates.put(propertyType, rate);
            return this;
        }

        public Builder withHighRate(PropertyType propertyType, double rate) {
            highRates.put(propertyType, rate);
            return this;
        }

        public Tariff build() {
            return new Tariff(this);
        }
    }
}


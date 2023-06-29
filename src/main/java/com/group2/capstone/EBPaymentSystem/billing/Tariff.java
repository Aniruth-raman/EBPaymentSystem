package com.group2.capstone.EBPaymentSystem.billing;

import com.group2.capstone.EBPaymentSystem.profile.PropertyType;

public class Tariff {
    public double getRateForUsage(PropertyType propertyType, double usage) {
        if (usage <= 100) {
            return propertyType.getLowRate();
        } else if (usage <= 200) {
            return propertyType.getMediumRate();
        } else {
            return propertyType.getHighRate();
        }
    }
}


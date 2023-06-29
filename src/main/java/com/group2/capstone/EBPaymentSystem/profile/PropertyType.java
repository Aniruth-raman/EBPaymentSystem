package com.group2.capstone.EBPaymentSystem.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyType {
    String propertyName;
    double lowRate;
    double mediumRate;
    double highRate;
}

package com.group2.capstone.EBPaymentSystem.profile;

import com.group2.capstone.EBPaymentSystem.billing.Bill;
import lombok.Data;

@Data
public class Property {
    Meter meter;
    PropertyType propertyType;
    Bill bill;

    public Property(Meter meter, PropertyType propertyType, Bill bill) {
        this.meter = meter;
        this.propertyType = propertyType;
        this.bill = bill;
    }
}

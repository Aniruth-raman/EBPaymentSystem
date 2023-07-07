package com.group2.capstone.EBPaymentSystem.billing;

import com.group2.capstone.EBPaymentSystem.models.Bill;
import com.group2.capstone.EBPaymentSystem.models.Property;
import com.group2.capstone.EBPaymentSystem.models.User;

import java.util.Calendar;
import java.util.List;

public class CalculateBill {
    public static final int BASE_AMOUNT = 150;
    Tariff tariff;

//    public void calculateBill(User user) {
//        List<Property> properties = user.getProfile().getProperties();
//        for (Property property : properties) {
//            Calendar cal = Calendar.getInstance();
//            int year = cal.get(Calendar.YEAR);
//            int month = cal.get(Calendar.MONTH) + 1;
//            double totalUsage = property.getMeter().getMonthUsage(year, month);
//            double billAmount = BASE_AMOUNT + (tariff.getRateForUsage(property.getPropertyType(), totalUsage) * totalUsage);
//            cal.add(Calendar.DATE, 15);
//            property.setBill(new Bill(billAmount, cal.getTime() ));
//        }
//    }
}

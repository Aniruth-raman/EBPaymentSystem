package com.group2.capstone.EBPaymentSystem.billing;

import com.group2.capstone.EBPaymentSystem.billing.models.Bill;
import com.group2.capstone.EBPaymentSystem.billing.models.Property;
import com.group2.capstone.EBPaymentSystem.billing.models.User;

import java.util.List;

public class PDFBillGenerator implements BillGenerator {
    @Override
    public Bill generateBill(User user) {
        List<Property> properties = user.getProfile().getProperties();
        for (Property property : properties) {
//            property.getBill();

        }
        return null;
    }
}

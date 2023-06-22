package com.group2.capstone.EBPaymentSystem.billing;

import com.group2.capstone.EBPaymentSystem.profile.Property;
import com.group2.capstone.EBPaymentSystem.profile.User;

import java.util.List;

public class PDFBillGenerator implements BillGenerator {
    @Override
    public Bill generateBill(User user) {
        List<Property> properties = user.getProfile().getProperties();
        for (Property property : properties) {
            property.getBill();
            //The bill generated is stored as a PDF
        }
        return null;
    }
}

package com.group2.capstone.EBPaymentSystem.billing;

import com.group2.capstone.EBPaymentSystem.models.Bill;
import com.group2.capstone.EBPaymentSystem.models.Property;
import com.group2.capstone.EBPaymentSystem.models.User;

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

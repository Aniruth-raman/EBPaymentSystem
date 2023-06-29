package com.group2.capstone.EBPaymentSystem.billing;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BillStatus {

    private final Map<Integer, String> status = new HashMap<>();
    private final AtomicInteger key = new AtomicInteger(0);

    public void addStatus(String newStatus) {
        this.status.put(key.getAndIncrement(), newStatus);
    }

    public Map<Integer, String> getStatus() {
        return status;
    }

    public String getStatus(Integer key) {
        return status.get(key);
    }


}

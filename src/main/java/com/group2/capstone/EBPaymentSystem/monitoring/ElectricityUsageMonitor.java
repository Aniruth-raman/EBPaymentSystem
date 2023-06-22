package com.group2.capstone.EBPaymentSystem.monitoring;

import java.util.List;

public interface ElectricityUsageMonitor {
    public double getCurrentUsage();
    public List<Double> getHistoricalUsage();
}


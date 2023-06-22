package com.group2.capstone.EBPaymentSystem.profile;

import java.util.Set;

public enum Role {
    ADMIN(Set.of(Permission.CREATE_DISTRICT_OFFICER, Permission.VIEW_ALL_USERS)),
    DISTRICT_OFFICER(Set.of(Permission.CREATE_CONSUMER)),
    CONSUMER(Set.of(Permission.VIEW_PROFILE, Permission.UPDATE_PROFILE, Permission.MONITOR_USAGE, Permission.VIEW_BILL, Permission.PAY_BILL));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }
}


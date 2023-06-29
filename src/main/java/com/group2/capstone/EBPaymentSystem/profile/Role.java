package com.group2.capstone.EBPaymentSystem.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Role {
    String name;
    List<Permission> permissions;

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }
}

package com.dxclogin.dxclogin.model;

public enum ClearanceRoles {
    ADMIN("Admin"),
    USER("User"),
    ;

    private final String displayName;
    ClearanceRoles(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}

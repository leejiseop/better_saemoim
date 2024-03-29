package com.example.bettersaemoim.domain.enums;

public enum UserRoleEnum {
    USER(Authority.USER), REPORT(Authority.REPORT), ADMIN(Authority.ADMIN), ROOT(Authority.ROOT);

    private final String authority;

    UserRoleEnum(String role) {
        this.authority = role;
    }

    public String getAuthority() {
        return authority;
    }

    public static class Authority {
        public static final String USER = "ROLE_USER";
        public static final String REPORT = "ROLE_REPORT";
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String ROOT = "ROLE_ROOT";
    }
}

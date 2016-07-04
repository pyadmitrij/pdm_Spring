package home.pdm.model;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER"),
    DBA("DBA");

    private String userRole;

    private UserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }
}

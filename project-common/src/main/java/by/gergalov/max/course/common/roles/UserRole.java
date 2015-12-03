package by.gergalov.max.course.common.roles;

public enum UserRole {
    ROLE_ANONYMOUS, ROLE_ADMIN, ROLE_USER;

    public UserRole getDefaultRole() {
        return UserRole.ROLE_USER;
    }

}

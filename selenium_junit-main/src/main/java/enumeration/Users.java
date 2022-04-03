package enumeration;

public enum Users {
    AMAZON_USER("zoran.v.zivanovic@gmail.com","", "Regular user for amazon site"),
    SWAG_STANDAR_USER("standard_user", "secret_sauce", "Standard user for swag labs"),
    SWAG_LOCKED_USER("locked_out_user", "secret_sauce", "User which will not be able to login");

    private final String userName;
    private final String password;
    private final String description;

    Users(String userName, String password, String description) {
        this.userName = userName;
        this.password = password;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }
}

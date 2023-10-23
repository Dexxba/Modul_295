package ch.csbe.modul_295.login;

import jakarta.validation.constraints.NotBlank;

/**
 * This class represents a Data Transfer Object (DTO) for user login information.
 * It is used to transfer username and password information between different parts of the application.
 */
public class LoginDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    /**
     * Constructs a new LoginDto object with the given username and password.
     *
     * @param username The username for login.
     * @param password The password for login.
     */
    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieves the username from the LoginDto.
     *
     * @return The username as a String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username in the LoginDto.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the password from the LoginDto.
     *
     * @return The password as a String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password in the LoginDto.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

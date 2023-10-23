package ch.csbe.modul_295.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

/**
 * UserDto represents a data transfer object for user-related information.
 */
public class UserDto {
    @NotBlank
    private String firstName; // User's first name

    @NotBlank
    private String lastName; // User's last name

    private String username; // User's username

    private String email; // User's email

    private String profilePicture; // User's profile picture URL

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password; // User's password (only visible for writing)

    private String address; // User's address

    private boolean active; // Indicates if the user is active

    private boolean admin; // Indicates if the user is an admin

    /**
     * Get the user's first name.
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the user's first name.
     * @param firstName The user's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the user's last name.
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the user's last name.
     * @param lastName The user's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the user's username.
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the user's username.
     * @param username The user's username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the user's email.
     * @return The user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email.
     * @param email The user's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the user's profile picture URL.
     * @return The user's profile picture URL.
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     * Set the user's profile picture URL.
     * @param profilePicture The user's profile picture URL.
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * Get the user's password.
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password.
     * @param password The user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the user's address.
     * @return The user's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the user's address.
     * @param address The user's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Check if the user is active.
     * @return True if the user is active, false otherwise.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Set the user's active status.
     * @param active True if the user is active, false otherwise.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Check if the user is an admin.
     * @return True if the user is an admin, false otherwise.
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Set the user's admin status.
     * @param admin True if the user is an admin, false otherwise.
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Generate a string representation of the UserDto.
     * @return A string representation of the UserDto object.
     */
    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", active=" + active +
                ", isAdmin=" + admin +
                '}';
    }
}

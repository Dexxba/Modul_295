package ch.csbe.modul_295.users;

import jakarta.persistence.*;

/**
 * This class represents a User entity with its properties and corresponding JPA annotations.
 */
@Entity
public class Users {

    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * User's username.
     */
    @Column(columnDefinition = "Varchar(50)", nullable = false)
    private String username;

    /**
     * User's password.
     */
    @Column(columnDefinition = "Varchar(70)", nullable = false)
    private String password;

    /**
     * User's first name.
     */
    @Column(columnDefinition = "Varchar(50)", nullable = false)
    private String firstName;

    /**
     * User's last name.
     */
    @Column(columnDefinition = "Varchar(50)", nullable = false)
    private String lastName;

    /**
     * URL to the user's profile picture.
     */
    @Column(columnDefinition = "Varchar(1000)", nullable = false)
    private String profilePicture;

    /**
     * User's email address.
     */
    @Column(columnDefinition = "Varchar(80)", nullable = false)
    private String email;

    /**
     * User's address.
     */
    @Column(columnDefinition = "Varchar(50)", nullable = false)
    private String address;

    /**
     * Whether the user's account is active or not (Boolean value).
     */
    @Column(columnDefinition = "tinyint", nullable = false)
    private Boolean active = false;

    /**
     * Whether the user is an administrator (true/false).
     */
    @Column(columnDefinition = "tinyint", nullable = false)
    private boolean isAdmin;

    /**
     * Get the user's unique identifier.
     *
     * @return The user's unique identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the user's unique identifier.
     *
     * @param id The user's unique identifier.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the user's username.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the user's username.
     *
     * @param username The user's username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the user's password.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password.
     *
     * @param password The user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the user's first name.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the user's first name.
     *
     * @param firstName The user's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the user's last name.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the user's last name.
     *
     * @param lastName The user's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the URL to the user's profile picture.
     *
     * @return The URL to the user's profile picture.
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     * Set the URL to the user's profile picture.
     *
     * @param profilePicture The URL to the user's profile picture.
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * Get the user's email address.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email address.
     *
     * @param email The user's email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the user's address.
     *
     * @return The user's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the user's address.
     *
     * @param address The user's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Check if the user's account is active.
     *
     * @return True if the user's account is active, false otherwise.
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Set whether the user's account is active or not.
     *
     * @param active True if the user's account is active, false otherwise.
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Check if the user is an administrator.
     *
     * @return True if the user is an administrator, false otherwise.
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Set whether the user is an administrator.
     *
     * @param admin True if the user is an administrator, false otherwise.
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

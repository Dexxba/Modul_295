package ch.csbe.modul_295.users;

import jakarta.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "Varchar(50)", nullable = false)
    private String username;

    @Column(columnDefinition = "Varchar(70)", nullable = false)
    private String password;

    @Column(columnDefinition = "Varchar(50)" ,nullable = false)
    private String firstName;

    @Column(columnDefinition = "Varchar(50)", nullable = false)
    private String lastName;

    @Column(columnDefinition = "Varchar(1000)",nullable = false)
    private String profilePicture;

    @Column(columnDefinition = "Varchar(80)", nullable = false)
    private String email;

    @Column(columnDefinition ="Varchar(50)", nullable = false)
    private String address;

    @Column(columnDefinition = "tinyint", nullable = false)
    private Boolean active = false;

    @Column(columnDefinition = "tinyint", nullable = false)
    private boolean isAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

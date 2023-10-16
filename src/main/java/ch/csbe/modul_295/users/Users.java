package ch.csbe.modul_295.users;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "Varchar(50)", nullable = false)
    private String Username;

    @Column(columnDefinition = "Varchar(20)", nullable = false)
    private String Password;

    @Column(columnDefinition = "Varchar(50)" ,nullable = false)
    private String FirstName;

    @Column(columnDefinition = "Varchar(50)", nullable = false)
    private String LastName;

    @Column(columnDefinition = "Varchar(1000)",nullable = false)
    private String ProfilePicture;

    @Column(columnDefinition = "Varchar(80)", nullable = false)
    private String Email;

    @Column(columnDefinition ="Varchar(50)", nullable = false)
    private String Address;

    @Column(columnDefinition = "tinyint", nullable = false)
    private Boolean active = false;

    @Column(columnDefinition = "Varchar(50)", nullable = false)
    private String Role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getProfilePicture() {
        return ProfilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        ProfilePicture = profilePicture;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}

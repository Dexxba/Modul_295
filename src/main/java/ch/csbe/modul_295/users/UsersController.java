package ch.csbe.modul_295.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * This class defines a REST controller for managing user-related operations.
 */
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * Create a new user.
     *
     * @param userDto The user data as a UserDto object.
     * @return A ResponseEntity with a success or error message.
     */
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        // Call the service to create a new user
        Users newUser = usersService.createUser(userDto);
        // Check if the user creation was successful
        if (newUser != null) {
            // Return a success response with a status of CREATED
            return ResponseEntity.status(HttpStatus.CREATED).body("User added");
        } else {
            // Return an error response with a status of BAD REQUEST
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user.");
        }
    }

    /**
     * Update an existing user.
     *
     * @param id      The ID of the user to update.
     * @param userDto The updated user data as a UserDto object.
     * @return A ResponseEntity with a success or error message.
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        // Call the service to update an existing user
        Users updatedUser = usersService.updateUser(id, userDto);
        // Check if the user update was successful
        if (updatedUser != null) {
            // Return a success response with a status of OK
            return ResponseEntity.ok("User with ID " + id + " has been updated");
        } else {
            // Return an error response with a status of NOT FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not found.");
        }
    }

    /**
     * Delete a user by ID.
     *
     * @param id The ID of the user to delete.
     * @return A ResponseEntity with a success message.
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        // Call the service to delete a user
        usersService.deleteUser(id);
        // Return a success response with a status of OK
        return ResponseEntity.ok("User with ID " + id + " has been deleted.");
    }

    /**
     * Retrieve user information by ID.
     *
     * @param id The ID of the user to retrieve.
     * @return A ResponseEntity containing the user information or an error message.
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUsers(@PathVariable int id) {
        // Call the service to retrieve user information
        UserDto userDto = usersService.getUserDto(id);

        if (userDto != null) {
            // Return a success response with the user information
            return ResponseEntity.ok(userDto);
        } else {
            // Return an error response with a status of NOT FOUND
            String errorMessage = "User with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}

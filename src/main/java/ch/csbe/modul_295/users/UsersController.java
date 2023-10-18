package ch.csbe.modul_295.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        Users newUser = usersService.createUser(userDto);
        if (newUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("user added");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user.");
        }
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        Users updatedUser = usersService.updateUser(id, userDto);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not found.");
        }
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok("User with ID " + id + " has been deleted.");
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUsers(@PathVariable int id) {
        UserDto userDto = usersService.getUserDto(id);

        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        } else {
            String errorMessage = "User with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}

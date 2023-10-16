package ch.csbe.modul_295.users;

import ch.csbe.modul_295.category.Category;
import ch.csbe.modul_295.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUsers(@PathVariable int id) {
        Users user = usersService.getUsers(id);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            String errorMessage = "User with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}

package ch.csbe.modul_295.category;


import ch.csbe.modul_295.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{id}")

    public ResponseEntity<?> getCategory(@PathVariable int id) {
        Category category = categoryService.getCategory(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            String errorMessage = "Category with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}



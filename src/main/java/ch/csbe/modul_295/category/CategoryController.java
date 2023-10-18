package ch.csbe.modul_295.category;


import ch.csbe.modul_295.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto){
        Category newCategory = categoryService.createCategory(categoryDto);
        if (newCategory != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create category.");
        }
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody CategoryDto categoryDto){
        Category updateCategory = categoryService.updateCategory(id,categoryDto);
        if (updateCategory != null){
            return ResponseEntity.ok(updateCategory);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category with ID " + id + " not found.");
        }
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category with ID " + id + " has ben deleted");
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<?> getCategory(@PathVariable int id) {
        CategoryDto categoryDto = categoryService.getCategoryDto(id);
        if (categoryDto != null) {
            return ResponseEntity.ok(categoryDto);
        } else {
            String errorMessage = "Category with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}



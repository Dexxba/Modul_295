package ch.csbe.modul_295.category;

import ch.csbe.modul_295.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The CategoryController class handles HTTP requests related to product categories.
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Creates a new product category.
     *
     * @param categoryDto The CategoryDto object containing category information sent in the request body.
     * @return A ResponseEntity with the HTTP status and a message indicating success or failure.
     */
    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto) {
        // Create a new category using the service
        Category newCategory = categoryService.createCategory(categoryDto);
        if (newCategory != null) {
            // Return a success response with HTTP status 201 (Created)
            return ResponseEntity.status(HttpStatus.CREATED).body("Category added");
        } else {
            // Return an error response with HTTP status 400 (Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create category.");
        }
    }

    /**
     * Updates an existing product category.
     *
     * @param id          The unique identifier of the category to update.
     * @param categoryDto The CategoryDto object containing the updated category information.
     * @return A ResponseEntity with the updated category information or an error message.
     */
    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
        // Update an existing category using the service
        Category updatedCategory = categoryService.updateCategory(id, categoryDto);
        if (updatedCategory != null) {
            // Return a success response with the updated category information
            return ResponseEntity.ok(updatedCategory);
        } else {
            // Return an error response with HTTP status 404 (Not Found) if the category is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category with ID " + id + " not found.");
        }
    }

    /**
     * Deletes a product category by its unique identifier.
     *
     * @param id The unique identifier of the category to delete.
     * @return A ResponseEntity with a message indicating successful deletion.
     */
    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        // Delete a category by its unique identifier using the service
        categoryService.deleteCategory(id);
        // Return a success response with a message indicating deletion
        return ResponseEntity.ok("Category with ID " + id + " has been deleted");
    }

    /**
     * Retrieves product category information by its unique identifier.
     *
     * @param id The unique identifier of the category to retrieve.
     * @return A ResponseEntity with the category information or an error message.
     */
    @GetMapping("/category/{id}")
    public ResponseEntity<?> getCategory(@PathVariable int id) {
        // Retrieve category information by its unique identifier using the service
        CategoryDto categoryDto = categoryService.getCategoryDto(id);
        if (categoryDto != null) {
            // Return a success response with the category information
            return ResponseEntity.ok(categoryDto);
        } else {
            // Return an error response with HTTP status 404 (Not Found) if the category is not found
            String errorMessage = "Category with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}

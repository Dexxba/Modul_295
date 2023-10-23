package ch.csbe.modul_295.product;

import ch.csbe.modul_295.category.Category;
import ch.csbe.modul_295.category.CategoryService;
import ch.csbe.modul_295.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents a controller for managing products.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productservice;

    /**
     * Create a new product.
     *
     * @param productDto The product data to create.
     * @return ResponseEntity with the result of the creation.
     */
    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
        // Create a new product using the provided data
        Product newProduct = productservice.createProduct(productDto);
        if (newProduct != null) {
            // Return a success response if the product was created
            return ResponseEntity.status(HttpStatus.CREATED).body("Product added");
        } else {
            // Return an error response if the creation failed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create product.");
        }
    }

    /**
     * Update an existing product with the specified ID.
     *
     * @param id         The ID of the product to update.
     * @param productDto The product data for the update.
     * @return ResponseEntity with the updated product or an error message.
     */
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductDto productDto) {
        // Update an existing product with the provided ID and data
        Product updateProduct = productservice.updateProduct(id, productDto);
        if (updateProduct != null) {
            // Return the updated product if the update was successful
            return ResponseEntity.ok(updateProduct);
        } else {
            // Return an error response if the product was not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + id + " not found.");
        }
    }

    /**
     * Delete a product with the specified ID.
     *
     * @param id The ID of the product to delete.
     * @return ResponseEntity with a success message or an error message.
     */
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        // Delete a product with the provided ID
        productservice.deleteProduct(id);
        // Return a success message to confirm deletion
        return ResponseEntity.ok("Product with ID " + id + " has been deleted.");
    }

    /**
     * Get product details for the specified ID.
     *
     * @param id The ID of the product to retrieve.
     * @return ResponseEntity with the product details or an error message.
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id) {
        // Retrieve product details for the specified ID
        ProductDto productDto = productservice.getProductDto(id);
        if (productDto != null) {
            // Return the product details if found
            return ResponseEntity.ok(productDto);
        } else {
            // Return an error response if the product was not found
            String errorMessage = "Product with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    /**
     * Get a list of all products.
     *
     * @return List of Product objects.
     */
    @GetMapping("product/list")
    public List<Product> getProducts() {
        // Retrieve a list of all products
        return productservice.getProducts();
    }
}

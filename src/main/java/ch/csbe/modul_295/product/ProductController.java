package ch.csbe.modul_295.product;

import ch.csbe.modul_295.category.Category;
import ch.csbe.modul_295.category.CategoryService;
import ch.csbe.modul_295.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productservice;

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto){
        Product newProduct = productservice.createProduct(productDto);
        if (newProduct != null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Product added");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create product.");
        }
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductDto productDto){
        Product updateProduct = productservice.updateProduct(id,productDto);
        if (updateProduct != null){
            return ResponseEntity.ok(updateProduct);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + id + " not found.");
        }
    }
@DeleteMapping("/product/{id}")
public ResponseEntity<?> deleteProduct(@PathVariable int id){
        productservice.deleteProduct(id);
        return ResponseEntity.ok("Product with ID " + id + "has been deleted.");
}
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id) {
        ProductDto productDto = productservice.getProductDto(id);
        if (productDto != null) {
            return ResponseEntity.ok(productDto);
        } else {
            String errorMessage = "Product with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
    @GetMapping("product/list")
    public List<Product> getProducts(){
        return productservice.getProducts();
    }
}


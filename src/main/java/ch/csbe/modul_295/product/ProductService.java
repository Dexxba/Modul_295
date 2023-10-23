package ch.csbe.modul_295.product;

import ch.csbe.modul_295.category.Category;
import ch.csbe.modul_295.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing products.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The retrieved product or null if not found.
     */
    public Product saveProduct(int id) {
        // Retrieve a product by its ID from the repository and return it, or return null if not found.
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves a ProductDto by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The retrieved ProductDto or null if not found.
     */
    public ProductDto getProductDto(Integer id) {
        // Retrieve a Product by its ID from the repository.
        Product product = productRepository.findById(id).orElse(null);

        if (null == product) {
            // If the product is not found, return null.
            return null;
        }
        // Create a ProductDto based on the retrieved Product and return it.
        ProductDto productDto = new ProductDto();
        productDto.setSku(product.getSku());
        productDto.setActive(product.getActive());
        productDto.setName(product.getName());
        productDto.setImage(product.getImage());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setStock(product.getStock());
        productDto.setCategory(product.getCategoryRepository());
        return productDto;
    }

    /**
     * Creates a new product using the provided ProductDto.
     *
     * @param productDto The ProductDto to create the product from.
     * @return The newly created product.
     */
    public Product createProduct(ProductDto productDto) {
        // Create a new Product instance and return it by calling the saveProduct method.
        Product newProduct = new Product();
        return saveProduct(productDto, newProduct);
    }

    /**
     * Updates an existing product with the provided ProductDto.
     *
     * @param id         The ID of the product to update.
     * @param productDto The ProductDto containing updated information.
     * @return The updated product or null if the product doesn't exist.
     */
    public Product updateProduct(int id, ProductDto productDto) {
        // Retrieve an existing Product by its ID from the repository.
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct == null) {
            // If the product doesn't exist, return null.
            return null;
        }
        // Update and save the existing Product using the provided ProductDto and return it.
        return saveProduct(productDto, existingProduct);
    }

    /**
     * Saves a ProductDto to an existing Product.
     *
     * @param productDto      The ProductDto containing the updated information.
     * @param existingProduct The existing Product to update.
     * @return The updated Product.
     */
    public Product saveProduct(ProductDto productDto, Product existingProduct) {
        // Update the fields of the existing Product with the values from the ProductDto.
        existingProduct.setSku(productDto.getSku());
        existingProduct.setActive(productDto.isActive());
        existingProduct.setName(productDto.getName());
        existingProduct.setImage(productDto.getImage());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setStock(productDto.getStock());
        existingProduct.setCategoryRepository(productDto.getCategory());
        // Save the updated Product to the repository and return it.
        return productRepository.save(existingProduct);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     */
    public void deleteProduct(int id) {
        // Delete a product from the repository by its ID.
        productRepository.deleteById(id);
    }

    /**
     * Retrieves a list of all products.
     *
     * @return A list of all products in the repository.
     */
    public List<Product> getProducts() {
        // Retrieve a list of all products from the repository and return it.
        return productRepository.findAll();
    }
}

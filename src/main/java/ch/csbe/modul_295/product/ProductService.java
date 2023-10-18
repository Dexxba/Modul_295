package ch.csbe.modul_295.product;

import ch.csbe.modul_295.category.Category;
import ch.csbe.modul_295.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public Product saveProduct(int id) {

        return productRepository.findById(id).orElse(null);}
public ProductDto getProductDto(Integer id){
        Product product = productRepository.findById(id).orElse(null);
        if (null == product){
            return null;
        }
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
public Product createProduct(ProductDto productDto){
        Product newProduct = new Product();
        return saveProduct(productDto, newProduct);
}
public Product updateProduct(int id, ProductDto productDto){
        Product existingProuct = productRepository.findById(id).orElse(null);
        if (existingProuct == null){
            return null;
        }
        return saveProduct(productDto, existingProuct);
}
public Product saveProduct(ProductDto productDto, Product existingProuct){
        existingProuct.setSku(productDto.getSku());
        existingProuct.setActive(productDto.isActive());
        existingProuct.setName(productDto.getName());
        existingProuct.setImage(productDto.getImage());
        existingProuct.setDescription(productDto.getDescription());
        existingProuct.setPrice(productDto.getPrice());
        existingProuct.setStock(productDto.getStock());
        existingProuct.setCategoryRepository(productDto.getCategory());
        return productRepository.save(existingProuct);
}

public void deleteProduct(int id){
        productRepository.deleteById(id);
}
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

}

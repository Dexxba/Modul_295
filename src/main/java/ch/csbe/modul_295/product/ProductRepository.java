package ch.csbe.modul_295.product;


import ch.csbe.modul_295.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * This interface defines a repository for the `Product` entity.
 * It extends the JpaRepository interface provided by Spring Data JPA,
 * which allows for common CRUD (Create, Read, Update, Delete) operations
 * to be performed on the `Product` entity.
 *
 * @param <Product> The entity type this repository manages.
 * @param <Integer> The type of the primary key of the entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}

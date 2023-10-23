package ch.csbe.modul_295.category;
import ch.csbe.modul_295.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The CategoryRepository interface defines data access operations for the Category entity.
 * It extends JpaRepository, which provides basic CRUD (Create, Read, Update, Delete) functionality.
 *
 * @param <Category> The entity type this repository manages.
 * @param <Integer> The type of the primary key of the entity.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

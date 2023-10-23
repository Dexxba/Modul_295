package ch.csbe.modul_295.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The CategoryService class provides services for managing product categories.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Saves a category with a given ID.
     *
     * @param id The unique identifier of the category to be saved.
     * @return The saved Category object or null if not found.
     */
    public Category saveCategory(int id) {
        // Retrieve a category by its ID from the repository and return it, or return null if not found.
        return categoryRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves a CategoryDto for a category with a given ID.
     *
     * @param id The unique identifier of the category to retrieve.
     * @return The CategoryDto for the specified category, or null if not found.
     */
    public CategoryDto getCategoryDto(Integer id) {
        // Retrieve a category by its ID from the repository, convert it to a CategoryDto, and return it.
        // If the category is not found, return null.
        Category category = categoryRepository.findById(id).orElse(null);
        if (null == category) {
            return null;
        }
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setActive(category.getActive());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    /**
     * Creates a new product category.
     *
     * @param categoryDto The CategoryDto object containing category information.
     * @return The newly created Category object.
     */
    public Category createCategory(CategoryDto categoryDto) {
        // Create a new Category object, then save it using the saveCategory method.
        Category newCategory = new Category();
        return saveCategory(categoryDto, newCategory);
    }

    /**
     * Updates an existing product category.
     *
     * @param id          The unique identifier of the category to be updated.
     * @param categoryDto The CategoryDto object containing the updated category information.
     * @return The updated Category object or null if the category doesn't exist.
     */
    public Category updateCategory(int id, CategoryDto categoryDto) {
        // Retrieve the existing category by its ID from the repository.
        // If the category doesn't exist, return null. Otherwise, update it using the saveCategory method.
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory == null) {
            return null;
        }
        return saveCategory(categoryDto, existingCategory);
    }

    /**
     * Saves category information from a CategoryDto object into an existing Category object.
     *
     * @param categoryDto      The CategoryDto object containing category information.
     * @param existingCategory The existing Category object to be updated.
     * @return The updated Category object.
     */
    public Category saveCategory(CategoryDto categoryDto, Category existingCategory) {
        // Update the existing Category object with data from the CategoryDto and save it to the repository.
        existingCategory.setActive(categoryDto.isActive());
        existingCategory.setName(categoryDto.getName());
        return categoryRepository.save(existingCategory);
    }

    /**
     * Deletes a product category by its unique identifier.
     *
     * @param id The unique identifier of the category to be deleted.
     */
    public void deleteCategory(int id) {
        // Delete a category by its ID from the repository.
        categoryRepository.deleteById(id);
    }
}

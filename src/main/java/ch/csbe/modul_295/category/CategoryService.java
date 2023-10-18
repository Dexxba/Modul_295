package ch.csbe.modul_295.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(int id) {

        return categoryRepository.findById(id).orElse(null);
    }

    public CategoryDto getCategoryDto(Integer id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (null == category) {
            return null;
        }
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setActive(category.getActive());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    public Category createCategory(CategoryDto categoryDto) {
        Category newCategory = new Category();
        return saveCategory(categoryDto, newCategory);
    }
    public Category updateCategory(int id, CategoryDto categoryDto){
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory == null){
            return null;
        }
        return saveCategory(categoryDto, existingCategory);
    }
    public Category saveCategory(CategoryDto categoryDto, Category existingCategory){
        existingCategory.setActive(categoryDto.isActive());
        existingCategory.setName(categoryDto.getName());
        return categoryRepository.save(existingCategory);
    }
    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }
}
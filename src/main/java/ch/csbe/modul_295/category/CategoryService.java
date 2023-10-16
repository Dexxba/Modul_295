package ch.csbe.modul_295.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public Category getCategory(int id) {return categoryRepository.findById(id).orElse(null);}

}

package com.uep.wap.service;

import com.uep.wap.model.User;
import com.uep.wap.repository.StudentRepository;
import com.uep.wap.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.getName(), categoryDTO.getPosts());
        categoryRepository.save(category);

        System.out.println("Category added");
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}


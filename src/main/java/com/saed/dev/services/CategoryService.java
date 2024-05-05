package com.saed.dev.services;

import com.saed.dev.entities.Category;
import com.saed.dev.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }
    public Category findById (Long id) {
       Optional<Category> category = repository.findById(id); // Retorna um objeto do tipo Optional que pode ou não conter um objeto do tipo Category
       return category.get();
    }
}

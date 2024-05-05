package com.saed.dev.services;

import com.saed.dev.entities.Product;
import com.saed.dev.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }
    public Product findById (Long id) {
       Optional<Product> product = repository.findById(id); // Retorna um objeto do tipo Optional que pode ou não conter um objeto do tipo Product
       return product.get();
    }
}

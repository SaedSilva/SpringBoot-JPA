package com.saed.dev.services;

import com.saed.dev.entities.Order;
import com.saed.dev.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }
    public Order findById (Long id) {
       Optional<Order> order = repository.findById(id); // Retorna um objeto do tipo Optional que pode ou não conter um objeto do tipo Order
       return order.get();
    }
}

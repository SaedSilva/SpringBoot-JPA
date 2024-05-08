package com.saed.dev.services;

import com.saed.dev.entities.User;
import com.saed.dev.repositories.UserRepository;
import com.saed.dev.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById (Long id) {
       Optional<User> user = repository.findById(id); // Retorna um objeto do tipo Optional que pode ou não conter um objeto do tipo User
       return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete (Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

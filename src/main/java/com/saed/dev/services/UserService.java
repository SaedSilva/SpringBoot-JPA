package com.saed.dev.services;

import com.saed.dev.entities.User;
import com.saed.dev.repositories.UserRepository;
import com.saed.dev.services.exceptions.DatabaseException;
import com.saed.dev.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public void delete(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            try {
                repository.deleteById(id);
            } catch (DataIntegrityViolationException e) {
                throw new DatabaseException(e.getMessage());
            }
        } else {
            throw new ResourceNotFoundException(id);
        }
    }


    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

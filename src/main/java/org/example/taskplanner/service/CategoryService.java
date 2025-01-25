package org.example.taskplanner.service;

import lombok.AllArgsConstructor;
import org.example.taskplanner.entity.Category;
import org.example.taskplanner.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(long id) {
        return repository.findById(id).orElse(null);
    }
}

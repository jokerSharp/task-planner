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

    public List<Category> findAll(String email) {
        return repository.findByUserEmailOrderByTitleAsc(email);
    }

    @Transactional
    public Category add(Category category) {
        return repository.save(category);
    }

    @Transactional
    public Category update(Category category) {
        return repository.save(category);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Category> findByTitle(String text, String email) {
        return repository.findByTitle(text, email);
    }

    public Category findById(Long id) {
        return repository.findById(id).get();
    }
}

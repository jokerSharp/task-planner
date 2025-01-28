package org.example.taskplanner.service;

import lombok.AllArgsConstructor;
import org.example.taskplanner.entity.Priority;
import org.example.taskplanner.repository.PriorityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PriorityService {

    private final PriorityRepository repository;

    public List<Priority> findAll(String email) {
        return repository.findByUserEmailOrderByIdAsc(email);
    }

    public Priority add(Priority priority) {
        return repository.save(priority);
    }

    public Priority update(Priority priority) {
        return repository.save(priority);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Priority findById(Long id) {
        return repository.findById(id).get();
    }

    public List<Priority> find(String title, String email) {
        return repository.findByTitle(title, email);
    }
}

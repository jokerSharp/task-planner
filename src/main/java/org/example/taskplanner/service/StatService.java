package org.example.taskplanner.service;

import lombok.AllArgsConstructor;
import org.example.taskplanner.entity.Stat;
import org.example.taskplanner.repository.StatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class StatService {

    private final StatRepository repository;

    public Stat findStat(String email) {
        return repository.findByUserEmail(email);
    }
}

package org.example.taskplanner.repository;

import org.example.taskplanner.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {

    Stat findByUserEmail(String email);
}

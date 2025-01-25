package org.example.taskplanner.repository;

import org.example.taskplanner.entity.Activity;
import org.example.taskplanner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}

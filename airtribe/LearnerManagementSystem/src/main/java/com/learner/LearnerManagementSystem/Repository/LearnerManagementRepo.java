package com.learner.LearnerManagementSystem.Repository;

import com.learner.LearnerManagementSystem.model.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerManagementRepo extends JpaRepository<Learner,Long> {
    Learner findBylearnerName(String name);
}

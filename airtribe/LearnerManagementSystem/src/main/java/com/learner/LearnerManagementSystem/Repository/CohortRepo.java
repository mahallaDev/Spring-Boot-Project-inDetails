package com.learner.LearnerManagementSystem.Repository;

import com.learner.LearnerManagementSystem.model.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CohortRepo extends JpaRepository<Cohort,Long> {
}

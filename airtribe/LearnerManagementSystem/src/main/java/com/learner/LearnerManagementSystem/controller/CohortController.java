package com.learner.LearnerManagementSystem.controller;

import com.learner.LearnerManagementSystem.model.Cohort;
import com.learner.LearnerManagementSystem.service.CohortNotFoundException;
import com.learner.LearnerManagementSystem.service.LearnerManagementService;
import com.learner.LearnerManagementSystem.service.LearnerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CohortController {

    @Autowired
    LearnerManagementService learnerManagementService;

    @PostMapping("/cohorts")
    public Cohort createCohort(@RequestBody Cohort cohort){
        return learnerManagementService.createCohort(cohort);
    }

    @GetMapping("/cohorts")
    public List<Cohort> getCohorts(){
        return learnerManagementService.getCohorts();
    }

    @PostMapping("/assignlearnerToCohort")
    public Cohort assignCohortToLearners(@RequestParam Long cohortID,@RequestParam Long learnerId) throws CohortNotFoundException, LearnerNotFoundException{

        return learnerManagementService.assignLearnerToCohort(cohortID,learnerId);

    }

    @ExceptionHandler(CohortNotFoundException.class)
    public ResponseEntity handleCohortNotFoundException(CohortNotFoundException cohortNotFoundException){
        return ResponseEntity.status(404).body(cohortNotFoundException.getMessage());
    }


    @ExceptionHandler(LearnerNotFoundException.class)
    public ResponseEntity handleCohortNotFoundException(LearnerNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
}

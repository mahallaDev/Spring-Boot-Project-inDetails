package com.learner.LearnerManagementSystem.controller;

import com.learner.LearnerManagementSystem.model.Learner;
import com.learner.LearnerManagementSystem.model.LearnerDTO;
import com.learner.LearnerManagementSystem.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LearnerManagementController {

    @Autowired
    LearnerManagementService learnerManagementService;

    @PostMapping("/learner")
    public Learner createLearner(@RequestBody Learner learner){

        return learnerManagementService.addLearner(learner);
    }

    @GetMapping("/learner")
    public List<LearnerDTO> getLearnerDetails(){

        List<Learner>leareners=learnerManagementService.getLearnersDetails();

        return learnerManagementService.parseLearnerToLearnerDTO(leareners);
    }


    //API modeling
    //Query Parameter - /learner?learnerId=1&&learnerName=abhishek

    @GetMapping("/learner/{learnerId}")
    public Learner getLearnerByLeanerIdAndLearnerName(@RequestParam("learnerId") String learnerId){

        return learnerManagementService.getLearnerByLearnerIdAndLearnerName(learnerId);

    }
}

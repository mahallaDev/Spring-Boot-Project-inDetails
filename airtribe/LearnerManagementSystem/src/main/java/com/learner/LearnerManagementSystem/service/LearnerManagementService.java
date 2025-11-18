package com.learner.LearnerManagementSystem.service;

import com.learner.LearnerManagementSystem.Repository.CohortRepo;
import com.learner.LearnerManagementSystem.Repository.LearnerManagementRepo;
import com.learner.LearnerManagementSystem.model.Cohort;
import com.learner.LearnerManagementSystem.model.CohortDTO;
import com.learner.LearnerManagementSystem.model.Learner;
import com.learner.LearnerManagementSystem.model.LearnerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LearnerManagementService {

    @Autowired
    LearnerManagementRepo learnerManagementRepo;

    @Autowired
    CohortRepo cohortRepo;

    public Learner addLearner(Learner learner){
       return learnerManagementRepo.save(learner);
    }

    public List<Learner> getLearnersDetails(){
        return  learnerManagementRepo.findAll();
    }

    public Learner getLearnerByLearnerIdAndLearnerName(String learnerId){
        return learnerManagementRepo.findBylearnerName(learnerId);
    }

    public Cohort createCohort(Cohort cohort){
        return cohortRepo.save(cohort);

    }

    public List<Cohort> getCohorts(){

        return cohortRepo.findAll();
    }

    public Cohort assignLearnerToCohort(Long cohortID,Long learnerId) throws LearnerNotFoundException, CohortNotFoundException{
        Optional<Cohort> optionalCohort=cohortRepo.findById(cohortID);
        if(!optionalCohort.isPresent()){
            throw new CohortNotFoundException("Cohort ID is not found "+cohortID);
        }

        Optional<Learner> optionalLearner=learnerManagementRepo.findById(learnerId);
        if(!optionalLearner.isPresent()){
            throw new LearnerNotFoundException("Learner id is not found "+learnerId);
        }

        Cohort cohort=optionalCohort.get();
        List<Learner> existingLearnerList=cohort.getLearnerList();
        existingLearnerList.add(optionalLearner.get());
        return cohortRepo.save(cohort);


    }

    public List<LearnerDTO> parseLearnerToLearnerDTO(List<Learner> leareners){
        List<LearnerDTO> learnerDTO=new ArrayList<>();

        for(Learner learner:leareners){
            LearnerDTO learnerDTO1=new LearnerDTO();
            learnerDTO1.setLearnerId(learner.getLearnerId());
            learnerDTO1.setLearnerName(learner.getLearnerName());
            learnerDTO1.setLearnerEmailAddress(learner.getLearnerEmailAddress());
            learnerDTO1.setCohortDTOS(new ArrayList<>());
            for(Cohort cohort:learner.getCohortList()){
                CohortDTO cohortDTO=new CohortDTO();
                cohortDTO.setCohortId(cohort.getCohortId());
                cohortDTO.setCohortName(cohort.getCohortName());
                cohortDTO.setCohortDesc(cohort.getCohortDesc());
                learnerDTO1.getCohortDTOS().add(cohortDTO);
            }
            learnerDTO.add(learnerDTO1);
        }
    return learnerDTO;
    }
}

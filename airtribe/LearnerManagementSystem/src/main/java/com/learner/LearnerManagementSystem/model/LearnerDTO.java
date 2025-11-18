package com.learner.LearnerManagementSystem.model;

import java.util.List;

public class LearnerDTO {
    private Long learnerId;
    private String learnerName;
    private String learnerEmailAddress;
    private List<CohortDTO> cohortDTOS;

    public Long getLearnerId(){
        return learnerId;
    }

    public void setLearnerId(Long learnerId){
        this.learnerId = learnerId;
    }

    public String getLearnerName(){
        return learnerName;
    }

    public void setLearnerName(String learnerName){
        this.learnerName = learnerName;
    }

    public String getLearnerEmailAddress(){
        return learnerEmailAddress;
    }

    public void setLearnerEmailAddress(String learnerEmailAddress){
        this.learnerEmailAddress = learnerEmailAddress;
    }

    public List<CohortDTO> getCohortDTOS(){
        return cohortDTOS;
    }

    public void setCohortDTOS(List<CohortDTO> cohortDTOS){
        this.cohortDTOS = cohortDTOS;
    }
}

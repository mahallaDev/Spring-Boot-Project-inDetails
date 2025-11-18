package com.learner.LearnerManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Learner {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long learnerId;
    private String learnerName;
    private String learnerEmailAddress;

    //Backreferencing -->
//    @ManyToMany(mappedBy = "learnerList") --> when we add this mapped by attributes , in database it will create the relationship table which having learnerID and cohortID.
    //to fix the circular mapping while fetching the
    @ManyToMany(mappedBy = "learnerList")
    @JsonIgnore
     List<Cohort> cohortList;

    public Long getLearnerId(){
        return learnerId;
    }

    public List<Cohort> getCohortList(){
        return cohortList;
    }

    public void setCohortList(List<Cohort> cohortList){
        this.cohortList = cohortList;
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
}

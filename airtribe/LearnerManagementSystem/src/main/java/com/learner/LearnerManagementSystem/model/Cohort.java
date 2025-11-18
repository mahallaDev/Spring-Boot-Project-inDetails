package com.learner.LearnerManagementSystem.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cohort {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cohortId;
    private String cohortName;
    private String cohortDesc;

    @ManyToMany

    List<Learner> learnerList;

    public Cohort(){
    }

    public Cohort(long cohortId,String cohortName,String cohortDesc,List<Learner> learnerList){
        this.cohortId = cohortId;
        this.cohortName = cohortName;
        this.cohortDesc = cohortDesc;
        this.learnerList = learnerList;
    }



    public long getCohortId(){
        return cohortId;
    }

    public void setCohortId(long cohortId){
        this.cohortId = cohortId;
    }

    public String getCohortName(){
        return cohortName;
    }

    public void setCohortName(String cohortName){
        this.cohortName = cohortName;
    }

    public String getCohortDesc(){
        return cohortDesc;
    }

    public void setCohortDesc(String cohortDesc){
        this.cohortDesc = cohortDesc;
    }

    public List<Learner> getLearnerList(){
        return learnerList;
    }

    public void setLearnerList(List<Learner> learnerList){
        this.learnerList = learnerList;
    }
}

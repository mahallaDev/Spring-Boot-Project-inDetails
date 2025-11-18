package com.learner.LearnerManagementSystem.service;

public class CohortNotFoundException extends Throwable {
    public CohortNotFoundException(String s){
        System.out.println("Cohort ID is not found:"+s);
    }
}

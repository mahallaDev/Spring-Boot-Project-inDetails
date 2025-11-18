package com.learner.LearnerManagementSystem.service;

public class LearnerNotFoundException extends Throwable {
    public LearnerNotFoundException(String s){
        System.out.println("Learner is  not found exception "+s);
    }
}

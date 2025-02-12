package com.icicibank.produce.icicibankproduce.services;

import com.icicibank.produce.icicibankproduce.entity.StudentInfoPojo;
import com.icicibank.produce.icicibankproduce.pojo.StudentInfo;
import com.icicibank.produce.icicibankproduce.repository.StudentDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentDetailServices {

    @Autowired
    StudentDetailsRepo studentDetailsRepo;

    public String  registerStudentService(StudentInfoPojo studentInfoPojo) {

        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setEmailId(studentInfoPojo.getEmailId());
        studentInfo.setFirstName(studentInfoPojo.getFirstName());
        studentInfo.setLastName(studentInfoPojo.getLastName());
        studentInfo.setMobile(studentInfoPojo.getMobile());
        studentInfo.setPassword(studentInfoPojo.getPassword());

           studentDetailsRepo.save(studentInfo);
        return "User get registered";
    }

    public StudentInfoPojo getStudentDetailsByEmailId(String email_id) {

        StudentInfo studentInfo=studentDetailsRepo.findById(email_id).get();
        StudentInfoPojo studentInfoPojo=new StudentInfoPojo();
        studentInfoPojo.setEmailId(studentInfo.getEmailId());
        studentInfoPojo.setFirstName(studentInfo.getFirstName());
        studentInfoPojo.setPassword(studentInfo.getPassword());
        studentInfoPojo.setLastName(studentInfo.getLastName());
        studentInfoPojo.setMobile(studentInfo.getMobile());

        return studentInfoPojo;
    }
}

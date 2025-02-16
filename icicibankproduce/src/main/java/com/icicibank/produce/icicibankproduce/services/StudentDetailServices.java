package com.icicibank.produce.icicibankproduce.services;

import com.icicibank.produce.icicibankproduce.entity.StudentInfoPojo;
import com.icicibank.produce.icicibankproduce.pojo.StudentInfo;
import com.icicibank.produce.icicibankproduce.repository.StudentDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        studentInfo.setStandard(studentInfoPojo.getStandard());
        studentInfo.setResult(studentInfo.getResult());

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

    public String updateStudentResultAndStandard(StudentInfoPojo studentInfoPojo) {

    StudentInfo studentInfo=new StudentInfo();
    studentInfo.setStandard(studentInfoPojo.getStandard());
    studentInfo.setResult(studentInfoPojo.getResult());
    studentInfo.setEmailId(studentInfoPojo.getEmailId());
    studentInfo.setFirstName(studentInfoPojo.getFirstName());
    studentInfo.setLastName(studentInfoPojo.getLastName());
    studentInfo.setMobile(studentInfoPojo.getMobile());
    studentInfo.setPassword(studentInfoPojo.getPassword());
    studentDetailsRepo.save(studentInfo);

    return "User details is getting updated";

    }

    public List<StudentInfoPojo> getStudentDetailsFromStandardAndResult(String standard, String result) {
        List<StudentInfoPojo> studentInfoPojo=new ArrayList<>();
       List< StudentInfo> studentInfo=(List<StudentInfo>) studentDetailsRepo.findByStandardAndResult(standard,result);
        System.out.println(studentInfo);
        for(int i=0;i<studentInfo.size();i++) {
            StudentInfoPojo studentInfoPojo1=new StudentInfoPojo();
            studentInfoPojo1.setMobile(studentInfo.get(i).getMobile());
            studentInfoPojo1.setResult(studentInfo.get(i).getResult());
            studentInfoPojo1.setStandard(studentInfo.get(i).getStandard());
            studentInfoPojo1.setPassword(studentInfo.get(i).getPassword());
            studentInfoPojo1.setFirstName(studentInfo.get(i).getFirstName());
            studentInfoPojo1.setLastName(studentInfo.get(i).getLastName());
            studentInfoPojo1.setEmailId(studentInfo.get(i).getEmailId());

            studentInfoPojo.add(studentInfoPojo1);

        }
        return studentInfoPojo;
    }
}

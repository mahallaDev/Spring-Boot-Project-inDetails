package com.icicibank.produce.icicibankproduce.controller.student;

import com.icicibank.produce.icicibankproduce.entity.StudentInfoPojo;
import com.icicibank.produce.icicibankproduce.services.StudentDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentRegisterController {

    @Autowired
    StudentDetailServices studentDetailServices;

    @PostMapping("/student/register")
    public  String registerStudent(@RequestBody StudentInfoPojo studentInfoPojo){

        studentDetailServices.registerStudentService(studentInfoPojo);


        return  "user register sucessfull !";
    }

    @GetMapping("student/info/{email_id}")
    public String getStudentDetails(@PathVariable String email_id){

        StudentInfoPojo studentInfoPojo=studentDetailServices.getStudentDetailsByEmailId(email_id);
      return "Email:"+studentInfoPojo.getEmailId()+" FirstName:"+studentInfoPojo.getFirstName()+" LastName:"+studentInfoPojo.getLastName()+" Mobile:"+studentInfoPojo.getMobile()+"" +
              " Password:"+studentInfoPojo.getPassword();
    }



}

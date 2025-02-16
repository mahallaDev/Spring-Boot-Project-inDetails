package com.icicibank.produce.icicibankproduce.controller.student;

import com.icicibank.produce.icicibankproduce.entity.StudentInfoPojo;
import com.icicibank.produce.icicibankproduce.pojo.StudentInfo;
import com.icicibank.produce.icicibankproduce.services.StudentDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRegisterController {

    @Autowired
    StudentDetailServices studentDetailServices;

    @PostMapping("/student/register")
    public  String registerStudent(@RequestBody StudentInfoPojo studentInfoPojo){

        studentDetailServices.registerStudentService(studentInfoPojo);


        return  "user register sucessfull !";
    }

    //Example on the Path variables
    @GetMapping("student/info/{email_id}")
    public String getStudentDetails(@PathVariable(name = "email_id") String email_id){

        StudentInfoPojo studentInfoPojo=studentDetailServices.getStudentDetailsByEmailId(email_id);
      return "Email:"+studentInfoPojo.getEmailId()+" FirstName:"+studentInfoPojo.getFirstName()+" LastName:"+studentInfoPojo.getLastName()+" Mobile:"+studentInfoPojo.getMobile()+"" +
              " Password:"+studentInfoPojo.getPassword();
    }


    @PutMapping("student/addResult")
    public String updateStandardAndResult(@RequestBody StudentInfoPojo studentInfoPojo){

        studentDetailServices.updateStudentResultAndStandard(studentInfoPojo);
        return "Student result has been added !" ;
    }

    //method which contain the multiple path variables
    @GetMapping("student/details/result/standard/{standard}/result/{result}")
    public List<StudentInfoPojo> getStudentDetailsOnBasisOfStandardAndResultStatus(@PathVariable String standard ,@PathVariable String result){

        List<StudentInfoPojo> studentInfoPojo= studentDetailServices.getStudentDetailsFromStandardAndResult(standard,result);
        return studentInfoPojo;
    }

    @GetMapping("student/info")
    public String getStudentDetailsByEmail(@RequestParam String email_id){

        StudentInfoPojo studentInfoPojo=studentDetailServices.getStudentDetailsByEmailId(email_id);
        return "Email:"+studentInfoPojo.getEmailId()+" FirstName:"+studentInfoPojo.getFirstName()+" LastName:"+studentInfoPojo.getLastName()+" Mobile:"+studentInfoPojo.getMobile()+"" +
                " Password:"+studentInfoPojo.getPassword();
    }

    //method which contain the multiple path variables
    @GetMapping("student/details")
    public List<StudentInfoPojo> getStudentDetailsOnBasisOfStandardAndResultStatusUsingReqParam(@RequestParam String standard ,@RequestParam String result){

        List<StudentInfoPojo> studentInfoPojo= studentDetailServices.getStudentDetailsFromStandardAndResult(standard,result);
        return studentInfoPojo;
    }




}

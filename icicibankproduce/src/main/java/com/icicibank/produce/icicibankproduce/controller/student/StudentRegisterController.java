package com.icicibank.produce.icicibankproduce.controller.student;

import com.icicibank.produce.icicibankproduce.entity.StudentInfoPojo;
import com.icicibank.produce.icicibankproduce.pojo.StudentInfo;
import com.icicibank.produce.icicibankproduce.services.StudentDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRegisterController {

    @Autowired
    StudentDetailServices studentDetailServices;

    //whenever the Post mapping is there we are sending the response as a Created (201) as resource is created.
    @PostMapping("/student/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentInfoPojo studentInfoPojo){

        String res=studentDetailServices.registerStudentService(studentInfoPojo);


        return  new ResponseEntity<>(res,HttpStatus.CREATED );
    }

    //Example on the Path variables
    @GetMapping("student/info/{email_id}")
    public ResponseEntity<StudentInfoPojo> getStudentDetails(@PathVariable(name = "email_id") String email_id){

        StudentInfoPojo studentInfoPojo=studentDetailServices.getStudentDetailsByEmailId(email_id);
      return new ResponseEntity<>(studentInfoPojo,HttpStatus.OK);
    }


    @PutMapping("student/addResult")
    public ResponseEntity<String> updateStandardAndResult(@RequestBody StudentInfoPojo studentInfoPojo){

      String res= studentDetailServices.updateStudentResultAndStandard(studentInfoPojo);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    //method which contain the multiple path variables
    @GetMapping("student/details/result/standard/{standard}/result/{result}")
    public ResponseEntity< List<StudentInfoPojo> > getStudentDetailsOnBasisOfStandardAndResultStatus(@PathVariable String standard ,@PathVariable String result){

        List<StudentInfoPojo> studentInfoPojo= studentDetailServices.getStudentDetailsFromStandardAndResult(standard,result);
        return new ResponseEntity<>(studentInfoPojo,HttpStatus.OK);
    }

    //Request param example where only added @RequestParam annotation
    @GetMapping("student/info")
    public ResponseEntity< StudentInfoPojo > getStudentDetailsByEmail(@RequestParam String email_id){

        StudentInfoPojo studentInfoPojo=studentDetailServices.getStudentDetailsByEmailId(email_id);
        return new ResponseEntity<>(studentInfoPojo,HttpStatus.OK);
    }

    //method which contain the multiple path variables
    @GetMapping("student/details")
    public ResponseEntity<List<StudentInfoPojo>> getStudentDetailsOnBasisOfStandardAndResultStatusUsingReqParam(@RequestParam String standard ,@RequestParam String result){

        List<StudentInfoPojo> studentInfoPojo= studentDetailServices.getStudentDetailsFromStandardAndResult(standard,result);
        return new ResponseEntity<>(studentInfoPojo,HttpStatus.OK);
    }




}

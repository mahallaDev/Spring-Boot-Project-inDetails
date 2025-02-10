package com.icicibank.produce.icicibankproduce.services;

import com.icicibank.produce.icicibankproduce.dto.UserRegisterDTO;
import com.icicibank.produce.icicibankproduce.entity.Userteacherinfo;
import com.icicibank.produce.icicibankproduce.repository.UserTeacherInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTeacherService {

    @Autowired
    UserTeacherInfoRepo userTeacherInfoRepo;

    public String userRegistartion(UserRegisterDTO userRegisterDTO){

        Userteacherinfo userTeacherinfo=new Userteacherinfo();
        userTeacherinfo.setContact(userRegisterDTO.getContact());
        userTeacherinfo.setName(userRegisterDTO.getName());
        userTeacherinfo.setEmailid(userRegisterDTO.getEmailid());
        userTeacherinfo.setPassword(userRegisterDTO.getPassword());
        userTeacherInfoRepo.save(userTeacherinfo);
        return "User Registration Sucessfull !";
    }

    public String loginCheck(String email,String password) {

        List<Userteacherinfo> users=userTeacherInfoRepo.findByEmailidAndPassword(email,password);

        if (users.size() != 0){
            return "Welcome to Teacher Home Page !";

        }else{
            return "Invalid credentials. Please try again";
        }

    }
}

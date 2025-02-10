package com.icicibank.produce.icicibankproduce.controller.teacher;

import com.icicibank.produce.icicibankproduce.dto.UserRegisterDTO;
import com.icicibank.produce.icicibankproduce.services.UserTeacherService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegisterTeacherController {
    @Autowired
    UserTeacherService userTeacherService;
    @GetMapping("register")
    public  String sayHello()
    {
            return "register";
    }

    @PostMapping("user/register")
    public ModelAndView registerUser(HttpServletRequest request){
        UserRegisterDTO userRegisterDTO=new UserRegisterDTO();
        userRegisterDTO.setName(request.getParameter("name"));
        userRegisterDTO.setContact(request.getParameter("contact"));
        userRegisterDTO.setEmailid(request.getParameter("email"));
        userRegisterDTO.setPassword(request.getParameter("pwd"));

        String result=userTeacherService.userRegistartion(userRegisterDTO);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("message",result);

        return modelAndView;


    }

    @GetMapping("/user/login")
    public String login(){
        return "login";
    }

    @PostMapping("user/home")
    public ModelAndView loginCheck(HttpServletRequest request){


  String loginMessage=userTeacherService.loginCheck(request.getParameter("email"),request.getParameter("pwd"));

  ModelAndView modelAndView =new ModelAndView();
  modelAndView.setViewName("teacherHomepage");
  modelAndView.addObject("loginMessage",loginMessage);


        return modelAndView;

    }


}

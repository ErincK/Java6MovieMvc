package com.erinc.Java6MovieMvc.controller;

import com.erinc.Java6MovieMvc.mapper.dto.request.LoginRequestDto;
import com.erinc.Java6MovieMvc.mapper.dto.request.UserResgisterRequestDto;
import com.erinc.Java6MovieMvc.mapper.dto.response.LoginResponseDto;
import com.erinc.Java6MovieMvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage(String email){
        System.out.println("email==>"+email);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("email",email);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(LoginRequestDto dto){
        ModelAndView modelAndView = new ModelAndView();
        try{
            LoginResponseDto responseDto = userService.login(dto);
           //modelAndView.addObject("result", responseDto.getName()+"--"+"Giris baSARİLİ");
            modelAndView.setViewName("redirect:/movie/findall");
        }catch (Exception e){
            e.printStackTrace();
            modelAndView.addObject("result",e.getMessage());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }



    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(UserResgisterRequestDto dto){
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.register2(dto);
            modelAndView.addObject("email",dto.getEmail());
            modelAndView.setViewName("redirect:login");
        }catch (Exception e){
            modelAndView.addObject("error",e.getMessage());
            modelAndView.setViewName("register");
        }






        return modelAndView;
    }












}

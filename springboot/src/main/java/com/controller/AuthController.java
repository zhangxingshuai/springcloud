package com.controller;

import com.config.annotation.MyLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@MyLog
public class AuthController {

    @PostMapping("login")
    public String login(String username, String password){

        return "登陆成功";
    }


    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(100);

        BigDecimal b = a.subtract(null);

        System.out.println();
    }
}

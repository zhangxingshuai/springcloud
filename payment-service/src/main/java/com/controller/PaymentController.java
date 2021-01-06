package com.controller;

import com.dao.PaymentDao;
import com.entity.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("payment")
public class PaymentController extends BaseController{
    @Resource
    private PaymentDao paymentDao;

    @GetMapping("getPaymentById/{id}")
    public void getPaymentById(@PathVariable("id") int id){
        Payment payment = paymentDao.selectById(id);
        returnSuccess(payment);
    }

}

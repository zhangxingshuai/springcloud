package com.controller;

import com.dao.PaymentDao;
import com.entity.Payment;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("payment")
@EnableDiscoveryClient
public class PaymentController extends BaseController{
    @Resource
    private PaymentDao paymentDao;

    @Resource
    DiscoveryClient discoveryClient;

    @Resource
    RestTemplate restTemplate;



    @GetMapping("getPaymentById/{id}")
    public void getPaymentById(@PathVariable("id") int id){
        Payment payment = paymentDao.selectById(id);
        returnSuccess(payment);
    }

    @GetMapping("getService")
    public void getService(){
        Applications applications = discoveryClient.getApplications();
        List<Application> list = applications.getRegisteredApplications();
        list.forEach(application -> {
            String name = application.getName();
            System.out.println(name);
            List<InstanceInfo> instances = discoveryClient.getInstancesById(name);
            instances.forEach(instance -> {
                String ipAddr = instance.getIPAddr();
                String homePageUrl = instance.getHomePageUrl();
                System.out.println("  " + ipAddr + "  " + homePageUrl);
            });
        });

    }

    @GetMapping("getRest")
    public void getRest(){
        //restTemplate.getForObject("", "", "")
    }


}

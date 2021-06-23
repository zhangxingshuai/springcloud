package com.controller;

import com.dao.PaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import javax.annotation.Resource;

@Controller
@RequestMapping("/payment")
@EnableDiscoveryClient
public class PaymentController extends BaseController{
    @Resource
    private PaymentDao paymentDao;
    @Autowired
    private RestTemplate restTemplate;

    private String ORDER_SERVICE_URL = "http://order-service:8081";

//    @Autowired
//    DiscoveryClient discoveryClient;
//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//
//
//    private RestTemplate restTemplate = restTemplate();


//    @GetMapping("/getPaymentById/{id}")
//    public void getPaymentById(@PathVariable(name = "id", required = false) Integer id){
//        Payment payment = paymentDao.selectById(id);
//        returnSuccess(payment);
//    }
//
//    @GetMapping("/getService")
//    public void getService(){
////        Applications applications = discoveryClient.getApplications();
////        List<Application> list = applications.getRegisteredApplications();
////        list.forEach(application -> {
////            String name = application.getName();
////            System.out.println(name);
////            List<InstanceInfo> instances = discoveryClient.getInstancesById(name);
////            instances.forEach(instance -> {
////                String ipAddr = instance.getIPAddr();
////                String homePageUrl = instance.getHomePageUrl();
////                System.out.println("  " + ipAddr + "  " + homePageUrl);
////            });
////        });
//
//    }
//
    @GetMapping("/getOrder")
    public void getRest(){
        //String result = new RestTemplate().getForObject("https://ORDER-SERVICE/api/getServer", String.class);
        String result = restTemplate.getForObject(ORDER_SERVICE_URL + "/api/getServer", String.class);
        System.out.println("payment-service调用orderService: " + result);
        returnSuccess(result);
    }


}

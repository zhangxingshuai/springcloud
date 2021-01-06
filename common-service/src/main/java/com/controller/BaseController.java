package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.enums.StatusEnum;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public abstract class BaseController {

    public void returnSuccess(Object data){

        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();

        JSONObject result = new JSONObject();
        result.put("code", StatusEnum.success.getValue());
        result.put("data", data);
        try {
            response.getWriter().write(result.toJSONString());
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void returnFailure(Object data){

        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        JSONObject result = new JSONObject();
        result.put("code", StatusEnum.failure.getValue());
        result.put("data", data);
        try {
            response.getWriter().write(result.toJSONString());
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


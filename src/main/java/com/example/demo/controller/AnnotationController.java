package com.example.demo.controller;

import com.example.demo.components.annotation.CurrentUser;
import com.example.demo.components.annotation.MyRequestParam;
import com.example.demo.entity.common.ObjectDataResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.rmi.Naming;

/**
 * @author chen_bq
 * @description 这是一个测试自定义注解的controller
 * @create: 2019-03-13 14:00
 **/
@Controller
public class AnnotationController {

    @RequestMapping("test")
    @ResponseBody
    public ObjectDataResponse testAnnotation(@MyRequestParam String param1,
                                             @MyRequestParam(value = "param2") String param2){
        System.out.println("param1:  " + param1);
        System.out.println("param2:  " + param2);
        return ObjectDataResponse.builder().build();
    }

    @RequestMapping("test2")
    @ResponseBody
    public String testAnnotation2(@CurrentUser String testParam, HttpServletRequest request){
        request.setAttribute("user","阿萨德");
        System.out.println(testParam!=null?testParam:"null");
        return "hello world";
    }



}
